

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table
@IdClass(PersonaHabilidadID.class)
@Getter
@Setter
public class PersonaHabilidad {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona personaHab;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_habilidad")
    private Habilidad habilidad;
    
    private short progreso;

    public PersonaHabilidad() {
    }

    public PersonaHabilidad(Persona personaHab, Habilidad habilidad, short progreso) {
        this.personaHab = personaHab;
        this.habilidad = habilidad;
        this.progreso = progreso;
    }
    
}
