/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO_Cliente;
import Modelo.DAO_Empleado;
import Modelo.DAO_Persona;
import Modelo.DTO_Cliente;
import Modelo.DTO_Empleado;
import Modelo.DTO_Persona;
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
public class ServletSesionL extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
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
        try {
            HttpSession sesion = request.getSession();
            DAO_Cliente Login = new DAO_Cliente();
            DAO_Empleado objEmpDAO = new DAO_Empleado();
            DAO_Persona objPerDAO = new DAO_Persona();
            String usu, pass;
            usu = request.getParameter("user");
            pass = request.getParameter("password");
            DTO_Cliente Usuario = Login.SessionU(usu, pass);
            DTO_Empleado objEmp = objEmpDAO.SessionE(usu, pass);
            
            DTO_Persona objPerE = objPerDAO.infoUser(objEmp.getId_PersonaFK());
            DTO_Persona objPerU = objPerDAO.infoUser(Usuario.getId_PerosonaFK());

            if (usu.equals(Usuario.getId_PerosonaFK()) && pass.equals(Usuario.getContrasenaC()) && sesion.getAttribute("cliente") == null) {
                //si coincide usuario y password y además no hay sesión iniciada
                sesion.setAttribute("cliente", objPerU.getNombre());
                sesion.setAttribute("user", Usuario.getId_Cliente());
                sesion.setAttribute("correo", objPerU.getCorreo());
                sesion.setMaxInactiveInterval(60);
                //redirijo a página con información de login exitoso
                response.sendRedirect("index.jsp");

            } else if (usu.equals(objEmp.getId_Empleado()) && pass.equals(objEmp.getContrasena()) && sesion.getAttribute("usuario") == null) {
                sesion.setAttribute("usuario", objPerE.getNombre());
                sesion.setMaxInactiveInterval(60);
                response.sendRedirect("index.jsp");

            } else {
                response.sendRedirect("index.jsp");
                sesion.invalidate();
                //response.sendRedirect("home.jsp");
            }

        } catch (SQLException ex) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearUS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hay un error en at " + ex.getSQLState() + " y en " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
