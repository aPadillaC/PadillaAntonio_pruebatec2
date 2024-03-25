
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "TurnosFechaSV", urlPatterns = {"/TurnosFechaSV"})
public class TurnosFechaSV extends HttpServlet {
    
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    // Obtenemos listado de fechas existente en la BBDD
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<LocalDate> fechas = control.listadoFechas();
//        
//        request.setAttribute("fechas", fechas);
//        
//        request.getRequestDispatcher("filtroFecha.jsp").forward(request, response);

        // Obtener la sesión
        HttpSession session = request.getSession();

        // Guardar un valor en la sesión
        session.setAttribute("fechas", fechas);

        // Redirigir a otra página
        response.sendRedirect("filtroFecha.jsp");
        
    }

    
    
    // Enviado todos los turnos por la fecha filtrada
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fechaString = request.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaString);
        String estado = request.getParameter("estado");        
                
        List<Turno> turnosFiltrado = control.turnosFiltrados(fecha, estado);       
       
        request.setAttribute("turnosFiltrado", turnosFiltrado);  
       
        request.setAttribute("estado", estado);        
        
        request.getRequestDispatcher("filtroFecha.jsp").forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
