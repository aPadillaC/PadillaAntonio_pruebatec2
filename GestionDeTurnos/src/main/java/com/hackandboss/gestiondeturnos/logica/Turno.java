
package com.hackandboss.gestiondeturnos.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long numero;
    private LocalDate fecha;
    private boolean estadoCompletado;
    private boolean borrado;
    
    @ManyToOne
    @JoinColumn(name="ciudadano_id")
    private Ciudadano ciudadano;
    
    @ManyToOne
    private Tramite tramite;

    public Turno() {
        
        this.fecha = LocalDate.now();
        this.estadoCompletado = false;
        this.borrado = false;
    }

    public Turno(LocalDate fecha, boolean estadoCompletado, boolean borrado, Ciudadano ciudadano, Tramite tramite) {
        
        this.fecha = fecha;
        this.estadoCompletado = estadoCompletado;
        this.borrado = borrado;
        this.ciudadano = ciudadano;
        this.tramite = tramite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstadoCompletado() {
        return estadoCompletado;
    }

    public void setEstadoCompletado(boolean estadoCompletado) {
        this.estadoCompletado = estadoCompletado;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

 
    

    
    
    
}
