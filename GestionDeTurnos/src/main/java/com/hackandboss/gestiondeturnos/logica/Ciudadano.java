
package com.hackandboss.gestiondeturnos.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Ciudadano implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    
    @OneToMany(mappedBy = "ciudadano")
    private List<Turno> listadoTurnos;

    public Ciudadano() {
        this.listadoTurnos = new ArrayList<>();
    }

    public Ciudadano(String dni, List<Turno> listadoTurnos) {
        this.dni = dni;
        this.listadoTurnos = listadoTurnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Turno> getListadoTurnos() {
        return listadoTurnos;
    }

    public void setListadoTurnos(List<Turno> listadoTurnos) {
        this.listadoTurnos = listadoTurnos;
    }

   
   
    
    
    
}
