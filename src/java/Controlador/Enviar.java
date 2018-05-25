package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modelo.Correo;
import Modelo.DAO_Persona;
import Modelo.DTO_Persona;
import Modelo.GeneradorPass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Estudiante
 */
public class Enviar extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        if (request.getParameter("enviar").equals("Si")) {
            sesion.invalidate();
            response.sendRedirect("index.jsp");
        } else {

        }
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int nacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
        int tipoDoc = Integer.parseInt(request.getParameter("tipodoc"));
        String documento = request.getParameter("doc");
        String correo = request.getParameter("correo");
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
            DAO_Persona objDP = new DAO_Persona();
            Correo mail = new Correo();
            GeneradorPass pass = new GeneradorPass();
            String Mensaje, Asunto;

            DTO_Persona objPer = objDP.crearUsuario(documento, nacionalidad, tipoDoc, nombre + " " + apellido, correo);
            HttpSession session = request.getSession();
            if (objPer.getId_persona().equals("")) {
                out.println("<script type='text/javascript'> alert('Lo sentimos el correo ya se encuentra registrado!'); "
                        + "window.location.href='index.jsp';</script>");
            } else {
                session.setAttribute("usuario", objPer.getNombre());
                session.setAttribute("correo", objPer.getCorreo());
                session.setAttribute("documento", objPer.getId_persona());
                Mensaje = "Bienvenido " + objPer.getNombre() + ", para nosotros es un gusto saber que eres parte de nosotros. "
                        + "Recuerda cambiar tu contraseña, cuando ingreses a la plataforma. "
                        + "Recuerda completar tu reserva";

                Asunto = objPer.getNombre() + " | Nueva contraseña";
                if (mail.enviarCorreo(correo, Mensaje, Asunto, null)) {
                    out.println("<script type='text/javascript'> alert('Correo enviado!'); </script>");
                } else {
                    out.println("<script type='text/javascript'> alert('Correo no enviado'); </script>");
                }
                session.setMaxInactiveInterval(60);
                response.sendRedirect("index.jsp");
            }

        } catch (SQLException ex) {

            out.println("<script type='text/javascript'> alert('Lo sentimos el usuario "+documento+" ya existe!'); "+ "window.location.href='index.jsp';</script>");
            out.println("<h3>"+ex.getLocalizedMessage()+"</h3>");
            out.println("<a role='button' class='btn btn-outline-primary' href='index.jsp'>Volver</a>");
            //response.sendRedirect("index.jsp");

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
