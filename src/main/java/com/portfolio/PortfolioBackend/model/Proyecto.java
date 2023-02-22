

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "proyectos")
@Getter
@Setter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private int idProyecto;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "url_repo")
    private String urlRepositorio;
    
    @OneToMany(mappedBy = "proyecto")
    private ArrayList<PersonaProyecto> integrantes;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String urlRepositorio, ArrayList<PersonaProyecto> integrantes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlRepositorio = urlRepositorio;
        this.integrantes = integrantes;
    }

    public Proyecto(int idProyecto, String nombre, String descripcion, String urlRepositorio, ArrayList<PersonaProyecto> integrantes) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlRepositorio = urlRepositorio;
        this.integrantes = integrantes;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idProyecto;
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
        final Proyecto other = (Proyecto) obj;
        return this.idProyecto == other.idProyecto;
    }
    
}
