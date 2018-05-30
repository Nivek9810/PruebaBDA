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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class ServletVerReserva extends HttpServlet {

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
        int tipohabitacion = Integer.parseInt(request.getParameter("tipohabitacion"));
        String fecha_InicioF = request.getParameter("Fecha_in");
        String fecha_SalF = request.getParameter("Fecha_sal");
        int nropersona = Integer.parseInt(request.getParameter("nroper"));
        String identificador = request.getParameter("identificacion");
        String empleado = (String) request.getSession().getAttribute("usuario");
        float pago = Float.parseFloat(request.getParameter("pago"));
        if (empleado == null) {
            empleado = "5010";
        }
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_inicio = null;
        Date fecha_sal = null;
        try {
            fecha_inicio = formatter.parse(fecha_InicioF);
            fecha_sal = formatter.parse(fecha_SalF);
        } catch (ParseException ex) {
            Logger.getLogger(ServletVerReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>");
        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css' integrity='sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4' crossorigin='anonymous'>");
        out.println("<title>Home</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        try {
            DAO_Reserva objRes = new DAO_Reserva();

            ArrayList<DTO_Habitacion> lstH = objRes.buscarReserva(fecha_inicio, fecha_sal, nropersona, tipohabitacion);

            out.println("<div class='modal fade bd-example-modal-lg' id='exampleModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel' aria-hidden='true'>");
            out.println("<div class='modal-dialog modal-lg' role='document'>");
            out.println("            <div class='modal-content'>");
            out.println("                <div class='modal-header'>");
            out.println("                    <h5 class='modal-title' id='exampleModalLabel'>Listado de opciones para el tipo de habitación seleccionado </h5>");
            out.println("                </div>");
            out.println("                <div class='modal-body'>");
            if (lstH.isEmpty()) {
                out.println("<div class='alert alert-warning' role='alert'>");
                out.println(" <p class='lead'>Es probable que no haya habitaciones disponibles según las características que buscas</p>");
                out.println("</div>");
            } else {
                out.println("                   <form method='POST' action='ServletReservar'>");
                out.println("                   <table class='table table-striped'>");
                out.println("                        <thead class='thead-dark'>");
                out.println("                            <tr>");
                out.println("                                <th scope='col'>#</th>");
                out.println("                                <th scope='col'>Costo</th>");
                out.println("                                <th scope='col'>Descripción</th>");
                out.println("                                <th scope='col'>Nro. Personas</th>");
                out.println("                                <th scope='col'>Reserva</th>");
                out.println("                            </tr>");
                out.println("                        </thead>");
                out.println("                        <tbody>");
                for (int i = 0; i < lstH.size(); i++) {
                    out.println("                            <tr>");
                    out.println("                                <th scope='row'>" + lstH.get(i).getNro_Habitacion() + "</th>");
                    out.println("                                <td>" + lstH.get(i).getValor_Habitacion() + "</td>");
                    out.println("                                <td>" + lstH.get(i).getDescripcion() + "</td>");
                    out.println("                                <td>" + lstH.get(i).getNro_persona() + "</td>");
                    out.println("                                <td>");
                    out.println("                                    <input type='date' class='form-control' name='fechain' value='" + fecha_InicioF + "' hidden>");
                    out.println("                                    <input type='date' class='form-control' name='fechasal' value='" + fecha_SalF + "' hidden>");
                    out.println("                                    <input type='text' class='form-control' name='idcliente' value='" + identificador + "' hidden>");
                    out.println("                                    <input type='text' class='form-control' name='cantper' value='" + nropersona + "' hidden>");
                    out.println("                                    <input type='text' class='form-control' name='pago' value='" + pago + "' hidden>");
                    out.println("                                    <input type='text' class='form-control' name='id_empleado' value='" + empleado + "' hidden>");
                    out.println("                                    <div class='custom-control custom-radio'>");
                    if (i == 0) {
                        out.println("                                        <input type='radio' value='" + lstH.get(i).getNro_Habitacion() + "' id='customRadio" + i + "' name='nroHab' class='custom-control-input' checked>");
                    } else {
                        out.println("                                        <input type='radio' value='" + lstH.get(i).getNro_Habitacion() + "' id='customRadio" + i + "' name='nroHab' class='custom-control-input'>");
                    }
                    out.println("                                        <label class='custom-control-label' for='customRadio" + i + "'>Reservar</label>");
                    out.println("                                    </div></td>");
                    out.println("                            </tr>");
                }
                out.println("                       </tbody>");
                out.println("                    </table>");

            }
            out.println("                </div>");
            out.println("                <div class='modal-footer'>");
            if (!lstH.isEmpty()) {
                out.println("                    <input type='submit' class='btn btn-outline-success' value='Reservar' >");
            }

            out.println("                    <a role='button' class='btn btn-outline-primary' href='index.jsp'>Volver</a>");
            out.println("                    ");
            out.println("                   </form>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("        </div>");
            out.println("    </div>");

        } catch (SQLException ex) {
            out.println("<h3>" + ex.getLocalizedMessage() + "<br><br>" + ex.getMessage() + "<br><br>" + ex.getSQLState() + "</h3>");
            //response.sendRedirect("index.jsp");
        }
        out.println("</div>");
        out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js' integrity='sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ' crossorigin='anonymous'></script>");
        out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js' integrity='sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm' crossorigin='anonymous'></script>");
        out.println("<script>$('#exampleModal').modal({ show: true, keyboard: false, backdrop: 'static'});</script>");
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
