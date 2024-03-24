

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
                margin: 0; /* Elimina el margen predeterminado */
                width: 100%;
            }
            .bg-container {
                margin-top: 10vh;
                background-color: RGBA(255,255,255, 0.8);
                padding: inherit 5vh;
            }
            .custom-box-shadow {
              box-shadow:4px 4px 8px rgba(0, 0, 0, 0.5);
            }
            .custom-text-shadow {
              text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Ajusta los valores según tus preferencias */
            }
        </style>
    </head>
    <body>
        <div class="container-fluid bg-image pt-2 centered">
            <div class="row justify-content-between align-items-center text-center bg-container">
                <div class="col-12 mb-4">
                    <h3 class="custom-text-shadow pt-2">Para cada tipo de trámite podrá realizar las siguientes gestiones</h3>
                </div>
                <div class="col-6 mb-4">
                  <div class="p-4 border rounded border-dark custom-box-shadow bg-white">
                    <h2 class="mb-3">Multas y Sanciones</h2>
                    <hr class="border-dark">
                    <ul class="list text-left">
                        <li>Pago</li>
                        <li>Recursos</li>
                        <li>Informe Multas</li>
                        <li>Aplazamiento</li>
                        <li>Cambio notificación</li>
                    </ul>
                  </div>
                </div>
                <div class="col-6 mb-4">
                  <div class="p-4 border rounded-lg border-dark custom-box-shadow bg-white">
                    <h2 class="mb-3">Vehículos</h2>
                    <hr class="border-dark">
                    <ul class="list text-left">
                      <li>Compra/venta vehículo 2ª mano</li>
                      <li>Cambio de titularidad</li>
                      <li>Información del vehículo</li>
                      <li>Altas, bajas y rehabilitaciones</li>
                      <li>Cambio de domicilio fiscal</li>
                    </ul>
                  </div>
                </div>
                <div class="col-6 mb-4">
                  <div class="p-4 border rounded border-dark custom-box-shadow bg-white">
                    <h2 class="mb-3">Permisos de conducir</h2>
                    <hr class="border-dark">
                    <ul class="list text-left">
                      <li>Infracción de puntos</li>
                      <li>Recuperación puntos y/o carnet</li>
                      <li>Obtener nuevo permiso</li>
                      <li>Renovar o copia permiso</li>
                      <li>Conducir en el extranjeto</li>
                    </ul>
                  </div>
                </div>
                <div class="col-6 mb-4">
                  <div class="p-4 border rounded border-dark custom-box-shadow bg-white">
                    <h2 class="mb-3">Otros trámites</h2>
                    <hr class="border-dark">
                    <ul class="list text-left">
                      <li>Cita previa</li>
                      <li>Presentación de escritos y comunicaciones</li>
                      <li>Presentación de quejas y sugerencias</li>
                      <li>Verificación de documentos</li>
                      <li>Etc...</li>
                    </ul>
                  </div>
                </div>
            </div>
        </div>
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
