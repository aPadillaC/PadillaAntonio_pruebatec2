


<%@page import="com.hackandboss.gestiondeturnos.logica.Turno"%>
<%@page import="java.time.LocalDate"%>
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
            
            <div class="bg-image">
                
                <div class="bg-container">
            
                    
                <!-- Filtramos por la fecha que queramos -->
                <% if (request.getAttribute("turnosFiltrado") == null) { %>
                <form action="TurnosFechaSV" method="post">
                  <div class="form-group w-25">
                      <label for="ciudad" class="custom-text-shadow">Selecciona una fecha</label>
                    <select class="form-control custom-box-shadow" name="fecha">
                        <%  
                            List<LocalDate> fechas = (List<LocalDate>) request.getAttribute("fechas");
                            for ( LocalDate fecha : fechas) {
                        %>
                        <option value="<%= fecha%>"><%= fecha %></option>
                        <% } %>
                    </select>
                  </div>
                  <button type="submit" class="btn btn-primary custom-box-shadow" name="guardar">Filtrar</button>
                </form>
                <% } %>
                
                

                <!-- Tabla de turnos filtrada por fecha -->
                
                    <% if (request.getAttribute("turnosFiltrado") != null) { %>
                    <h2 class="custom-text-shadow">Listado turno de la fecha indicada:</h2>
                    <% if (request.getAttribute("estado")!= null) { %>
                    <label>Filtrado por "<%= request.getAttribute("estado") %>"</label>
                    <% } %>
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
                                List<Turno> listadoOrdenado = (List<Turno>) request.getAttribute("turnosFiltrado");
                                for ( Turno turno : listadoOrdenado) { 
                                %>
                                    <tr>
                                        <td><%= turno.getId() %></td>
                                        <td><%= turno.getCiudadano().getDni()%></td>
                                        <td><%= turno.getFecha()%></td>
                                        <td><%= turno.getTramite().getDescripcion()%></td>                               
                                        <td><%= turno.isEstadoCompletado() ? "Atendido" : "En Espera" %></td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>

                            
                        <!-- Filtro para ver solo turnos En Espera o Atendidos en la fecha indicada-->
                        <% if (request.getAttribute("estado") == null) { %>
                        <form action="TurnosFechaSV" method="post">
                            <div class="form-group w-25">
                                <label for="ciudad" class="custom-text-shadow">Filtrar por estado:</label>
                                <select class="form-control custom-box-shadow" name="estado">
                                    <option value="En espera">En espera</option>                          
                                    <option value="Atendido">Atendido</option>
                                </select>
                            </div>
                            
                             <% 
                            List<Turno> listado = (List<Turno>) request.getAttribute("turnosFiltrado");
                            LocalDate fecha = listado.get(0).getFecha();
                            %>
                            <input type="hidden" value="<%=fecha%>" name="fecha">
                            <button type="submit" class="btn btn-primary custom-box-shadow" name="guardar">Filtrar</button>                          
                        </form>
                        <% } %>                        
                        <hr class="border-dark">
                        <button class="btn btn-primary custom-box-shadow"><a href="vistaPrincipal.jsp" class="text-decoration-none text-white">Volver al menú principal</a></button>
                    <% } %>
                
                
            </div>
                
        </div>       
        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
