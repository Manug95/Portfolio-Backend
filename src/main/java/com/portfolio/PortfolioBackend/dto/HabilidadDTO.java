
package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class HabilidadDTO {

    private int idHabilidad;
    private String nombreHabilidad;
    private String tipoHabilidad;
    private short progreso;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public HabilidadDTO() {
    }

    public HabilidadDTO(String nombreHabilidad, String tipoHabilidad, short progreso) {
        this.nombreHabilidad = nombreHabilidad;
        this.tipoHabilidad = tipoHabilidad;
        this.progreso = progreso;
    }

    public HabilidadDTO(int idHabilidad, String nombreHabilidad, String tipoHabilidad, short progreso) {
        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
        this.tipoHabilidad = tipoHabilidad;
        this.progreso = progreso;
    }

}
