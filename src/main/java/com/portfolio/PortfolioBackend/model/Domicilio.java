
package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    
    @Column(name = "calle")
    private String calle;
    
    @Column(name = "altura")
    private int altura;

    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------
    
    public Domicilio() {
    }

    public Domicilio(String calle, int altura) {
        this.calle = calle;
        this.altura = altura;
    }

    public Domicilio(int idDomicilio, String calle, int altura) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
    }
    
}
