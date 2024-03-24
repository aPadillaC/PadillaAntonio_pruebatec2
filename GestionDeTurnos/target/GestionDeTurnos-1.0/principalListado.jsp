
<%@page import="com.hackandboss.gestiondeturnos.logica.Turno"%>
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
            
                <% if (request.getAttribute("listadoOrdenado") == null) { %>
                    <div class="d-flex justify-content-around centered">
                        <form action="ListadoTurnosSV" method="get">
                            <button class="btn btn-lg btn-primary p-5 btn-circle custom-box-shadow custom-text-shadow" type="submit">Listado Total</button>
                        </form>

                        <form action="TurnosFechaSV" method="get">
                            <input type="hidden" name="orden" value="desc"> 
                            <button class="btn btn-lg btn-primary p-5 btn-circle custom-box-shadow custom-text-shadow" type="submit">Busqueda personalizada por Fecha</button>
                        </form>
                    </div>                  
                <% } %>
        
                
                
                <!-- Tabla de total turnos pendientes -->
                <% if (request.getAttribute("listadoOrdenado") != null) { %>
                    <div class="bg-container">
                        <h2 class="custom-text-shadow">Listado turnos pendientes:</h2>
                        <table class="table mt-3 table-info custom-box-shadow">
                            <thead>
                                <tr>
                                    <th>Nº turno</th>
                                    <th>Fecha</th>
                                    <th>Tramite</th>
                                    <th>Estado</th>

                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                List<Turno> listadoOrdenado = (List<Turno>) request.getAttribute("listadoOrdenado");
                                for ( Turno turno : listadoOrdenado) { 
                                %>
                                    <tr>
                                        <td><%= turno.getId() %></td>
                                        <td><%= turno.getFecha()%></td>
                                        <td><%= turno.getTramite().getDescripcion()%></td>                               
                                        <td><%= turno.isEstadoCompletado() ? "Atendido" : "En Espera" %></td>
                                        <td>
                                            <form action="ListadoTurnosSV" method="post">
                                                <input type="hidden" name="id" value="<%= turno.getId()%>">
                                                <button type="submit" class="btn btn-success custom-box-shadow">Atender</button>
                                            </form>
                                        </td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-primary custom-box-shadow mt-3"><a href="vistaPrincipal.jsp" class="text-decoration-none text-white">Volver al menú principal</a></button>
                    </div>
                <% } %>
            </div>
        
        </div>
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
