
package com.hackandboss.gestiondeturnos.persistencia;


import com.hackandboss.gestiondeturnos.logica.Ciudadano;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    TramiteJpaController tramiteJpa = new TramiteJpaController();    
    TurnoJpaController turnoJpa = new TurnoJpaController();
    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();

    public void crearTramite(Tramite tramite) {
        
        tramiteJpa.create(tramite);
    }

    public List<Tramite> listaTramites() {
        
        return tramiteJpa.findTramiteEntities();
    }

    public void crearCiudadano(Ciudadano ciudadano) {
        
        ciudadanoJpa.create(ciudadano);
    }

    public void crearTurno(Turno turno) {
        
        turnoJpa.create(turno);
    }

    public List<Ciudadano> listaCiudadanos() {
        
        return ciudadanoJpa.findCiudadanoEntities();
    }

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

    public void editarTurno(Turno turno) {

        try {
            turnoJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turno> listadoTotalTurnos() {
        
        return turnoJpa.findTurnoEntities();
    }

    
    
}
