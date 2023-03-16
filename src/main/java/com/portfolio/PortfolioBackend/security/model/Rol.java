
package com.portfolio.PortfolioBackend.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Manuel Gutiérrez
 */
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    
    @Column(name = "nombre_rol", nullable = false)
    private String rolNombre;
    
    //-----------------------------------------------------------------CONSTRUCTORES------------------------------------------------------------
    
    public Rol() {
    }

    public Rol(String rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    //---------------------------------------------------------------Getters & Setters----------------------------------------------------------

    public int getId() {
        return this.idRol;
    }

    public void setId(int idRol) {
        this.idRol = idRol;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
