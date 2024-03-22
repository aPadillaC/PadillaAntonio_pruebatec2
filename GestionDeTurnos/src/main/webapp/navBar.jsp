<nav class="navbar navbar-expand-lg navegador" style="background-color: #e3f2fd;">
    <div class="container-fluid">
      <a class="navbar-brand logo-a" href="vistaPrincipal.jsp"><img src="/images/logo.jpeg" alt="hola" class="logo"></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active fw-semibold  ms-5" aria-current="page" href="tramites.jsp">Tr�mites</a>
          </li>                
          <li class="nav-item">
            <a class="nav-link active fw-semibold  ms-5" href="/object/createObjectNavBar">Listado Turnos</a>
          </li>                           
        </ul>
        <form class="d-flex" action="/collector/search" method="post">
          <input class="form-control me-2 buscar" type="text" placeholder="Tus turnos pendientes" aria-label="Search" name="search">
          <button class="btn btn-outline-success" type="submit">Buscar</button>
        </form>
      </div>
    </div>
  </nav>