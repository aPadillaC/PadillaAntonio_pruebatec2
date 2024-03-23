
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TurnosFechaSV", urlPatterns = {"/TurnosFechaSV"})
public class TurnosFechaSV extends HttpServlet {
    
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<LocalDate> fechas = control.listadoFechas();
        
        request.setAttribute("fechas", fechas);
        
        
        request.getRequestDispatcher("filtroFecha.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fechaString = request.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaString);
        String estado = request.getParameter("estado");
        
        System.out.println("estado" + estado);
        
                
        List<Turno> turnosFiltrado = control.turnosFiltrados(fecha, estado);
        
        
        request.setAttribute("turnosFiltrado", turnosFiltrado);
        
        
        request.getRequestDispatcher("filtroFecha.jsp").forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
