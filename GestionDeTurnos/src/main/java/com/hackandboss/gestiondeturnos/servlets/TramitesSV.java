
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TramitesSV", urlPatterns = {"/TramitesSV"})
public class TramitesSV extends HttpServlet {
    
    protected List<String> listaTramites = List.of("Multas",
            "Vehiculos", "Permiso Conducir", "Otros");
    
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    // Devolvemos el listado de tramites
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        List<Tramite> tramites = control.listaTramites();
        
        request.setAttribute("listaTramites", tramites);
        
        request.getRequestDispatcher("tramites.jsp").forward(request, response);
    }

    
    
    // Se rellena la tabla tramites con sus valores predeterminadas si no lo estuviera e crea el resto de tablas
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        control.verificarInsertarTramites(listaTramites);
        
        
        List<Tramite> listaTramites = control.listaTramites();
        
        //if ( listaTramites.isEmpty() ) {
            
            //control.crearTramite(new Tramite("Multa"));
            //control.crearTramite(new Tramite("Vehiculos"));
            //control.crearTramite(new Tramite("Permiso Conducir"));
            //control.crearTramite(new Tramite("Otros"));
        //}
        
        
        response.sendRedirect("vistaPrincipal.jsp");
    }
    
      

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
