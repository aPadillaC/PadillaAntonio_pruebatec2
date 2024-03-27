# GestionDTurnos
<p dir="auto">Esta aplicación de gestión de turnos ha sido desarrollada para satisfacer las necesidades de una entidad gubernamental en la administración eficiente de sus trámites y ciudadanos asignados a los mismos. Permite la gestión de turnos numerados y su respectivo estado, ya sea "En espera" o "Ya atendido", así como, editar y eliminar cada uno de los turnos.</p>

<!-- Tecnologías Utilizadas -->

<h2 dir="auto">Tecnologías utilizadas</h2>
<ul dir="auto">
	<li>Front-end: <a target="_blank" rel="noopener noreferrer nofollow" href="https://itdconsulting.com/wp-content/uploads/2022/06/vps-honduras-jsp-itdconsulting-02.webp"><img src="https://itdconsulting.com/wp-content/uploads/2022/06/vps-honduras-jsp-itdconsulting-02.webp" alt="Java JSP" data-canonical-src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU" style="max-width: 3%;"></a></li>
	<br>
	<li>Back-end: <a target="_blank" rel="noopener noreferrer nofollow" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU" alt="Java" data-canonical-src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU" style="max-width: 3%;"></a></li>
	<br>
	<li>Base de datos: <a target="_blank" rel="noopener noreferrer nofollow" href=""><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnO0xHQrNDbCdgefmnjSjUPAMIKBx2F-NOww&usqp=CAU" alt="MySQL" data-canonical-src="" style="max-width: 3%;"></a></li>
</ul>

<!-- Funcionalidades Detalladas -->

<h2 dir="auto">Funcionalidades Detalladas</h2>
<ul dir="auto">
	<li><b>Trámites:</b> Forman una entidad propia y sus valores predeterminados se cargan en la BBDD al momento de la creación de las tablas la primera vez que accedemos a la web. Están definidos dentro de un ArrayList con las descripciones de los trámites como valores de inicio.</li>
	<br>
	<li><b>Agregar un nuevo turno:</b> El usuario ingresará su DNI y el trámite que desea solicitar para poder crearse la petición de nuevo turno. Previamente, se validará el DNI introducido por si cumple las condiciones y si no fuese así, se le informa al usuario mediante un mensaje por pantalla.
	A todos los turnos creados se le asignan automáticamente la fecha del día de su creación, así como los atributos booleanos "borrado", "estadoCompletado" se setean por defecto en false.</li>
	<br>
	<li><b>Listar/Filtrar turnos:</b> La aplicación permite visualizar la lista completa de todos los turnos registrados junto con la información de los ciudadanos asignados a los mismos. La visualización se realiza en una tabla, lo que facilita la comprensión y la navegación de los datos. También tiene la opción de filtrar por una fecha existente en la BBDD y a su vez, volver a filtrar ese listado con las condiciones de estado: "Atendido" o "En espera". Se ha empleado el uso de	HttpSession para poder darle reactividad a este último filtrado y poder pasar de uno a otro conservando el filtro inicial de la fecha.</li>
	<br>
	<li><b>Actualizar/Eliminar turnos:</b> El usuario puede acceder a sus turnos pendientes por medio de la comprobación de su DNI. Una vez dentro tiene la opción de editar o borrar un turno. Si elige editar, podrá cambiar el tipo de trámite seleccionado anteriormente cuando sacó el turno. Y en la opción borrar, se realizará un borrado lógico del turno, mediante el seteo del atributo "estadoCompletado" de false a true, esto hará que desaparezca de cualquier lista/filtro existente dentro de la aplicación.</li>
</ul>

<!-- Instalación y configuración -->

<h2 dir="auto">Instalación y configuración</h2>
<b>Para Windows</b>
<ul dir="auto"><b></b>
	<li>Visita el sitio web oficial de Oracle, e instala  <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK</a> en el equipo.</li>
	<li>Una vez completada la instalación, verifica que el JDK esté correctamente configurado ejecutando java -version en la línea de comandos de la terminal de su PC.</li>
</ul>
<br>
<b>Para macOS</b>
<ul dir="auto">
<li>Abre la Terminal.</li>
<li>Instala Homebrew si aún no lo tienes: /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"</li>
<li>Usa Homebrew para instalar el JDK: brew install openjdk</li>
<li>Verifica la instalación ejecutando java -version en la Terminal.</li>
</ul>
<br>
<b>Instalar Mysql y mysql workbench para la Base de Datos</b>
   <ul>
    <li><a href="https://dev.mysql.com/doc/refman/8.0/en/windows-installation.html">Instalación Windows</a></li>
    <li><a href="https://dev.mysql.com/doc/refman/5.7/en/macos-installation-pkg.html">Instalación Mac</a></li>
    <li>En la carpeta del proyecto incluimos el script para crear la base de datos, si está Workbench instalado correctamente solo hay que importar el archivo que contiene estructura y los datos de la BBDD predeterminados para las pruebas.</li>
  </ul>



<!-- EJECUCIÓN -->

<h2 dir="auto">Abrir y Ejecutar Proyecto</h2>
<ul dir="auto">
    <li>Clona el repositorio</li>
  	<li>Abrir proyecto en su IDE</li>
	<li>Actualiza dependencias si fuera necesario</li>
	<li>Ejecuta el programa mediante el archivo `index.jsp`
</ul>

<!-- BBDD -->

<h2 dir="auto">Información de la Base de Datos y tablas</h2>
<ul dir="auto">
	<li><b>Ciudadano: </b>Almacena el dni del ciudadano que crea el turno</li>
	<br>
	<li><b>Turno: </b>Almacena todos los datos de cada turno, que tendrá por defecto el id, fecha. Además de ello tiene dos campos llamada "borrado" (para el borrado lógico) y "estadoCompletado" booleanos como filtro de busqueda.</li>
	<br>
	<li><b>Trámite: </b>Almacena los trámites disponibles en la aplicación.</li>
</ul>



<!-- SUPUESTOS -->

<h2 dir="auto">Supuestos aplicados por el desarrollador</h2>
<ul dir="auto">
	<li> Teniendo en cuenta la consigna, el desarrollador ha querido dividir la aplicación en dos partes: 
			<ul><br> 
				<li><b>Trámites:</b> Es la parte con la que el usuario/ciudadano interactuaría con la aplicación y podría crear, eliminar (borrado lógico), editar, leer sus turnos.</li>
				<br> 
				<li><b>Listados Turnos:</b> Tendría un enfoque más a nivel de administrador/usuario con privilegios, en donde tendría acceso al listado total de turnos pendientes y podría a dar por ATENDIDO un turno para quitarlo así del listado. Y además, tiene la opción de filtrar por una fecha existente en la BBDD y poder, a su vez, volver a filtrar ese listado por las condiciones de estado: "Atendido" o "En espera". Esto último sería muy interesante a nivel de estudío estadistico para ver la carga de trabajo de cada tipo de trámite así como su tiempo/rapidez de atención.</li>
			</ul><br> 
		Aún así, para esta prueba no se ha implantado restricción alguna y  todo usuario de la aplicación tiene acceso total a todas las funcionalidades.
	</li>
	<br>
	<li> No se ha considerado necesario implantar un borrado/eliminación de un usuario ya que según se interpreta en la consigna no se aprecia la necesidad al enfocarse esta principalmente en la entidad TURNO.</li>
	<br>
	<li> La vista principal ha querido simular las distintas opciones de gestión que tiene cada una de las opciones de trámites disponibles.</li>
	<br>
    <li> Para darle más realismo a la prueba, se ha implementado una validación real de DNI para que solo se puedan introducir DNIs válidos con las condiciones que se aplican en la vida real.</li>
	<br>
	<li>Se ha desarrollado consultas a la BBDD propias a parte de las proporcionadas por JPA para realizar una mejor optimización.</li>
	<br>
</ul>


<!-- Capturas y Demostración -->

<h2 dir="auto">Capturas y Demostración</h2>

<ul dir="auto">
	<li>Entrada a la aplicación: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/index.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/index.png" alt="Vista index (Inicio)" style="max-width: 100%;"></a>   
		</li>
		<li>Vista Principal: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/vistaPrincipal.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/vistaPrincipal.png" alt="Vista Principal" style="max-width: 100%;"></a>   
	</li>
	<li>Trámites: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/tramites.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/tramites.png" alt="Vista Tramites" style="max-width: 100%;"></a>   
	</li>
	<li>Crear turno: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/registroTurno.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/registroTurno.png" alt="Vista Registro Turno" style="max-width: 100%;"></a>   
	</li>       
	<li>Editar turno: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/editarTurno1.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/editarTurno1.png" alt="Vista Editar1" style="max-width: 100%;"></a>
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/editarTurno2.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/editarTurno2.png" alt="Vista Editar2" style="max-width: 100%;"></a>     
	</li>    
	<li>Listado Turnos: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/principalListado.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/principalListado.png" alt="Vista Principal Listado" style="max-width: 100%;"></a>   
	</li>   
	<li>Listado pendientes: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/listadoPendientes1.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/listadoPendientes1.png" alt="Vista Listado Turnos Pendientes2" style="max-width: 100%;"></a> 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/listadoPendientes2.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/listadoPendientes2.png" alt="Vista Listado Turnos Pendientes2" style="max-width: 100%;"></a>   
	</li>     
	<li>Listado por fecha: 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/filtroFecha1.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/filtroFecha1.png" alt="Vista Listado Por Fecha1" style="max-width: 100%;"></a> 
		<a target="_blank" rel="noopener noreferrer" href="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/filtroFecha2.png"><img src="https://github.com/aPadillaC/PadillaAntonio_pruebatec2/blob/master/screenshots/filtroFecha2.png" alt="Vista Listado Por Fecha2" style="max-width: 100%;"></a>   
	</li>   
</ul>



<!-- DESARROLLADOR -->

<h2 dir="auto">Desarrollador</h2>
<p dir="auto">Esta aplicación ha sido desarrollada por: </p>
<ul dir="auto">
	<li><a href="https://www.linkedin.com/in/antonio-padilla-carrillo" rel="nofollow">Antonio Padilla</a></li>
</ul>

<h2 dir="auto"><a id="user-content-licencia" class="anchor" aria-hidden="true" href="#licencia"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Licencia de uso</h2>

<p>El código del proyecto aquí alojado se encuentra bajo licencia <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/" rel="nofollow"><img alt="Licencia Creative Commons" src="https://camo.githubusercontent.com/f05d4039b67688cfdf339d2a445ad686a60551f9891734c418f7096184de5fac/68747470733a2f2f692e6372656174697665636f6d6d6f6e732e6f72672f6c2f62792d6e632d73612f342e302f38387833312e706e67" data-canonical-src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" style="max-width: 100%;"></a><br> <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/" rel="nofollow">Licencia Creative Commons Atribución-NoComercial-CompartirIgual 4.0 Internacional</a></p>




