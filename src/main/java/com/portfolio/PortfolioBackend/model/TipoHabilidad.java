
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
@Table(name = "tipo_habilidad")
@Getter
@Setter
public class TipoHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habilidad")
    private int idTipoHabilidad;
    
    @Column(name = "nombre_tipo_habilidad", length = 45)
    private String nombreTipoHabilidad;
    
    @OneToMany(mappedBy = "tipoHabilidad")
    private ArrayList<Habilidad> habilidades;
    
}
