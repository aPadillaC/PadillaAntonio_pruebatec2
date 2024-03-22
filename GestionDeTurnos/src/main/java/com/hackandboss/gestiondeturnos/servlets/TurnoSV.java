
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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        
        List<Turno> turnosCiudadano = control.buscarTurnosCiudadano(dni);
        
        
        
        request.setAttribute("turnosCiudadano", turnosCiudadano);
        
        request.getRequestDispatcher("editarTramite.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String tramiteString = request.getParameter("tramite");
        
        Tramite tramite = control.listaTramites().stream()
                .filter( t -> t.getDescripcion().equalsIgnoreCase(tramiteString))
                .findFirst()
                .orElse(new Tramite());
        
        Ciudadano ciudadano = control.buscarCiudadano(dni);
        
        if (ciudadano.getDni().isEmpty()) {
            
            ciudadano.setDni(dni);
            control.crearCiudadano(ciudadano);
        }
        //Ciudadano ciudadano = new Ciudadano();
        Turno turno = new Turno();
        
        // ciudadano.setDni(dni);
        
        turno.setCiudadano(ciudadano);
        turno.setTramite(tramite);
        turno.setNumero(turno.getId());
        
        
        
        control.crearTurno(turno);
        
        response.sendRedirect("vistaPrincipal.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
