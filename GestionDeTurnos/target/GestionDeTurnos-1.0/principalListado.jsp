
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
        <div class="container-fluid">
            
            <% if (request.getAttribute("listadoOrdenado") == null) { %>
            <h1>Como desea ver el listado: </h1>
        
            <form action="ListadoTurnosSV" method="get">
                <button class="btn btn-success mb-2" type="submit">Listado Total</button>
            </form>
            
            <form action="TurnosFechaSV" method="get">
                <input type="hidden" name="orden" value="desc"> 
                <button class="btn btn-primary" type="submit">Busqueda personalizada por Fecha</button>
            </form>
        </div>
        <% } %>
        
        <!-- Tabla de turnos -->
        <div class="container mt-5">
            <% if (request.getAttribute("listadoOrdenado") != null) { %>
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
                                        <button type="submit" class="btn btn-success">Atender</button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
                    
                    
                    <button type="submit" class="btn btn-primary"><a href="vistaPrincipal.jsp" class="text-decoration-none text-white">Volver al menú principal</a></button>
            <% } %>
            
        
        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
