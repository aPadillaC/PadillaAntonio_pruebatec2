
package com.hackandboss.gestiondeturnos.persistencia;


import com.hackandboss.gestiondeturnos.logica.Tramite;
import com.hackandboss.gestiondeturnos.logica.Turno;
import java.util.List;

public class ControladoraPersistencia {
    
    TramiteJpaController tramiteJpa = new TramiteJpaController();    
    TurnoJpaController turnoJpa = new TurnoJpaController();

    public void crearTramite(Tramite tramite) {
        
        tramiteJpa.create(tramite);
    }

    public List<Tramite> listaTramites() {
        
        return tramiteJpa.findTramiteEntities();
    }

    
    
}
