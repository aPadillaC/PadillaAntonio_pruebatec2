

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
    </head>
    <body>
        
        <div class="container-fluid">
            
            <% if (request.getAttribute("turnosFiltrado") == null) { %>
            <form action="TurnosFechaSV" method="post">
              <div class="form-group">
                <label for="ciudad">Selecciona una opción</label>
                <select class="form-control" name="fecha">
                    <%  
                        List<LocalDate> fechas = (List<LocalDate>) request.getAttribute("fechas");
                        for ( LocalDate fecha : fechas) {
                    %>
                    <option value="<%= fecha%>"><%= fecha %></option>
                    <% } %>
                </select>
              </div>
              <button type="submit" class="btn btn-primary" name="guardar">Filtrar</button>
            </form>
            <% } %>
            
            <!-- Tabla de turnos -->
        <div class="container mt-5">
            <% if (request.getAttribute("turnosFiltrado") != null) { %>
                <h2>Listado de equipos:</h2>
                <table class="table mt-3">
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
                    
                    <form action="TurnosFechaSV" method="post">
                        <div class="form-group">
                          <label for="ciudad">Filtrar por estado:</label>
                          <select class="form-control" name="estado">
                              <option value="espera">En espera</option>                          
                              <option value="atendido">Atendido</option>
                          </select>
                        </div>
                         <% 
                        List<Turno> listado = (List<Turno>) request.getAttribute("turnosFiltrado");
                        LocalDate fecha = listado.get(0).getFecha();
                        %>
                        <input type="hidden" value="<%=fecha%>" name="fecha">
                        <button type="submit" class="btn btn-primary" name="guardar">Filtrar</button>
                    </form>
                    
                    
                    <button class="btn btn-primary"><a href="vistaPrincipal.jsp" class="text-decoration-none text-white"></a>Volver al menú principal</button>
            <% } %>
            
        </div>
        
        
        
        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
