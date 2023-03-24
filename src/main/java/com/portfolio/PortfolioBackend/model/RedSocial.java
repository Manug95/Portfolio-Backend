
package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "redes_sociales")
public class RedSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_red_social")
    private int idRedSocial;
    
    @Column(name = "red_social")
    private String redSocial;
    
    @ManyToOne
    @JoinColumn(name="id_persona", nullable=false)
    private Persona personaRS;
    
    //---------------------------------------------------------------CONSTRUCTORES--------------------------------------------------------------

    public RedSocial() {
    }

    public RedSocial(String redSocial, Persona personaRS) {
        this.redSocial = redSocial;
        this.personaRS = personaRS;
    }

    public RedSocial(int idRedSocial, String redSocial, Persona personaRS) {
        this.idRedSocial = idRedSocial;
        this.redSocial = redSocial;
        this.personaRS = personaRS;
    }
    
    //---------------------------------------------------------------GETTERS & SETTERS----------------------------------------------------------

    public int getIdRedSocial() {
        return idRedSocial;
    }

    public void setIdRedSocial(int idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    public String getRedSocial() {
        return redSocial;
    }

    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    public Persona getpersonaRS() {
        return personaRS;
    }

    public void setpersonaRS(Persona personaRS) {
        this.personaRS = personaRS;
    }
    
}
