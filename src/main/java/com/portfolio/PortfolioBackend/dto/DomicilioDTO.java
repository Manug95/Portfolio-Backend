

package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class DomicilioDTO {

    private int idDomicilio;
    private String calle;
    private int altura;
    private LocalidadDTO localidad;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public DomicilioDTO() {
    }

    public DomicilioDTO(int idDomicilio, String calle, int altura) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
    }

    public DomicilioDTO(String calle, int altura, LocalidadDTO localidad) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }

    public DomicilioDTO(int idDomicilio, String calle, int altura, LocalidadDTO localidad) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idDomicilio;
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
        final DomicilioDTO other = (DomicilioDTO) obj;
        return this.idDomicilio == other.idDomicilio;
    }
    
}
