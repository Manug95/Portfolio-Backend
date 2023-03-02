
package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class EditarTelefonoDTO {

    private long telNuevo;
    private long telViejo;
    private int idPersona;

    public EditarTelefonoDTO() {
    }

    public EditarTelefonoDTO(long telNuevo, long telViejo, int idPersona) {
        this.telNuevo = telNuevo;
        this.telViejo = telViejo;
        this.idPersona = idPersona;
    }
    
}
