

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "educacion")
@Getter
@Setter
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_educacion")
    private int idEducacion;
    
    @Column(name = "nombre_institucion", length = 45, nullable = false)
    private String nombreInstitucion;
    
    @Column(name = "titulo_estudios", length = 45, nullable = false)
    private String tituloEstudios;
    
    @Column(name = "logo_institucion")
    private String logoInstitucion;
    
    @OneToMany(mappedBy = "estudiante")
    private List<PersonaEducacion> estudiantes;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public Educacion() {
    }

    public Educacion(String nombreInstitucion, String tituloEstudios, String logoInstitucion, ArrayList<PersonaEducacion> estudiantes) {
        this.nombreInstitucion = nombreInstitucion;
        this.tituloEstudios = tituloEstudios;
        this.logoInstitucion = logoInstitucion;
        this.estudiantes = estudiantes;
    }
    
    public Educacion(int idEducacion, String nombreInstitucion, String tituloEstudios, String logoInstitucion) {
        this.idEducacion = idEducacion;
        this.nombreInstitucion = nombreInstitucion;
        this.tituloEstudios = tituloEstudios;
        this.logoInstitucion = logoInstitucion;
    }

    public Educacion(int idEducacion, String nombreInstitucion, String tituloEstudios, String logoInstitucion, ArrayList<PersonaEducacion> estudiantes) {
        this.idEducacion = idEducacion;
        this.nombreInstitucion = nombreInstitucion;
        this.tituloEstudios = tituloEstudios;
        this.logoInstitucion = logoInstitucion;
        this.estudiantes = estudiantes;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idEducacion;
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
        final Educacion other = (Educacion) obj;
        return this.idEducacion == other.idEducacion;
    }
    
}
