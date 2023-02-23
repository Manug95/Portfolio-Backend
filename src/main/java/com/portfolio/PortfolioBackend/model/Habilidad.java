

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
@Table(name = "habilidades")
@Getter
@Setter
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad")
    private int idHabilidad;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "tipo_habilidad")
    private TipoHabilidad tipoHabilidad;
    
    @OneToMany(mappedBy = "personaHab")
    private ArrayList<PersonaHabilidad> personas;
    
}
