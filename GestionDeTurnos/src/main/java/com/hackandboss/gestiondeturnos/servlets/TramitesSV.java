
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
    
    // Lista predefinida del listado de Tramites
    protected List<String> listaTramites = List.of("Multas",
            "Vehiculos", "Permiso Conducir", "Otros");
    
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    // Devolvemos el listado de tramites (tramites.jsp)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        List<Tramite> tramites = control.listaTramites();
        
        request.setAttribute("listaTramites", tramites);
        
        request.getRequestDispatcher("tramites.jsp").forward(request, response);
    }

    
    
    // Se rellena la tabla tramites con sus valores predeterminadas si no lo 
    // estuviera se crea el resto de tablas (index.jsp)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        control.verificarInsertarTramites(listaTramites);
        
        
        List<Tramite> listaTramites = control.listaTramites();
                
        response.sendRedirect("vistaPrincipal.jsp");
    }
    
      

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
