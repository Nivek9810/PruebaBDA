<%-- 
    Document   : index
    Created on : 24-may-2018, 19:48:55
    Author     : user
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Prueba BDA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 class="display-4">Prueba BDA <% try {
                    HttpSession sessionStatus = request.getSession();
                    if (sessionStatus.getAttribute("usuario") != null) {
                        out.print(" | " + sessionStatus.getAttribute("usuario"));
                    } else if (sessionStatus.getAttribute("cliente") != null) {
                        out.print(" | " + sessionStatus.getAttribute("cliente"));
                    } else {
                        //response.sendRedirect("index.jsp");
                        out.print("");
                    }

                %></h1> <br>
            <div class="row">
                <div class="col-3">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Home</a>
                        <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Categoria de habitación</a>
                        <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Locaciones</a>
                        <%if (session.getAttribute("cliente") != null) {
                        %>
                        <form  method="GET" action="Enviar">
                            <input type="text" name="enviar" value="Si" hidden>
                            <button type="submit" class="btn btn-outline-info">Salir</button>
                        </form>
                        <%} %>
                    </div>
                </div>
                <div class="col-9">
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"><ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Inicio</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Sobre Nosotros</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">Contactenos</a>
                                </li>

                                <%if (session.getAttribute("usuario") != null) {%>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#reserva" role="tab" aria-controls="contact" aria-selected="false">Reserva</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#servicios" role="tab" aria-controls="contact" aria-selected="false">Servicios</a>
                                </li>
                                <%} else if (session.getAttribute("cliente") != null) {
                                %>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#reserva" role="tab" aria-controls="contact" aria-selected="false">Reserva</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#servicios" role="tab" aria-controls="contact" aria-selected="false">Servicios</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#cambiocontraseña" role="tab" aria-controls="contact" aria-selected="false">Cambio Contraseña</a>
                                </li>
                                <%
                                } else {%>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#login" role="tab" aria-controls="contact" aria-selected="false">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#registrarse" role="tab" aria-controls="contact" aria-selected="false">Registrarse</a>
                                </li>
                                <%}
                                %>

                                <%} catch (Exception e) {
                                        response.sendRedirect("index.jsp");
                                    }

                                %>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <br>

                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="container">
                                        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                                            <ol class="carousel-indicators">
                                                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                                                <li data-target="#carouselExampleCaptions" data-slide-to="1" class=""></li>
                                                <li data-target="#carouselExampleCaptions" data-slide-to="2" class=""></li>
                                                <li data-target="#carouselExampleCaptions" data-slide-to="3" class=""></li>
                                            </ol>
                                            <div class="carousel-inner">
                                                <div class="carousel-item active">
                                                    <img class="d-block w-100" data-src="holder.js/800x400?auto=yes&amp;bg=777&amp;fg=555&amp;text=First slide" alt="First slide [800x400]" src="Img/slideshow.jpg" data-holder-rendered="true">
                                                    <div class="carousel-caption d-none d-md-block">
                                                        <h5>Cartagena</h5>
                                                        <p>Sin duda algúna, un lugar maravilloso.</p>
                                                    </div>
                                                </div>
                                                <div class="carousel-item">
                                                    <img class="d-block w-100" data-src="holder.js/800x400?auto=yes&amp;bg=666&amp;fg=444&amp;text=Second slide" alt="Second slide [800x400]" src="Img/slideshow1.jpg" data-holder-rendered="true">
                                                    <div class="carousel-caption d-none d-md-block">
                                                        <h5>Bahamas</h5>
                                                        <p>Es un lugar paradisiaco, que no te puedes perder.</p>
                                                    </div>
                                                </div>
                                                <div class="carousel-item">
                                                    <img class="d-block w-100" data-src="holder.js/800x400?auto=yes&amp;bg=666&amp;fg=444&amp;text=Four slide" alt="Second slide [800x400]" src="Img/slideshow2.jpg" data-holder-rendered="true">
                                                    <div class="carousel-caption d-none d-md-block">
                                                        <h5>Cancún</h5>
                                                        <p>Si quieres descansar, ésta es tu mejor opción.</p>
                                                    </div>
                                                </div>
                                                <div class="carousel-item">
                                                    <img class="d-block w-100" data-src="holder.js/800x400?auto=yes&amp;bg=555&amp;fg=333&amp;text=Third slide" alt="Third slide [800x400]" src="Img/slideshow3.jpg" data-holder-rendered="true">
                                                    <div class="carousel-caption d-none d-md-block">
                                                        <h5>Miami</h5>
                                                        <p>Te aseguro que tus vacaciones serán inolvidables.</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                <span class="sr-only">Anterior</span>
                                            </a>
                                            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                <span class="sr-only">Siguiente</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>

                                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    <p class="lead">
                                        Somos los mejores anfitriones buscamos que nuestros clientes tengan la mejor experiencia de hospedaje en sus vacaciones. 
                                        Somos un hotel 5 estrellas, brindamos confort y comodidad. 
                                    </p>
                                </div>
                                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                                    <h1 class="display-4">¿Donde estamos?</h1>
                                    <div id="map" style=" height: 400px; width: 100%;" class="container"></div>
                                    <script>
                                        function initMap() {

                                            var lati = 4.579369
                                            var long = -74.1576528
                                            var uluru = {lat: lati, lng: long}

                                            var map = new google.maps.Map(document.getElementById('map'), {
                                                zoom: 18,
                                                center: uluru
                                            });
                                            var marker = new google.maps.Marker({
                                                position: uluru,
                                                map: map
                                            });
                                        }
                                    </script>
                                </div>
                                <div class="tab-pane fade" id="login" role="tabpanel" aria-labelledby="profile-tab">
                                    <h1><i>Bienvenido</i></h1>
                                    <form action="ServletSesionL" method="POST">
                                        <div class="form-row">
                                            <div class="form-group col-md-2">
                                                <img src="Img/user.png" width="150" height="150" align="left" />
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group col-md-12">
                                                    <label>User</label> <input type="number" name="user" class="form-control" required  />
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label>Pass</label> <input type="password" name="password" class="form-control" required />
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <button type="submit" class="btn btn-primary">Enviar</button>
                                                </div>
                                            </div>
                                        </div>

                                    </form>

                                </div>
                                <div class="tab-pane fade" id="cambiocontraseña" role="tabpanel" aria-labelledby="profile-tab">

                                    <form method="POST" action="ServletContrasena">

                                        <div class="form-row">
                                            <div class="col-md-4 mb-3">
                                                <label for="validationDefault01">Nueva Contraseña</label>
                                                <input type="text" class="form-control" name="password" id="validationDefault01" placeholder="Contraseña" required>
                                            </div>
                                            <div class="col-md-4 mb-3">
                                                <label for="validationDefault02">Anterior Contraseña</label>
                                                <input type="text" class="form-control" name="passwordn" id="validationDefault02" placeholder="contraseña" required>
                                            </div>
                                            <!-- 
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationDefault02">Identificacion</label>
                                                    <input type="text" class="form-control" name="user" id="validationDefault02" placeholder="Identificador" required>
                                                </div>
                                            -->
                                        </div>
                                        <br>


                                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Cambio de Contraseña</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <h3>¿Estas seguro que quieres cambiar tu contraseña?</h3>
                                                        <hr>
                                                        <p>De ser cierto, se te enviará un correo de exito.</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                        <button type="submit" class="btn btn-primary">Aceptar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Enviar</button>

                                </div>
                                <div class="tab-pane fade" id="registrarse" role="tabpanel" aria-labelledby="profile-tab">
                                    <form method="POST" action="Enviar">
                                        <div class="form-row">
                                            <div class="col-md-4 mb-3">
                                                <label for="validationDefault01">Nombre</label>
                                                <input type="text" class="form-control" name="nombre" id="validationDefault01" placeholder="Nombre(s)" required>
                                            </div>
                                            <div class="col-md-4 mb-3">
                                                <label for="validationDefault02">Apellido</label>
                                                <input type="text" class="form-control" name="apellido" id="validationDefault02" placeholder="Apellido(s)" required>
                                            </div>
                                            <div class="col-md-4 mb-3">
                                                <label for="select01">Nacionalidad</label>
                                                <select id="select01" class="custom-select" name="nacionalidad">
                                                    <option selected>Selecciona una nacionalidad</option>
                                                    <%                                                        DAO_Persona obj_Per = new DAO_Persona();
                                                        ArrayList<DTO_Nacionalidad> lista = obj_Per.listarNacionalidad();
                                                        for (int idx = 0; idx < lista.size(); idx++) {
                                                    %>
                                                    <option value="<% out.print(lista.get(idx).getId_Nacio()); %>"><% out.print(lista.get(idx).getPais_Origen());  %></option>
                                                    <%                                                        }
                                                    %>
                                                </select>
                                            </div>

                                        </div>
                                        <div class="form-row">
                                            <div class="col-md-4 mb-2">
                                                <label for="selectTipo">Tipo de documento</label>
                                                <select id="selectTipo" class="custom-select" name="tipodoc">

                                                    <option selected>Tipo de Documento</option>
                                                    <%
                                                        ArrayList<DTO_Tipo_Doc> listaD = obj_Per.listarTipoDoc();
                                                        for (int idy = 0; idy < listaD.size(); idy++) {
                                                    %>
                                                    <option value="<% out.print(listaD.get(idy).getId_Tipo_Doc()); %>"><% out.print(listaD.get(idy).getTipo_Docu());  %></option>
                                                    <%                                                        }
                                                    %>
                                                </select>
                                            </div>
                                            <div class="col-md-4 mb-2">
                                                <label for="doc">Documento:</label>
                                                <input type="number" id="doc" class="form-control" placeholder="Ingresa el documento" required name="doc">
                                            </div>                                            
                                            <div class="col-md-4 mb-2">
                                                <label for="Correo">Correo</label>
                                                <input type="email" id="Correo" class="form-control" placeholder="Digite su correo" required name="correo">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="modal fade" id="registroModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Registrarse</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>¿Has enviado todos los datos?</p>
                                                        <hr>
                                                        <p>De ser cierto, te llegará un correo que te permitirá acceder a la plataforma, allí te enviaremos tu nueva contraseña.</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerar</button>
                                                        <button type="submit" class="btn btn-primary">Aceptar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#registroModal">Enviar</button>
                                </div>
                                <div class="tab-pane fade" id="reserva" role="tabpanel" aria-labelledby="profile-tab">
                                    <form method="POST" enctype="ServletReserva">
                                        <div class="form-group col-md-6">
                                            
                                            <label for="tipoh">Tipo Habitacion</label>
                                            
                                            <select id="tipoh" class="custom-select" name="tipohabitacion">
                                                <option selected>Selecciona una habitacion</option>
                                                <%                                                        DAO_Habitacion obj_h = new DAO_Habitacion();
                                                        ArrayList<DTO_Tipo_Habitacion> listaTh = obj_h.listatp();
                                                        for (int ida = 0; ida < listaTh.size(); ida++) {
                                                %>
                                                <option value="<% out.print(listaTh.get(ida).getId_Tipo()); %>"><% out.print(listaTh.get(ida).getTipo_h());  %></option>
                                                    <%                                                        }
                                                    %>
                                                  
                               
                                            </select>

                                        </div>
                                        <div class="form-group col-md-4">
                                            Fecha de Inicio<input type="date" class="form-control ">
                                        </div>
                                        <div class="form-group col-md-4">
                                            Fecha de Salida<input type="date" class="form-control ">
                                        </div>
                                        <div class="form-group col-md-4">
                                            Numero de Personas
                                            <select id="inputState" class="form-control" name="nropersona">
                                                <option selected>Selecciona cantidad</option>
                                                
                                               
                                               
                                            </select>
                                        </div>
                                        <br><br>
                                        <div class="form-group col-md-4">  
                                            <button type="submit" class="btn btn-primary" >Reservar</button>
                                        </div>

                                    </form>
                                </div>
                                <div class="tab-pane fade" id="servicios" role="tabpanel" aria-labelledby="profile-tab">
                                    Ser
                                </div>

                            </div>
                        </div>
                        <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                            <div class="card-deck">
                                <div class="card-deck">
                                    <% for (int i = 0; i < 10; i++) {
                                        
                                        }
                                    %>
                                    <div class="card">
                                        <img class="card-img-top" src="Img/habitacion0.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>

                                        </div>
                                        <div class="card-footer">
                                            <a href="#" class="btn btn-outline-primary">Reservar</a>
                                            <!--<small class="text-muted">Last updated 3 mins ago</small>-->
                                        </div>
                                    </div>
                                    <div class="card">
                                        <img class="card-img-top" src="Img/habitacion1.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>

                                        </div>
                                        <div class="card-footer">
                                            <a href="#" class="btn btn-outline-primary">Reservar</a>
                                            <!--<small class="text-muted">Last updated 3 mins ago</small>-->
                                        </div>
                                    </div>
                                    <div class="card">
                                        <img class="card-img-top" src="Img/habitacion2.jpg" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">Card title</h5>
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>

                                        </div>
                                        <div class="card-footer">
                                            <a href="#" class="btn btn-outline-primary">Reservar</a>
                                            <!--<small class="text-muted">Last updated 3 mins ago</small>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">

                        </div>
                        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">...</div>

                    </div>
                </div>
            </div>
            <br>
            <br>
            <div class="card">
                <div class="card-header">
                    Información
                </div>
                <div class="card-body">
                    <blockquote class="blockquote mb-0">
                        <p>Hospedaje Real &COPY;</p>
                        <footer class="blockquote-footer"><strong>Teléfono: </strong><cite title="Source Title">308 995 7836 - 4763587</cite>

                        </footer>
                        <footer class="blockquote-footer">
                            <strong>Dirección: </strong><cite title="Source Title">Calle 68 Sur #51-99, Bogotá</cite>
                        </footer>
                    </blockquote>
                </div>
            </div>

        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDtFij2OgJyzhlDHZthxHGTlh452YPhDSo&callback=initMap"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>

