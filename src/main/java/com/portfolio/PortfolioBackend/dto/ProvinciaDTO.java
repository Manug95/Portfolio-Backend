

package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class ProvinciaDTO {

    private int idProvincia;
    private String nombre;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public ProvinciaDTO() {
    }

    public ProvinciaDTO(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaDTO(int idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idProvincia;
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
        final ProvinciaDTO other = (ProvinciaDTO) obj;
        return this.idProvincia == other.idProvincia;
    }
    
}
