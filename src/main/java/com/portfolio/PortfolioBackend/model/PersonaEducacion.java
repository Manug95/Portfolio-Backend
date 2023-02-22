

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "persona_estudio")
@IdClass(PersonaEducacionID.class)
@Getter
@Setter
public class PersonaEducacion {

//    @EmbeddedId
//    private PersonaEducacionID idPersoEdu;
    
    @Id
    @ManyToOne
    //@MapsId("idEstudiante")
    @JoinColumn(name = "id_persona")
    private Persona estudiante;
    
    @Id
    @ManyToOne
    //@MapsId("idEducacion")
    @JoinColumn(name = "id_educacion")
    private Educacion educacion;
    
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public PersonaEducacion() {
    }

    public PersonaEducacion(Persona estudiante, Educacion educacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.estudiante = estudiante;
        this.educacion = educacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

//    public PersonaEducacion(PersonaEducacionID idPersoEdu, Persona estudiante, Educacion educacion, LocalDate fechaInicio, LocalDate fechaFin) {
//        //this.idPersoEdu = idPersoEdu;
//        this.estudiante = estudiante;
//        this.educacion = educacion;
//        this.fechaInicio = fechaInicio;
//        this.fechaFin = fechaFin;
//    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.estudiante);
        hash = 41 * hash + Objects.hashCode(this.educacion);
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
        final PersonaEducacion other = (PersonaEducacion) obj;
        if (!Objects.equals(this.estudiante, other.estudiante)) {
            return false;
        }
        return Objects.equals(this.educacion, other.educacion);
    }

    
    
}
