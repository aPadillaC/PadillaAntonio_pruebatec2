
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
    </head>
    <body>
        
        <h1>Editar Trámite</h1>
            <form action="TurnoSV" method="get">
              <div class="form-group">
                <label for="nombre">Introduce su DNI para mostrar sus tramites pendientes:  </label>
                <input type="text" class="form-control" id="dni" name="dni" placeholder="Ingrese su DNI">
              </div>
              <button type="submit" class="btn btn-primary" name="siguiente">Siguiente</button>
            </form>
        
        <!-- Tabla de equipos -->
        <div class="container mt-5">
            <% if (request.getAttribute("turnosCiudadano") != null) { %>
                <h2>Listado de equipos:</h2>
                <table class="table mt-3">
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
                        List<Turno> turnosCiudadano = (List<Turno>) request.getAttribute("turnosCiudadano");
                        for ( Turno turno : turnosCiudadano) { 
                        %>
                            <tr>
                                <td><%= turno.getId() %></td>
                                <td><%= turno.getFecha()%></td>
                                <td><%= turno.getTramite().getDescripcion()%></td>                               
                                <td><%= turno.isEstadoCompletado() ? "Atendido" : "En Espera" %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <% } %>
        </div>
        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
