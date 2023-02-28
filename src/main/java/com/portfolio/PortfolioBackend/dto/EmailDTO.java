

package com.portfolio.PortfolioBackend.dto;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class EmailDTO {

    private String email;
    private Integer idPersona;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public EmailDTO() {
    }

    public EmailDTO(String email, Integer idPersona) {
        this.email = email;
        this.idPersona = idPersona;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.idPersona);
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
        final EmailDTO other = (EmailDTO) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.idPersona, other.idPersona);
    }
    
}
