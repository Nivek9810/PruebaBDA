/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Correo;
import Modelo.DAO_Cliente;
import Modelo.DTO_Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Familia MV
 */
public class ServletContrasena extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CrearUS</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            DAO_Cliente cambio = new DAO_Cliente();
            HttpSession sesion = request.getSession();
            Correo email = new Correo();

            String usu, pass, passn, mensaje, asunto, correo;
            usu = (String) sesion.getAttribute("user");
            pass = request.getParameter("password");
            passn = request.getParameter("passwordn");
            correo = (String) sesion.getAttribute("correo");
            boolean Usuario = cambio.CambiarContra(usu, pass, passn);
            mensaje = sesion.getAttribute("cliente")+", tu contraseña ha sido actualizada exitosamente. \n"+pass.substring(0, 2)+"****  \n\n\nGracias por ser parte de nosotros.";
            asunto = "Cambio de contraseña | "+sesion.getAttribute("cliente");            
            
            if (Usuario) {
                email.enviarCorreo(correo, mensaje, asunto, null);
            }
            response.sendRedirect("index.jsp");

        } catch (SQLException ex) {

            out.println("<h1>Hay un error en at " + ex.getSQLState() + " y en " + ex.getMessage() + "</h1>");

        }
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
