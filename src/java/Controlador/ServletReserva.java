/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Familia MV
 */
public class ServletReserva extends HttpServlet {

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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipohabitacion = request.getParameter("tipohabitacion");
        String fecha_Inicio = request.getParameter("Fecha_in");
        String fecha_Sal = request.getParameter("Fecha_sal");
        int nropersona = Integer.parseInt(request.getParameter("nroper"));
        String identificador = request.getParameter("identificacion");
        double pago = Double.parseDouble(request.getParameter("pago"));

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

        out.println("<div class='modal fade bd-example-modal-lg' id='exampleModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel' aria-hidden='true'>");
        out.println("<div class='modal-dialog modal-lg' role='document'>");
        out.println("            <div class='modal-content'>");
        out.println("                <div class='modal-header'>");
        out.println("                    <h5 class='modal-title' id='exampleModalLabel'>Listado de </h5>");
        out.println("                </div>");
        out.println("                <div class='modal-body'>");
        out.println("                   <table class='table table-striped'>");
        out.println("                        <thead class='thead-dark'>");
        out.println("                            <tr>");
        out.println("                                <th scope='col'>#</th>");
        out.println("                                <th scope='col'>First</th>");
        out.println("                                <th scope='col'>Last</th>");
        out.println("                                <th scope='col'>Handle</th>");
        out.println("                            </tr>");
        out.println("                        </thead>");
        out.println("                        <tbody>");
        out.println("                            <tr>");
        out.println("                                <th scope='row'>1</th>");
        out.println("                                <td>Mark</td>");
        out.println("                                <td>Otto</td>");
        out.println("                                <td>@mdo</td>");
        out.println("                            </tr>");
        out.println("                       </tbody>");
        out.println("                    </table>");
        out.println("                    ...\n");
        out.println("                </div>");
        out.println("                <div class='modal-footer'>");
        out.println("                    <a role='button' class='btn btn-outline-primary' href='index.jsp'>Volver</a>");
        out.println("                    <button type='button' class='btn btn-outline-success'>Save changes</button>");
        out.println("                </div>");
        out.println("            </div>");
        out.println("        </div>");
        out.println("    </div>");

        out.println("</div>");
        out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js' integrity='sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ' crossorigin='anonymous'></script>");
        out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js' integrity='sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm' crossorigin='anonymous'></script>");
        out.println("<script>$('#exampleModal').modal({ show: true, keyboard: false, backdrop: 'static'});</script>");
        out.println("</body>");
        out.println("</html>");

        response.sendRedirect("index.jsp");
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
