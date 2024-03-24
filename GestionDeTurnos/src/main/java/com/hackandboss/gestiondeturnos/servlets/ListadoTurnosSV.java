
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListadoTurnosSV", urlPatterns = {"/ListadoTurnosSV"})
public class ListadoTurnosSV extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    // Mostramos listado de turnos pendientes 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        List<Turno> listadoOrdenado = control.listadoTotalTurnos();
               
        request.setAttribute("listadoOrdenado", listadoOrdenado);
                
        request.getRequestDispatcher("principalListado.jsp").forward(request, response);
    }

    
    
    // Marcar en la BBDD el turno como COMPLETADO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        control.turnoCompletado(id);
        
        response.sendRedirect("principalListado.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
