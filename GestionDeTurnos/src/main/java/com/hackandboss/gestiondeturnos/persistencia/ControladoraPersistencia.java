
package com.hackandboss.gestiondeturnos.persistencia;


import com.hackandboss.gestiondeturnos.logica.Ciudadano;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    //Instancia a los diferentes JpaControllers
    TramiteJpaController tramiteJpa = new TramiteJpaController();    
    TurnoJpaController turnoJpa = new TurnoJpaController();
    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();

    
    
     //--------------------------------------------
    
    // 1) Métodos de creación
    
    public void crearTramite(Tramite tramite) {
        
        tramiteJpa.create(tramite);
    }
    
    
    public void crearCiudadano(Ciudadano ciudadano) {
        
        ciudadanoJpa.create(ciudadano);
    }

    public void crearTurno(Turno turno) {
        
        turnoJpa.create(turno);
    }

    
    
    //----------------------------------------------
    
    // 2) Métodos de obtenión de listas completas 
    
    public List<Tramite> listaTramites() {
        
        return tramiteJpa.findTramiteEntities();
    }

    
    
    public List<Turno> listadoTotalTurnos() {
        
        return turnoJpa.findTurnoEntities();
    }
    

    public List<Ciudadano> listaCiudadanos() {
        
        return ciudadanoJpa.findCiudadanoEntities();
    }

    
     
    //----------------------------------------------
    
    // 3) Métodos filtrado información por algun parámetro pasado
    
    public Ciudadano buscarCiudadano(String dni) {
        
        return ciudadanoJpa.buscarCiudadanoPorDni(dni);
    }

    
    public List<Turno> buscarTurnosCiudadano(Long id) {
        
        return turnoJpa.buscarTurnosCiudadano(id);
    }

    
    public Turno buscarTurno(String id) {
        
        Long idLong = Long.parseLong(id);
        
        return turnoJpa.findTurno(idLong);
    }

    
    
    //----------------------------------------------
    
    // 4) Métodos de edición de algun de los atributos de turno
    public void editarTurno(Turno turno) {

        try {
            turnoJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    
    
}
