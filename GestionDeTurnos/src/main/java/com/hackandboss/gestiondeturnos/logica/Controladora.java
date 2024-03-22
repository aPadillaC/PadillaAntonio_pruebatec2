
package com.hackandboss.gestiondeturnos.logica;

import com.hackandboss.gestiondeturnos.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearTramite(Tramite tramite) {
        
        controlPersis.crearTramite(tramite);
    }

    public List<Tramite> listaTramites() {
        
        return controlPersis.listaTramites();
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        
        controlPersis.crearCiudadano(ciudadano);
    }

    public void crearTurno(Turno turno) {
        
        controlPersis.crearTurno(turno);
    }

    public Ciudadano buscarCiudadano(String dni) {

        Ciudadano ciudadano = controlPersis.listaCiudadanos().stream()
                .filter( c -> c.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(new Ciudadano());
               
                
        
        return ciudadano;
    }

    public List<Turno> buscarTurnosCiudadano(String dni) {
        
        
        Ciudadano ciudadano = controlPersis.buscarCiudadano(dni);
        
        
        List<Turno> turnosCiudadanoActivos = controlPersis.buscarTurnosCiudadano(ciudadano.getId()).stream()
                .filter( turno -> turno.isBorrado() == false)
                .toList();
        
        return turnosCiudadanoActivos;
    }

    
   

    

    
    
    
}
