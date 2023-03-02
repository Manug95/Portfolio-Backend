
package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class EditarEmailDTO {

    private String emailNuevo;
    private String emailViejo;
    private int idPersona;

    public EditarEmailDTO() {
    }

    public EditarEmailDTO(String emailNuevo, String emailViejo, int idPersona) {
        this.emailNuevo = emailNuevo;
        this.emailViejo = emailViejo;
        this.idPersona = idPersona;
    }
    
}
