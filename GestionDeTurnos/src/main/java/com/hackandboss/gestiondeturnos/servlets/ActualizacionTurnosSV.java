
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
        
         System.out.println("listaTramites " + listaTramites);
        
        request.setAttribute("tramites", listaTramites);
        request.setAttribute("turno", turno);
        
        
        request.getRequestDispatcher("actualizacionTurnos.jsp").forward(request, response);
        
    }

    
    
    // Actualizo el atributo tramite de Turnos 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tramiteString = request.getParameter("tramite");
        String id = request.getParameter("id");
        
        Tramite tramite = control.obtenerTramiteSeleccionado(tramiteString);
                
        Turno turno = control.buscarTurno(id);
        
        control.editarTurno(turno, tramite);
        
        
        response.sendRedirect("vistaPrincipal.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
