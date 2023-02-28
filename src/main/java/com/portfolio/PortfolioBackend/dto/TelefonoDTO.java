
package com.portfolio.PortfolioBackend.dto;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class TelefonoDTO {

    private Long telefono;
    private Integer idPersona;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public TelefonoDTO() {
    }

    public TelefonoDTO(Long telefono, Integer idPersona) {
        this.telefono = telefono;
        this.idPersona = idPersona;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.telefono);
        hash = 37 * hash + Objects.hashCode(this.idPersona);
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
        final TelefonoDTO other = (TelefonoDTO) obj;
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.idPersona, other.idPersona);
    }
    
}
