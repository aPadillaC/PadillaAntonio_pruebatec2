package com.hackandboss.gestiondeturnos.logica;

import com.hackandboss.gestiondeturnos.logica.Ciudadano;
import com.hackandboss.gestiondeturnos.logica.Tramite;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-03-22T16:28:57")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, LocalDate> fecha;
    public static volatile SingularAttribute<Turno, Long> numero;
    public static volatile SingularAttribute<Turno, Tramite> tramite;
    public static volatile SingularAttribute<Turno, Boolean> borrado;
    public static volatile SingularAttribute<Turno, Boolean> estadoCompletado;
    public static volatile SingularAttribute<Turno, Long> id;
    public static volatile SingularAttribute<Turno, Ciudadano> ciudadano;

}