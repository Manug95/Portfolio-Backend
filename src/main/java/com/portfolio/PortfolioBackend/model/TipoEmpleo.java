

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
@Table(name = "tipo_empleo")
@Getter
@Setter
public class TipoEmpleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_empleo")
    private int idTipoEmpleo;
    
    @Column(name = "tipo", length = 45)
    private String tipo;
    
    @OneToMany(mappedBy = "tipoEmpleo")
    private ArrayList<Experiencia> esperiencias;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public TipoEmpleo() {
    }

    public TipoEmpleo(String tipo, ArrayList<Experiencia> esperiencias) {
        this.tipo = tipo;
        this.esperiencias = esperiencias;
    }

    public TipoEmpleo(int idTipoEmpleo, String tipo, ArrayList<Experiencia> esperiencias) {
        this.idTipoEmpleo = idTipoEmpleo;
        this.tipo = tipo;
        this.esperiencias = esperiencias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idTipoEmpleo;
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
        final TipoEmpleo other = (TipoEmpleo) obj;
        return this.idTipoEmpleo == other.idTipoEmpleo;
    }
    
}
