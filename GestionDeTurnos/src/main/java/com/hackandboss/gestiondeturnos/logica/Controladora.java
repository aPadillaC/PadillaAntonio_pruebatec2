
package com.hackandboss.gestiondeturnos.logica;

import com.hackandboss.gestiondeturnos.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
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

    public void crearTurno(Ciudadano ciudadano, Tramite tramite) {
        
        Turno turno = new Turno();
        
        turno.setCiudadano(ciudadano);
        turno.setTramite(tramite);
        
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
        
        if (ciudadano == null) {
            
            List<Turno> listaVacia = new ArrayList<>();
            
            return  listaVacia;
        }
        
        List<Turno> turnosCiudadanoActivos = controlPersis.buscarTurnosCiudadano(ciudadano.getId()).stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter(turno -> turno.isEstadoCompletado() == false)
                .toList();
        
        return turnosCiudadanoActivos;
    }

    public Turno buscarTurno(String id) {
        
        return controlPersis.buscarTurno(id);
    }

    public void editarTurno(Turno turno, Tramite tramite, String filtro) {
        
        System.out.println("filtro " + filtro);
        
         if( filtro.equalsIgnoreCase("borrar")) {
             
             turno.setBorrado(true);
         }
         else {
             
            turno.setTramite(tramite);
         }
        

        controlPersis.editarTurno(turno);
    }

    public List<Turno> listadoTotalTurnos() {
        
        return controlPersis.listadoTotalTurnos().stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter( turno -> turno.isEstadoCompletado() == false)
                .toList();
        
    }

    public List<LocalDate> listadoFechas() {
        
         return listadoTotalTurnos().stream()
                .map( turno -> turno.getFecha())
                .distinct()
                .toList();
                
    }

    public List<Turno> turnosFiltrados(LocalDate fecha, String estado) {
        
        if( estado == null) {
            return controlPersis.listadoTotalTurnos().stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter( turno -> turno.getFecha().equals(fecha))
                .toList();
        }
        else {
            
            if ("Atendido".equals(estado)){
                
                return controlPersis.listadoTotalTurnos().stream()
                .filter( turno -> turno.isBorrado() == false)
                .filter( turno -> turno.getFecha().equals(fecha))
                .filter( turno -> turno.isEstadoCompletado() == true)
                .toList();                
            }
            
                
            return controlPersis.listadoTotalTurnos().stream()
            .filter( turno -> turno.isBorrado() == false)
            .filter( turno -> turno.getFecha().equals(fecha))
            .filter( turno -> turno.isEstadoCompletado() == false)
            .toList();
           
        }
    }

    public Tramite obtenerTramiteSeleccionado(String tramiteString) {
        
        return listaTramites().stream()
                .filter( t -> t.getDescripcion().equalsIgnoreCase(tramiteString))
                .findFirst()
                .orElse(new Tramite());
    }

    public Ciudadano verificarCrearCiudadano(String dni) {
        
        //Compruebo si el dni existe ya en la BBDD
        Ciudadano ciudadano = buscarCiudadano(dni);
        
        if (ciudadano.getDni() == null) {
            
            ciudadano.setDni(dni);
            crearCiudadano(ciudadano);
        }
        
        return ciudadano;
    }

    public void turnoCompletado(String id) {
        
        Turno turno = controlPersis.buscarTurno(id);
        
        turno.setEstadoCompletado(true);
        
        controlPersis.editarTurno(turno);
    }

    public void verificarInsertarTramites(List<String> listaTramites) {
        
        List<Tramite> tramites = listaTramites();
        
        if ( tramites.isEmpty() ) {
            
            listaTramites.forEach( tramite -> crearTramite(new Tramite(tramite)));
        }
    }

    
   

    

    
    
    
}
