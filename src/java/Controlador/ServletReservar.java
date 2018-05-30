/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.util.logging.resources.logging;

/**
 *
 * @author user
 */
public class ServletReservar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cliente = request.getParameter("idcliente");
        String empleado = request.getParameter("id_empleado");
        int nroPersona = Integer.parseInt(request.getParameter("cantper"));
        float pago = Float.parseFloat(request.getParameter("pago"));
        String fecha_InicioF = request.getParameter("fechain");
        String fecha_SalF = request.getParameter("fechasal");
        int nroHabitacion = Integer.parseInt(request.getParameter("nroHab"));
        DTO_Reserva objRes = null;
        DTO_Reserva_Habitacion objResH = null;
        int idreserva = 0;

        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_inicio = null;
        Date fecha_sal = null;
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css' integrity='sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4' crossorigin='anonymous'>");
        out.println("<title>Reserva</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");

        try {
            fecha_inicio = formatter.parse(fecha_InicioF);
            fecha_sal = formatter.parse(fecha_SalF);
        } catch (ParseException e) {
            out.println("<p><strong>" + e.getLocalizedMessage() + "</strong></p>");
        }

        try {

            //Extra
            DAO_Persona objPerDAO = new DAO_Persona();
            DAO_Cliente objClienDAO = new DAO_Cliente();

            DTO_Persona objPer;

            String id_cliente;
            Email objEml = new Email();
            String correo;

            try {
                if (cliente.isEmpty() || !request.getSession().getAttribute("user").toString().isEmpty()) {
                    id_cliente = request.getSession().getAttribute("user").toString();
                    objClienDAO.infoCliente(id_cliente).getId_PerosonaFK();
                    objPer = objPerDAO.infoUser(objClienDAO.infoCliente(id_cliente).getId_PerosonaFK());

                } else {
                    objPer = objPerDAO.infoUser(cliente);
                    correo = objPer.getCorreo();
                    id_cliente = objClienDAO.crearUsuarioRes(cliente, nroHabitacion);
                    DTO_Cliente objCliente = objClienDAO.infoCliente(id_cliente);
                    String MensajeNU = "Hola " + objPer.getNombre() + ", acabaste de hacer una reserva para la fecha " + fecha_InicioF + " al " + fecha_SalF + " \n"
                            + "Te acabamos de asignar una nueva contraseña para acceder a nuestra plataforma: \n\n "
                            + "- Usuario: " + objCliente.getId_PerosonaFK() + "\n "
                            + "- Contraseña: " + objCliente.getContrasenaC() + "\n"
                            + "Recuerda revisar tus reservas en nuestra plataforma. Y CAMBIAR TU CONTRASEÑA \n\n"
                            + "Que tengas un lindo día " + objPer.getNombre();
                    String AsuntoNU = "HospedajeReal | Nueva contraseña " + objPer.getNombre();
                    if (objEml.enviarCorreo(correo, MensajeNU, AsuntoNU, null)) {
                        out.println("<script type='application/javascript'> alert('Se te notificará al correo " + objPer.getCorreo() + " tu nueva contraseña.'); </script>");
                    }
                }
            } catch (NullPointerException ex) {
                ex.getMessage();
                objPer = objPerDAO.infoUser(cliente);
                correo = objPer.getCorreo();
                id_cliente = objClienDAO.crearUsuarioRes(cliente, nroHabitacion);
                DTO_Cliente objCliente = objClienDAO.infoCliente(id_cliente);
                String MensajeNU = "Hola " + objPer.getNombre() + ", acabaste de hacer una reserva para la fecha " + fecha_InicioF + " al " + fecha_SalF + " \n"
                        + "Te acabamos de asignar una nueva contraseña para acceder a nuestra plataforma: \n\n "
                        + "- Usuario: " + objCliente.getId_PerosonaFK() + "\n "
                        + "- Contraseña: " + objCliente.getContrasenaC() + "\n"
                        + "Recuerda revisar tus reservas en nuestra plataforma. Y CAMBIAR TU CONTRASEÑA \n\n"
                        + "Que tengas un lindo día " + objPer.getNombre();
                String AsuntoNU = "HospedajeReal | Nueva contraseña " + objPer.getNombre();
                if (objEml.enviarCorreo(correo, MensajeNU, AsuntoNU, null)) {
                    out.println("<script type='application/javascript'> alert('Se te notificará al correo " + objPer.getCorreo() + " tu nueva contraseña.'); </script>");
                }
            }
            correo = objPer.getCorreo();

            DAO_Reserva objResDAO = new DAO_Reserva();
            objRes = new DTO_Reserva(pago, empleado, id_cliente, nroPersona);
            idreserva = objResDAO.generarReservaLlegada(objRes);
            String Mensaje = "Hola " + objPer.getNombre() + ", acabaste de hacer una reserva para la fecha " + fecha_InicioF + " al " + fecha_SalF + " \n"
                    + "Estos son los datos en detalle: \n\n "
                    + "- Nro de Reserva: " + idreserva + "\n "
                    + "- Nro de Habitación: " + nroHabitacion + "\n"
                    + "Recuerda revisar tus reservas en nuestra plataforma. \n\n"
                    + "Que tengas un lindo día " + objPer.getNombre();
            String Asunto = "HospedajeReal | Registro de tu reserva " + objPer.getNombre();

            objResH = new DTO_Reserva_Habitacion(idreserva, nroHabitacion, fecha_inicio, fecha_sal);
            if (objResDAO.generarReservaHabitacion(objResH)) {
                out.println("<script type='application/javascript'> alert('Se te notificará al correo " + objPer.getNombre() + ".'); "
                        + "window.location.href='index.jsp'; </script>");
                if (objEml.enviarCorreo(correo, Mensaje, Asunto, null)) {
                    out.println("<h1 class='display-4'> Revisa el correo: " + objPer.getCorreo() + ". \n Se te envio el correo. </h1>");
                } else {
                    out.println("<div class='alert alert-danger' role='alert'> No se te pudo enviar el correo " + objPer.getNombre()
                            + "</div>");
                }

            }

        } catch (SQLException ex) {
            out.println("</h2>" + ex.getLocalizedMessage() + "<br><br>" + ex.getSQLState() + " Cliente: " + cliente + " <br> y Sessión: " + request.getSession().getAttribute("user").toString() + "</h2>");
        }

        out.println("</div>");
        out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js' integrity='sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ' crossorigin='anonymous'></script>");
        out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js' integrity='sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm' crossorigin='anonymous'></script>");
        out.println("</body>");
        out.println("</html>");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
