

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "persona_proyecto")
@IdClass(PersonaProyectoID.class)
@Getter
@Setter
public class PersonaProyecto {

    @Id
    @JoinColumn(name = "id_persona")
    @ManyToOne
    private Persona personaProy;
    
    @Id
    @JoinColumn(name = "id_proyecto")
    @ManyToOne
    private Proyecto proyecto;
    
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public PersonaProyecto() {
    }

    public PersonaProyecto(Persona personaProy, Proyecto proyecto, LocalDate fechaInicio, LocalDate fechaFin) {
        this.personaProy = personaProy;
        this.proyecto = proyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.personaProy);
        hash = 47 * hash + Objects.hashCode(this.proyecto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonaProyecto other = (PersonaProyecto) obj;
        if (!Objects.equals(this.personaProy, other.personaProy)) {
            return false;
        }
        return Objects.equals(this.proyecto, other.proyecto);
    }
    
}
