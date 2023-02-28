

package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class LocalidadDTO {

    private int idLocalidad;
    private String nombre;
    private ProvinciaDTO provincia;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public LocalidadDTO() {
    }

    public LocalidadDTO(int idLocalidad, String nombre) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
    }

    public LocalidadDTO(String nombre, ProvinciaDTO provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public LocalidadDTO(int idLocalidad, String nombre, ProvinciaDTO provincia) {
        this.idLocalidad = idLocalidad;
        this.nombre = nombre;
        this.provincia = provincia;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idLocalidad;
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
        final LocalidadDTO other = (LocalidadDTO) obj;
        return this.idLocalidad == other.idLocalidad;
    }
    
}
