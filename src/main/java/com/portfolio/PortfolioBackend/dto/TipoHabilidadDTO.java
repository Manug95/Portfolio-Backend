

package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class TipoHabilidadDTO {

    private int idTipoHabilidad;
    private String nombreTipoHabilidad;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public TipoHabilidadDTO() {
    }

    public TipoHabilidadDTO(int idTipoHabilidad, String nombreTipoHabilidad) {
        this.idTipoHabilidad = idTipoHabilidad;
        this.nombreTipoHabilidad = nombreTipoHabilidad;
    }
    
}
