

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
    </head>
    <body>
        <div class="container">
            
            <h1>Formulario</h1>
            <form action="PeticionTurnoSV" method="post">
              <div class="form-group">
                <label for="nombre">Dni: </label>
                <input type="text" class="form-control" id="dni" name="dni" placeholder="Ingrese su dni">
              </div>
              <div class="form-group">
                <label for="ciudad">Selecciona una opción</label>
                <select class="form-control" name="tramite">
                    <%  
                        List<Tramite> listaTramites = (List<Tramite>) request.getAttribute("listaTramites");
                        for ( Tramite tramite : listaTramites) {
                    %>
                    <option value="<%= tramite.getDescripcion() %>"><%= tramite.getDescripcion() %></option>
                    <% } %>
                </select>
              </div>
              <button type="submit" class="btn btn-primary" name="guardar">Guardar</button>
            </form>
        
        <hr>
            
        </div>        
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
