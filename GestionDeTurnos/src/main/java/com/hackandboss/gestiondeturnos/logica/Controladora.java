
package com.hackandboss.gestiondeturnos.logica;

import com.hackandboss.gestiondeturnos.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Controladora {
    
    // Instancia de la ControladoraPersistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
    // Creamos PREDICATE para las condiciones repetitivas
    Predicate<Turno> isBorrado = turno -> turno.isBorrado() == false;
    Predicate<Turno> isEstadoCompletado = turno -> turno.isEstadoCompletado()== false;


    
    //--------------------------------------------
    
    // 1) Métodos de creación
    
    public void crearTramite(Tramite tramite) {
        
        controlPersis.crearTramite(tramite);
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
    
    
    
    //----------------------------------------------
    
    // 2) Métodos de obtenión de listas completas 

    public List<Tramite> listaTramites() {
        
        return controlPersis.listaTramites();
    }
    
    
    public List<Turno> listadoTotalTurnos() {
        
        // filtramos por la condicion de que no este borrado ni completado el turno
        return controlPersis.listadoTotalTurnos().stream()
                .filter( isBorrado)
                .filter( isEstadoCompletado)
                .sorted((x, y) -> x.getFecha().compareTo(y.getFecha()))
                .toList();
        
    }
    
    
    public List<LocalDate> listadoFechas() {
        
        // mapeamos el listado de turnos para quedarnos solamente con las fechas y luego las agrupamos para obtener un listado sin fechas repetidas
         return controlPersis.listadoTotalTurnos().stream()
                .filter( isBorrado)
                .map( turno -> turno.getFecha())
                .distinct()
                .toList();
                
    }
    
    
    
    //----------------------------------------------
    
    // 3) Métodos filtrado información por algun parámetro pasado
  
    public Ciudadano buscarCiudadano(String dni) {

        // comparamos si el dni existe o no ya en la BBDD
        Ciudadano ciudadano = controlPersis.listaCiudadanos().stream()
                .filter( c -> c.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(new Ciudadano());
                       
        
        return ciudadano;
    }

    
    public List<Turno> buscarTurnosCiudadano(String dni) {
        
        
        Ciudadano ciudadano = controlPersis.buscarCiudadano(dni);
        
        // si el ciudadano no existe devolvemos una lista vacia que la utilizaremos en el servlets como bandera
        if (ciudadano == null) {
            
            List<Turno> listaVacia = new ArrayList<>();
            
            return  listaVacia;
        }
        
        List<Turno> turnosCiudadanoActivos = controlPersis.buscarTurnosCiudadano(ciudadano.getId()).stream()
                .filter( isBorrado)
                .filter(isEstadoCompletado)
                .toList();
        
        return turnosCiudadanoActivos;
    }

    
    public Turno buscarTurno(String id) {
        
        return controlPersis.buscarTurno(id);
    }

    
    public List<Turno> turnosFiltrados(LocalDate fecha, String estado) {
        
        List<Turno> listadoFecha = controlPersis.listadoTotalTurnos().stream()
                .filter( isBorrado)
                .filter( turno -> turno.getFecha().equals(fecha))
                .toList();
        
        
        // Si la bandera "estado" es nula significa que el usuario no ha seleccionado el 
        // filtro de estado por lo que se envia el listado con el filtro solo de la fecha
        if( estado == null) {

            return listadoFecha;
            
        }
        else {
            
            // si "estado" tiene valor evaluamos cual es para que filtremos según corresponda
            if ("Atendido".equals(estado)){
                
                return listadoFecha.stream()
                        .filter( turno -> turno.isEstadoCompletado() == true)
                        .toList();
            }            
              
            return listadoFecha.stream()
                    .filter( isEstadoCompletado)
                    .toList();
           
        }
    }
    
    
    public Tramite obtenerTramiteSeleccionado(String tramiteString) {
        
        // traemos el tramite correspondiente al seleccionado por el usuario
        return listaTramites().stream()
                .filter( t -> t.getDescripcion().equalsIgnoreCase(tramiteString))
                .findFirst()
                .orElse(new Tramite());
    }

    
    
     //----------------------------------------------
    
    // 4) Métodos de edición de algun de los atributos de turno
    
    public void editarTurno(Turno turno, Tramite tramite, String filtro) {
        
        
        // con el valor de "filtro" usado como vandera se realizará una opción o otra
         if( filtro.equalsIgnoreCase("borrar")) {
             
             turno.setBorrado(true);
         }
         else {
             
            turno.setTramite(tramite);
         }
        

        controlPersis.editarTurno(turno);
    }

    
    public void turnoCompletado(String id) {
        
        Turno turno = controlPersis.buscarTurno(id);
        
        turno.setEstadoCompletado(true);
        
        controlPersis.editarTurno(turno);
    }
    

    
    //----------------------------------------------
    
    // 4) Métodos de verificación
    
    public Ciudadano verificarCrearCiudadano(String dni) {
        
        //Compruebo si el dni existe ya en la BBDD
        Ciudadano ciudadano = buscarCiudadano(dni);
        
        
        // Si no existe creo una nueva instancia de este DNI en la BBDD
        if (ciudadano.getDni() == null) {
            
            ciudadano.setDni(dni);
            crearCiudadano(ciudadano);
        }
        
        return ciudadano;
    }


    public void verificarInsertarTramites(List<String> listaTramites) {
        
        List<Tramite> tramites = listaTramites();
        
        // Si la tabla de tramites está vacia, la relleno con el listado predeterminado como atributo en el servlets TramitesSV
        if ( tramites.isEmpty() ) {
            
            listaTramites.forEach( tramite -> crearTramite(new Tramite(tramite)));
        }
    }   
    
    
}
