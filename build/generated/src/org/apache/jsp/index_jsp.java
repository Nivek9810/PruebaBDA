package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Modelo.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Prueba BDA</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <h1 class=\"display-4\">Prueba BDA ");
 try {
                    HttpSession sessionStatus = request.getSession();
                    if (sessionStatus.getAttribute("usuario") != null) {
                        out.print(" | " + sessionStatus.getAttribute("usuario"));
                    } else {
                        //response.sendRedirect("index.jsp");
                        out.print("");
                    }

                
      out.write("</h1> <br>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-3\">\r\n");
      out.write("                    <div class=\"nav flex-column nav-pills\" id=\"v-pills-tab\" role=\"tablist\" aria-orientation=\"vertical\">\r\n");
      out.write("                        <a class=\"nav-link active\" id=\"v-pills-home-tab\" data-toggle=\"pill\" href=\"#v-pills-home\" role=\"tab\" aria-controls=\"v-pills-home\" aria-selected=\"true\">Home</a>\r\n");
      out.write("                        <a class=\"nav-link\" id=\"v-pills-profile-tab\" data-toggle=\"pill\" href=\"#v-pills-profile\" role=\"tab\" aria-controls=\"v-pills-profile\" aria-selected=\"false\">Categoria de habitación</a>\r\n");
      out.write("                        <a class=\"nav-link\" id=\"v-pills-messages-tab\" data-toggle=\"pill\" href=\"#v-pills-messages\" role=\"tab\" aria-controls=\"v-pills-messages\" aria-selected=\"false\">Locaciones</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-9\">\r\n");
      out.write("                    <div class=\"tab-content\" id=\"v-pills-tabContent\">\r\n");
      out.write("                        <div class=\"tab-pane fade show active\" id=\"v-pills-home\" role=\"tabpanel\" aria-labelledby=\"v-pills-home-tab\"><ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link active\" id=\"home-tab\" data-toggle=\"tab\" href=\"#home\" role=\"tab\" aria-controls=\"home\" aria-selected=\"true\">Inicio</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\" aria-controls=\"profile\" aria-selected=\"false\">Sobre Nosotros</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" id=\"contact-tab\" data-toggle=\"tab\" href=\"#contact\" role=\"tab\" aria-controls=\"contact\" aria-selected=\"false\">Contactenos</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("\r\n");
      out.write("                                ");
if (session.getAttribute("usuario") != null) {
      out.write("\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" id=\"contact-tab\" data-toggle=\"tab\" href=\"#reserva\" role=\"tab\" aria-controls=\"contact\" aria-selected=\"false\">Reserva</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" id=\"contact-tab\" data-toggle=\"tab\" href=\"#servicios\" role=\"tab\" aria-controls=\"contact\" aria-selected=\"false\">Servicios</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");
} else {
      out.write("\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" id=\"contact-tab\" data-toggle=\"tab\" href=\"#login\" role=\"tab\" aria-controls=\"contact\" aria-selected=\"false\">Login</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\">\r\n");
      out.write("                                    <a class=\"nav-link\" id=\"contact-tab\" data-toggle=\"tab\" href=\"#registrarse\" role=\"tab\" aria-controls=\"contact\" aria-selected=\"false\">Registrarse</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                ");
} catch (Exception e) {
                                        response.sendRedirect("index.jsp");
                                    }

                                
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <div class=\"tab-content\" id=\"myTabContent\">\r\n");
      out.write("                                <br>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"tab-pane fade show active\" id=\"home\" role=\"tabpanel\" aria-labelledby=\"home-tab\">\r\n");
      out.write("                                    <div class=\"container\">\r\n");
      out.write("                                        <div id=\"carouselExampleCaptions\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("                                            <ol class=\"carousel-indicators\">\r\n");
      out.write("                                                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("                                                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"1\" class=\"\"></li>\r\n");
      out.write("                                                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"2\" class=\"\"></li>\r\n");
      out.write("                                                <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"3\" class=\"\"></li>\r\n");
      out.write("                                            </ol>\r\n");
      out.write("                                            <div class=\"carousel-inner\">\r\n");
      out.write("                                                <div class=\"carousel-item active\">\r\n");
      out.write("                                                    <img class=\"d-block w-100\" data-src=\"holder.js/800x400?auto=yes&amp;bg=777&amp;fg=555&amp;text=First slide\" alt=\"First slide [800x400]\" src=\"Img/slideshow.jpg\" data-holder-rendered=\"true\">\r\n");
      out.write("                                                    <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                                                        <h5>Cartagena</h5>\r\n");
      out.write("                                                        <p>Un lugar maravilloso.</p>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"carousel-item\">\r\n");
      out.write("                                                    <img class=\"d-block w-100\" data-src=\"holder.js/800x400?auto=yes&amp;bg=666&amp;fg=444&amp;text=Second slide\" alt=\"Second slide [800x400]\" src=\"Img/slideshow1.jpg\" data-holder-rendered=\"true\">\r\n");
      out.write("                                                    <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                                                        <h5>Second slide label</h5>\r\n");
      out.write("                                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"carousel-item\">\r\n");
      out.write("                                                    <img class=\"d-block w-100\" data-src=\"holder.js/800x400?auto=yes&amp;bg=666&amp;fg=444&amp;text=Four slide\" alt=\"Second slide [800x400]\" src=\"Img/slideshow2.jpg\" data-holder-rendered=\"true\">\r\n");
      out.write("                                                    <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                                                        <h5>Second slide label</h5>\r\n");
      out.write("                                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"carousel-item\">\r\n");
      out.write("                                                    <img class=\"d-block w-100\" data-src=\"holder.js/800x400?auto=yes&amp;bg=555&amp;fg=333&amp;text=Third slide\" alt=\"Third slide [800x400]\" src=\"Img/slideshow3.jpg\" data-holder-rendered=\"true\">\r\n");
      out.write("                                                    <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("                                                        <h5>Third slide label</h5>\r\n");
      out.write("                                                        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <a class=\"carousel-control-prev\" href=\"#carouselExampleCaptions\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("                                                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                                                <span class=\"sr-only\">Previous</span>\r\n");
      out.write("                                            </a>\r\n");
      out.write("                                            <a class=\"carousel-control-next\" href=\"#carouselExampleCaptions\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("                                                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                                                <span class=\"sr-only\">Next</span>\r\n");
      out.write("                                            </a>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"profile\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\r\n");
      out.write("                                    <p class=\"lead\">\r\n");
      out.write("                                        Somos los mejores anfitriones buscamos que nuestros clientes tengan la mejor experiencia de hospedaje en sus vacaciones. \r\n");
      out.write("                                        Somos un hotel 5 estrellas, brindamos confort y comodidad. \r\n");
      out.write("                                    </p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"contact\" role=\"tabpanel\" aria-labelledby=\"contact-tab\">\r\n");
      out.write("                                    <h1 class=\"display-4\">¿Donde estamos?</h1>\r\n");
      out.write("                                    <div id=\"map\" style=\" height: 400px; width: 100%;\" class=\"container\"></div>\r\n");
      out.write("                                    <script>\r\n");
      out.write("                                        function initMap() {\r\n");
      out.write("\r\n");
      out.write("                                            var lati = 4.579369\r\n");
      out.write("                                            var long = -74.1576528\r\n");
      out.write("                                            var uluru = {lat: lati, lng: long}\r\n");
      out.write("\r\n");
      out.write("                                            var map = new google.maps.Map(document.getElementById('map'), {\r\n");
      out.write("                                                zoom: 18,\r\n");
      out.write("                                                center: uluru\r\n");
      out.write("                                            });\r\n");
      out.write("                                            var marker = new google.maps.Marker({\r\n");
      out.write("                                                position: uluru,\r\n");
      out.write("                                                map: map\r\n");
      out.write("                                            });\r\n");
      out.write("                                        }\r\n");
      out.write("                                    </script>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"login\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\r\n");
      out.write("                                    Log\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"registrarse\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\r\n");
      out.write("                                    <form method=\"POST\" action=\"Enviar\">\r\n");
      out.write("                                        <div class=\"form-row\">\r\n");
      out.write("                                            <div class=\"col-md-4 mb-3\">\r\n");
      out.write("                                                <label for=\"validationDefault01\">Nombre</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"nombre\" id=\"validationDefault01\" placeholder=\"Nombre(s)\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-4 mb-3\">\r\n");
      out.write("                                                <label for=\"validationDefault02\">Apellido</label>\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"apellido\" id=\"validationDefault02\" placeholder=\"Apellido(s)\" required>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-4 mb-3\">\r\n");
      out.write("                                                <label for=\"select01\">Nacionalidad</label>\r\n");
      out.write("                                                <select id=\"select01\" class=\"custom-select\" name=\"nacionalidad\">\r\n");
      out.write("                                                    <option selected>Selecciona una nacionalidad</option>\r\n");
      out.write("                                                    ");
                                                        DAO_Persona obj_Per = new DAO_Persona();
                                                        ArrayList<DTO_Nacionalidad> lista = obj_Per.listarNacionalidad();
                                                        for (int idx = 0; idx < lista.size(); idx++) {
                                                    
      out.write("\r\n");
      out.write("                                                    <option value=\"");
 out.print(lista.get(idx).getId_Nacio()); 
      out.write('"');
      out.write('>');
 out.print(lista.get(idx).getPais_Origen());  
      out.write("</option>\r\n");
      out.write("                                                    ");
                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-row\">\r\n");
      out.write("                                            <div class=\"col-md-4 mb-2\">\r\n");
      out.write("                                                <label for=\"selectTipo\">Tipo de documento</label>\r\n");
      out.write("                                                <select id=\"selectTipo\" class=\"custom-select\" name=\"tipodoc\">\r\n");
      out.write("\r\n");
      out.write("                                                    <option selected>Tipo de Documento</option>\r\n");
      out.write("                                                    ");

                                                        ArrayList<DTO_Tipo_Doc> listaD = obj_Per.listarTipoDoc();
                                                        for (int idy = 0; idy < listaD.size(); idy++) {
                                                    
      out.write("\r\n");
      out.write("                                                    <option value=\"");
 out.print(listaD.get(idy).getId_Tipo_Doc()); 
      out.write('"');
      out.write('>');
 out.print(listaD.get(idy).getTipo_Docu());  
      out.write("</option>\r\n");
      out.write("                                                    ");
                                                        }
                                                    
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"col-md-4 mb-2\">\r\n");
      out.write("                                                <label for=\"doc\">Documento:</label>\r\n");
      out.write("                                                <input type=\"number\" id=\"doc\" class=\"form-control\" placeholder=\"Ingresa el documento\" required name=\"doc\">\r\n");
      out.write("                                            </div>                                            \r\n");
      out.write("                                            <div class=\"col-md-4 mb-2\">\r\n");
      out.write("                                                <label for=\"Correo\">Correo</label>\r\n");
      out.write("                                                <input type=\"email\" id=\"Correo\" class=\"form-control\" placeholder=\"Digite su correo\" required name=\"correo\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <br>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("                                            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                                                <div class=\"modal-content\">\r\n");
      out.write("                                                    <div class=\"modal-header\">\r\n");
      out.write("                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Registrarse</h5>\r\n");
      out.write("                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                                            <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                                        </button>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div class=\"modal-body\">\r\n");
      out.write("                                                        <p>¿Has enviado todos los datos?</p>\r\n");
      out.write("                                                        <hr>\r\n");
      out.write("                                                        <p>De ser cierto, te llegará un correo que te permitirá acceder a la plataforma, allí te enviaremos tu nueva contraseña.</p>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <div class=\"modal-footer\">\r\n");
      out.write("                                                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cerar</button>\r\n");
      out.write("                                                        <button type=\"submit\" class=\"btn btn-primary\">Aceptar</button>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                    <button class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\">Enviar</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"reserva\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\r\n");
      out.write("                                    Res\r\n");
      out.write("                                    <form  method=\"GET\" action=\"Enviar\">\r\n");
      out.write("                                        <input type=\"text\" name=\"enviar\" value=\"Si\" hidden>\r\n");
      out.write("                                        <input type=\"submit\" class=\"btn-primary\" value=\"Salir\">            \r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"tab-pane fade\" id=\"servicios\" role=\"tabpanel\" aria-labelledby=\"profile-tab\">\r\n");
      out.write("                                    Ser\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\" aria-labelledby=\"v-pills-profile-tab\">\r\n");
      out.write("                            <div class=\"card-deck\">\r\n");
      out.write("                                <div class=\"card-deck\">\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <img class=\"card-img-top\" src=\"Img/habitacion.jpg\" alt=\"Card image cap\">\r\n");
      out.write("                                        <div class=\"card-body\">\r\n");
      out.write("                                            <h5 class=\"card-title\">Card title</h5>\r\n");
      out.write("                                            <p class=\"card-text\">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"card-footer\">\r\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-outline-primary\">Reservar</a>\r\n");
      out.write("                                            <!--<small class=\"text-muted\">Last updated 3 mins ago</small>-->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <img class=\"card-img-top\" src=\"Img/habitacion2.jpg\" alt=\"Card image cap\">\r\n");
      out.write("                                        <div class=\"card-body\">\r\n");
      out.write("                                            <h5 class=\"card-title\">Card title</h5>\r\n");
      out.write("                                            <p class=\"card-text\">This card has supporting text below as a natural lead-in to additional content.</p>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"card-footer\">\r\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-outline-primary\">Reservar</a>\r\n");
      out.write("                                            <!--<small class=\"text-muted\">Last updated 3 mins ago</small>-->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <img class=\"card-img-top\" src=\"Img/habitacion3.jpg\" alt=\"Card image cap\">\r\n");
      out.write("                                        <div class=\"card-body\">\r\n");
      out.write("                                            <h5 class=\"card-title\">Card title</h5>\r\n");
      out.write("                                            <p class=\"card-text\">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"card-footer\">\r\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-outline-primary\">Reservar</a>\r\n");
      out.write("                                            <!--<small class=\"text-muted\">Last updated 3 mins ago</small>-->\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"tab-pane fade\" id=\"v-pills-profile\" role=\"tabpanel\" aria-labelledby=\"v-pills-profile-tab\">\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"tab-pane fade\" id=\"v-pills-messages\" role=\"tabpanel\" aria-labelledby=\"v-pills-messages-tab\">...</div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("                <div class=\"card-header\">\r\n");
      out.write("                    Información\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card-body\">\r\n");
      out.write("                    <blockquote class=\"blockquote mb-0\">\r\n");
      out.write("                        <p>Hospedaje Real &COPY;</p>\r\n");
      out.write("                        <footer class=\"blockquote-footer\"><strong>Teléfono: </strong><cite title=\"Source Title\">308 995 7836 - 4763587</cite>\r\n");
      out.write("\r\n");
      out.write("                        </footer>\r\n");
      out.write("                        <footer class=\"blockquote-footer\">\r\n");
      out.write("                            <strong>Dirección: </strong><cite title=\"Source Title\">Calle 68 Sur #51-99, Bogotá</cite>\r\n");
      out.write("                        </footer>\r\n");
      out.write("                    </blockquote>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Optional JavaScript -->\r\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("        <script async defer src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDtFij2OgJyzhlDHZthxHGTlh452YPhDSo&callback=initMap\"></script>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\" integrity=\"sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
