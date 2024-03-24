

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Turnos</title>
        <!-- Agregar estilos de Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
            .custom-text-shadow {
              text-shadow: 4px 4px 8px rgba(0, 0, 0, 0.5); /* Ajusta los valores según tus preferencias */
            }
           
            .centered {
              transform: translate(0%, 200%);
              color: white;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row bg-image">
              <div class="col-md-12 text-center">
                <div class="centered d-flex flex-column w-100   justify-content-center">
                    <div>
                        <h1 class="custom-text-shadow" style="font-size: 50px;">Bienvenido a la Dirección General de Tráfico</h1>
                    </div>
                    <div>
                        <form action="TramitesSV" method="post">
                            <button class="btn btn-primary btn-lg custom-text-shadow">Acceder</button>
                        </form>
                    </div>
                    
                </div>
              </div>
            </div>
          </div>     
        <!-- Scripts de Bootstrap -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>
