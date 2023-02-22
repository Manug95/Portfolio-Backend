

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "experiencias")
@Getter
@Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia")
    private int idExperiencia;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    
    @Column(name = "logo")
    private String logoImg;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona personaExp;
    
    @ManyToOne
    @JoinColumn(name = "tipo_empleo")
    private TipoEmpleo tipoEmpleo;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public Experiencia() {
    }

    public Experiencia(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String logoImg, Persona personaExp, TipoEmpleo tipoEmpleo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoImg = logoImg;
        this.personaExp = personaExp;
        this.tipoEmpleo = tipoEmpleo;
    }

    public Experiencia(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Persona personaExp, TipoEmpleo tipoEmpleo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.personaExp = personaExp;
        this.tipoEmpleo = tipoEmpleo;
    }

    public Experiencia(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Experiencia(int idExperiencia, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String logoImg, Persona personaExp, TipoEmpleo tipoEmpleo) {
        this.idExperiencia = idExperiencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.logoImg = logoImg;
        this.personaExp = personaExp;
        this.tipoEmpleo = tipoEmpleo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idExperiencia;
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
        final Experiencia other = (Experiencia) obj;
        return this.idExperiencia == other.idExperiencia;
    }
    
}
