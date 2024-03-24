
<%@page import="com.hackandboss.gestiondeturnos.logica.Tramite"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <%@ include file="navBar.jsp" %>
        <style>
            .bg-image {
                background-image: url('https://s7g10.scene7.com/is/image/bridgestoneeu/Homepage:DEFAULT_LARGE');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                height: 100vh; /* Ajusta la altura al 100% del viewport */
                 /* Elimina el margen predeterminado */
                width: 100%;
            }
            .custom-text-shadow {
              text-shadow: 4px 4px 8px rgba(0, 0, 0, 0.5); /* Ajusta los valores según tus preferencias */
            }

            .centered {
              transform: translate(0%, 75%);
            }
            .bg-container {
                background-color: RGBA(255,255,255, 0.8);
            }
            .custom-box-shadow {
              box-shadow:4px 4px 8px rgba(0, 0, 0, 0.5);
            }
            .btn-circle {
                width: 280px;
                height: 280px;
                border-radius: 50%;
                text-align: center;
                padding: 0;
                font-size: 20px;
                line-height: 50px; /* Alinea el texto verticalmente */
            }
            .bg-container {
                color: black;
                background-color: RGBA(255,255,255, 0.6);
                padding: 5vh;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="bg-image">
                
                
                <!-- Seleccionamos que deseamos hacer: Crear o Editar turno -->
                <% if (request.getAttribute("listaTramites") == null) { %>
                    <div class="d-flex justify-content-around centered">
                        <form action="TramitesSV" method="get">
                            <button type="submit" class="btn btn-lg btn-primary p-5 btn-circle custom-box-shadow custom-text-shadow">Crear nuevo</button>
                        </form>

                        <form>
                            <button  class="btn btn-lg btn-primary p-5 btn-circle custom-box-shadow custom-text-shadow"><a href="actualizacionTurnos.jsp" class="text-decoration-none text-white">Editar un turno<a/></button>
                        </form>
                    </div>
                <% } %>

                
                
                <!-- Formulario para el registro de un nuevo turno -->
                <% if (request.getAttribute("listaTramites") != null) { %>
                    <div class="bg-container pt-2">
                        <h1>Registro de nuevo turno</h1>
                        <form action="TurnoSV" method="post">
                            <div class="form-group w-25">
                                <label for="nombre">Ingrese su DNI: </label>
                                <input type="text" class="form-control custom-box-shadow" id="dni" name="dni" placeholder="Ingrese su DNI">
                            </div>
                            <div class="form-group w-25">
                                <label for="ciudad">Selecciona una opción</label>
                                <select class="form-control custom-box-shadow" name="tramite">
                                    <%  
                                        List<Tramite> listaTramites = (List<Tramite>) request.getAttribute("listaTramites");
                                        for ( Tramite tramite : listaTramites) {
                                    %>
                                        <option value="<%= tramite.getDescripcion() %>"><%= tramite.getDescripcion() %></option>
                                    <% } %>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary" name="guardar">Registrar</button>
                        </form>
                    </div>
                    
                <% } %>
            </div>
            
        </div>        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
