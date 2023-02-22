
package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "localidades")
@Getter
@Setter
public class Localidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad")
    private int idLocalidad;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @OneToMany(mappedBy = "localidad")
    private ArrayList<Domicilio> domicilios;
    
    @ManyToOne
    @JoinColumn(name = "id_provincia", nullable = false)
    private Provincia provincia;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public Localidad() {
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }
    
    public Localidad(String nombre, ArrayList<Domicilio> domicilios) {
        this.nombre = nombre;
        this.domicilios = domicilios;
    }
    
    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }
    
    public Localidad(String nombre, ArrayList<Domicilio> domicilios, Provincia provincia) {
        this.nombre = nombre;
        this.domicilios = domicilios;
        this.provincia = provincia;
    }

    public Localidad(int idLocalidad, String nombre) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
    }
    
    public Localidad(int idLocalidad, String nombre, ArrayList<Domicilio> domicilios) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.domicilios = domicilios;
    }
    
    public Localidad(int idLocalidad, String nombre, Provincia provincia) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.provincia = provincia;
    }
    
    public Localidad(int idLocalidad, String nombre, ArrayList<Domicilio> domicilios, Provincia provincia) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.domicilios = domicilios;
        this.provincia = provincia;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idLocalidad;
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
        final Localidad other = (Localidad) obj;
        return this.idLocalidad == other.idLocalidad;
    }
    
}
