
package com.hackandboss.gestiondeturnos.logica;

import com.hackandboss.gestiondeturnos.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
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
                .filter(turno -> turno.isEstadoCompletado() == false)
                .toList();
        
        return turnosCiudadanoActivos;
    }

    public Turno buscarTurno(String id) {
        
        return controlPersis.buscarTurno(id);
    }

    public void editarTurno(Turno turno) {

        controlPersis.editarTurno(turno);
    }

    public List<Turno> listadoTotalTurnos() {
        
        return controlPersis.listadoTotalTurnos();
    }

    public List<LocalDate> listadoFechas() {
        
         return listadoTotalTurnos().stream()
                .map( turno -> turno.getFecha())
                .distinct()
                .toList();
                
    }

    public List<Turno> turnosFiltrados(LocalDate fecha, String estado) {
        
        if( estado == null) {
            return listadoTotalTurnos().stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter( turno -> turno.getFecha().equals(fecha))
                .toList();
        }
        else {
            
            if ("espera".equals(estado)){
                
                return listadoTotalTurnos().stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter( turno -> turno.getFecha().equals(fecha))
                .filter( turno -> turno.isEstadoCompletado() == false)
                .toList();
            }
            
                
            return listadoTotalTurnos().stream()
            .filter( turno -> turno.isBorrado() == false)
            .filter( turno -> turno.getFecha().equals(fecha))
            .filter( turno -> turno.isEstadoCompletado() == true)
            .toList();
           
        }
    }

    
   

    

    
    
    
}
