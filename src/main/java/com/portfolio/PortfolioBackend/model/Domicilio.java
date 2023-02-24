
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
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel
 */
@Entity
@Table(name = "domicilios")
@Getter
@Setter
public class Domicilio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private int idDomicilio;
    
    @Column(name = "calle", length = 50)
    private String calle;
    
    @Column(name = "altura")
    private int altura;
    
    @OneToMany(mappedBy = "domicilio") // mappedBy tiene que llamarse como el atributo tipo Domicilio que tiene Persona
    private List<Persona> personas;
    
    @ManyToOne
    @JoinColumn(name = "id_localidad", nullable = false)
    private Localidad localidad;

    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------
    
    public Domicilio() {
    }

    public Domicilio(String calle, int altura) {
        this.calle = calle;
        this.altura = altura;
    }
    
    public Domicilio(String calle, int altura, ArrayList<Persona> personas) {
        this.calle = calle;
        this.altura = altura;
        this.personas = personas;
    }
    
    public Domicilio(String calle, int altura, Localidad localidad) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }
    
    public Domicilio(String calle, int altura, ArrayList<Persona> personas, Localidad localidad) {
        this.calle = calle;
        this.altura = altura;
        this.personas = personas;
        this.localidad = localidad;
    }

    public Domicilio(int idDomicilio, String calle, int altura) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
    }
    
    public Domicilio(int idDomicilio, String calle, int altura, ArrayList<Persona> personas) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.personas = personas;
    }
    
    public Domicilio(int idDomicilio, String calle, int altura, Localidad localidad) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }
    
    public Domicilio(int idDomicilio, String calle, int altura, ArrayList<Persona> personas, Localidad localidad) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.personas = personas;
        this.localidad = localidad;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.idDomicilio;
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
        final Domicilio other = (Domicilio) obj;
        return this.idDomicilio == other.idDomicilio;
    }
    
}
