
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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Tramite> listaTramites = control.listaTramites();
        
        String id = request.getParameter("id");
        
        Turno turno = control.buscarTurno(id);
        
         System.out.println("id " + id);
        
        request.setAttribute("tramites", listaTramites);
        request.setAttribute("turno", turno);
        
        
        request.getRequestDispatcher("editarTramite.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tramiteString = request.getParameter("tramite");
        String id = request.getParameter("id");
        
        Tramite tramite = control.listaTramites().stream()
                .filter( t -> t.getDescripcion().equalsIgnoreCase(tramiteString))
                .findFirst()
                .orElse(new Tramite());
        
        Turno turno = control.buscarTurno(id);
        
        turno.setTramite(tramite);
        
        control.editarTurno(turno);
        
        
        response.sendRedirect("vistaPrincipal.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
