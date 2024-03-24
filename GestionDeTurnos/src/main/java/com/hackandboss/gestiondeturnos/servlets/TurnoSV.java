
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Ciudadano;
import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurnoSV", urlPatterns = {"/TurnoSV"})
public class TurnoSV extends HttpServlet {
    
    TramitesSV tramitesSV = new TramitesSV();
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    // Mostramos todos los turnos de un ciudadano
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        
        List<Turno> turnosCiudadano = control.buscarTurnosCiudadano(dni);
        
        request.setAttribute("turnosCiudadano", turnosCiudadano);
        
        request.getRequestDispatcher("actualizacionTurnos.jsp").forward(request, response);
        
    }

    
    // Creamos un nuevo turno
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String tramiteString = request.getParameter("tramite");
        
        Tramite tramite = control.obtenerTramiteSeleccionado(tramiteString);
        
        Ciudadano ciudadano = control.verificarCrearCiudadano(dni);
        
        control.crearTurno(ciudadano, tramite);
        
        response.sendRedirect("vistaPrincipal.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
