
package com.hackandboss.gestiondeturnos.servlets;

import com.hackandboss.gestiondeturnos.logica.Ciudadano;
import com.hackandboss.gestiondeturnos.logica.Controladora;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import com.hackandboss.gestiondeturnos.logica.Turno;
import com.hackandboss.gestiondeturnos.logica.ValidadorDni;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TurnoSV", urlPatterns = {"/TurnoSV"})
public class TurnoSV extends HttpServlet {
    
    Controladora control = new Controladora();
    ValidadorDni validador = new ValidadorDni();
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    // Mostramos todos los turnos de un ciudadano
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        
        // Validamos el DNI introducido
        boolean valiDni = validador.validar(dni);
        
        if (!valiDni) {
            
            List<Tramite> tramites = control.listaTramites();
            request.setAttribute("error", "Dni no es válido. Por favor, ingrese un valor válido.");
            request.getRequestDispatcher("actualizacionTurnos.jsp").forward(request, response);

        }
        
        List<Turno> turnosCiudadano = control.buscarTurnosCiudadano(dni);
        
        if (turnosCiudadano.isEmpty()) {
            
             request.setAttribute("error", "No se encontró ningún registro con el DNI proporcionado.");
             request.getRequestDispatcher("actualizacionTurnos.jsp").forward(request, response);
        }
        
        request.setAttribute("turnosCiudadano", turnosCiudadano);
        
        request.getRequestDispatcher("actualizacionTurnos.jsp").forward(request, response);
        
    }

    
    // Creamos un nuevo turno
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String tramiteString = request.getParameter("tramite");
        
        
        // Validamos el DNI introducido
        boolean valiDni = validador.validar(dni);
                
        if (!valiDni) {
            
            List<Tramite> tramites = control.listaTramites();
            
            request.setAttribute("listaTramites", tramites);
            request.setAttribute("error", "Dni no es válido. Por favor, ingrese un valor válido.");
            
            request.getRequestDispatcher("tramites.jsp").forward(request, response);

        }
        else {
            
            // Obtenemos el listado de tramites<Tramite> a traves de la opcion seleccionada        
            Tramite tramite = control.obtenerTramiteSeleccionado(tramiteString);

            // Verificamos si el ciudadano existe o no en la BBDD y si no, lo creamos
            Ciudadano ciudadano = control.verificarCrearCiudadano(dni);

            // Creamos la instancia de la Clase Turno
            control.crearTurno(ciudadano, tramite);

            response.sendRedirect("vistaPrincipal.jsp");
        }

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
