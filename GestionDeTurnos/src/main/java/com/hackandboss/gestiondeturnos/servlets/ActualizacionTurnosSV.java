
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ActualizacionTurnosSV", urlPatterns = {"/ActualizacionTurnosSV"})
public class ActualizacionTurnosSV extends HttpServlet {

    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    // Obtengo el turno seleccionado para editar y lo envio junto al listado de tramites
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Tramite> listaTramites = control.listaTramites();
        
        String id = request.getParameter("id");
        
        Turno turno = control.buscarTurno(id);
        
        request.setAttribute("tramites", listaTramites);
        request.setAttribute("turno", turno);
        
        
        request.getRequestDispatcher("actualizacionTurnos.jsp").forward(request, response);
        
    }

    
    
    // Actualizo el atributo "tramite" o "borrado" lógicamente un turno 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tramiteString = request.getParameter("tramite");
        String id = request.getParameter("id");
        String filtro = request.getParameter("filtro");
        
        Tramite tramite = control.obtenerTramiteSeleccionado(tramiteString);
                
        Turno turno = control.buscarTurno(id);
        
        control.editarTurno(turno, tramite, filtro);
        
        
        response.sendRedirect("vistaPrincipal.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
