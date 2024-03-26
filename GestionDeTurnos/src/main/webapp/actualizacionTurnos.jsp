
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.hackandboss.gestiondeturnos.logica.Tramite"%>
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
              text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Ajusta los valores según tus preferencias */
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
            .bg-container {
                color: black;
                background-color: RGBA(255,255,255, 0.6);
                padding: 5vh;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            
            
                
                <!-- Solicitud del dni para mostrar todos los turnos del ciudadano -->
                <% if (request.getAttribute("tramites") == null) { %>
                <div class="bg-image">
                    <div class="bg-container pt-2">
                        <h1 class="custom-text-shadow">Editar Turno</h1>
                        <form action="TurnoSV" method="get">
                            <div class="form-group w-25 ">
                                <label for="nombre" class="custom-text-shadow">Introduce su DNI para mostrar sus tramites pendientes:  </label>
                                <input type="text" class="form-control custom-box-shadow" id="dni" name="dni" placeholder="11111111X">
                                <% 
                                    String error = (String) request.getAttribute("error");
                                    if (error != null) {
                                %>
                                <div class=" font-weight-bold text-danger"><%= error %></div>
                                <% } %>
                            </div>
                            <button type="submit" class="btn btn-primary custom-box-shadow" name="siguiente">Siguiente</button>
                        </form>
                    </div> 
                
                <% } %>



                <!-- Tabla de turnos del ciudadano -->
                <% if (request.getAttribute("turnosCiudadano") != null) { %>
                <div class="bg-container mt-5">
                    
                    <h2 class="custom-text-shadow">Listado de turnos del usuario:</h2>
                        <table class="table mt-3 table-info custom-box-shadow">
                            <thead>
                                <tr>
                                    <th>Nº turno</th>
                                    <th>Usuario</th>
                                    <th>Fecha</th>
                                    <th>Tramite</th>
                                    <th>Estado</th>

                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                List<Turno> turnosCiudadano = (List<Turno>) request.getAttribute("turnosCiudadano");
                                for ( Turno turno : turnosCiudadano) { 
                                %>
                                    <tr>
                                        <td ><%= turno.getId() %></td>
                                        <td><%= turno.getCiudadano().getDni()%></td>
                                        <td><%= turno.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></td>
                                        <td><%= turno.getTramite().getDescripcion()%></td>                               
                                        <td><%= turno.isEstadoCompletado() ? "Atendido" : "En Espera" %></td>
                                        <td class="d-flex justify-content-around">
                                            <form action="ActualizacionTurnosSV" method="get">
                                                <input type="hidden" name="id" value="<%= turno.getId()%>">
                                                <button type="submit" class="btn btn-success custom-box-shadow">Editar</button>                                                
                                            </form>
                                            <form action="ActualizacionTurnosSV" method="post">
                                                 <!-- uso de los inputs type=hidden para enviar al servlets el id del turno seleccionado y la variable filtro en el caso de borrar -->
                                                <input type="hidden" name="id" value="<%= turno.getId()%>">
                                                <input type="hidden" name="filtro" value="borrar">
                                                <button type="submit" class="btn btn-danger custom-box-shadow">Eliminar</button>
                                            </form>
                                        </td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                            <button class="btn btn-primary custom-box-shadow"><a href="vistaPrincipal.jsp" class="text-decoration-none text-white">Volver al menu principal</a></button>
                </div>  
                </div>
                <% } %>
                   
            
                   
                <!-- Tabla turno seleccionado para modificar y select con los trámites-->
                <% if (request.getAttribute("tramites") != null) { %>
                <div class="bg-image"> 
                    <div class="bg-container">
                        <h1 class="custom-text-shadow mb-5">Modificación del trámite para el turno seleccionado</h1>

                        <% Turno turnoSeleccionado = (Turno) request.getAttribute("turno"); %>
                        <p><strong>NªTurno: </strong><%= turnoSeleccionado.getId() %></p>
                        <p><strong>Fecha: </strong><%= turnoSeleccionado.getFecha()%></p>
                        <p><strong>Trámite actual: </strong><%= turnoSeleccionado.getTramite().getDescripcion()%></p>
                        <form action="ActualizacionTurnosSV" method="post">
                          <div class="form-group w-25">
                              <label for="ciudad" class="custom-text-shadow">Selecciona una opción</label>
                            <select class="form-control custom-box-shadow" name="tramite">
                                <%  
                                    List<Tramite> listaTramites = (List<Tramite>) request.getAttribute("tramites");
                                    for ( Tramite tramite : listaTramites) {
                                %>
                                <option value="<%= tramite.getDescripcion() %>"><%= tramite.getDescripcion() %></option>
                                <% } %>
                            </select>
                          </div>
                            <!-- uso de los inputs type=hidden para enviar al servlets el id del turno seleccionado y la variable filtro en el caso de querer editar -->
                           <input type="hidden" name="id" value="<%= turnoSeleccionado.getId()%>">
                           <input type="hidden" name="filtro" value="editar">
                          <button type="submit" class="btn btn-success custom-box-shadow" name="guardar">Aceptar cambio</button>
                        </form>
                        <hr class="border-dark">
                        <button class="btn btn-primary custom-box-shadow "><a href="vistaPrincipal.jsp" class="text-decoration-none text-white">Volver al menu principal</a></button>
                    </div>
                </div>
                <% } %>
                    
                
            
            
        </div>              
        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
