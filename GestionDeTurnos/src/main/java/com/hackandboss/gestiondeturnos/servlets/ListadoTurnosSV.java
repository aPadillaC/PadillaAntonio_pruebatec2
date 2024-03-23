
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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String orden = request.getParameter("orden");
        
        List<Turno> listadoTotalTurnos = control.listadoTotalTurnos();
        
        List<Turno> listadoOrdenado = listadoTotalTurnos.stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter( turno -> turno.isEstadoCompletado() == false)
                .sorted((f1, f2) -> f1.getFecha().compareTo(f2.getFecha()))
                .toList();
        
        request.setAttribute("listadoOrdenado", listadoOrdenado);
        
        
        request.getRequestDispatcher("principalListado.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        Turno turno = control.buscarTurno(id);
        
        turno.setEstadoCompletado(true);
        
        control.editarTurno(turno);
        
        response.sendRedirect("principalListado.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
