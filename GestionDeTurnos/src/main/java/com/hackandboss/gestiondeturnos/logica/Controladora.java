
package com.hackandboss.gestiondeturnos.logica;

import com.hackandboss.gestiondeturnos.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearTramite(Tramite tramite) {
        
        controlPersis.crearTramite(tramite);
    }

    public List<Tramite> listaTramites() {
        
        return controlPersis.listaTramites();
    }

   

    

    
    
    
}
