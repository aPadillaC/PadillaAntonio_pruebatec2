
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TramitesSV", urlPatterns = {"/TramitesSV"})
public class TramitesSV extends HttpServlet {
    
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Tramite> prueba = control.listaTramites();
        
        if ( prueba.isEmpty() ) {
            
            control.crearTramite(new Tramite("Multa"));
            control.crearTramite(new Tramite("Vehículos"));
            control.crearTramite(new Tramite("Permiso Conducir"));
            control.crearTramite(new Tramite("Otros"));
        }
        
        
        
        


        List<Tramite> listaTramites = control.listaTramites();
        
        request.setAttribute("listaTramites", listaTramites);
        
        System.out.println("listaTramite:" );
        
        request.getRequestDispatcher("vistaPrincipal.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
