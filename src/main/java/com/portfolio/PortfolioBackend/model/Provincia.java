
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
@Table(name = "provincias")
@Getter
@Setter
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provincia")
    private int idProvincia;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @OneToMany(mappedBy = "provincia")
    private ArrayList<Localidad> localidades;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public Provincia() {
    }

    public Provincia(String nombre) {
        this.nombre = nombre;
    }
    
    public Provincia(String nombre, ArrayList<Localidad> localidades) {
        this.nombre = nombre;
        this.localidades = localidades;
    }

    public Provincia(int idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }
    public Provincia(int idProvincia, String nombre, ArrayList<Localidad> localidades) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
        this.localidades = localidades;
    }
    
}
