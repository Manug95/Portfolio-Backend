
package com.portfolio.PortfolioBackend.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class EducacionDTO {

    private int idEducacion;
    private String nombreInstitucion;
    private String tituloDeEstudios;
    private String logoInstitucion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public EducacionDTO() {
    }

    public EducacionDTO(int idEducacion, String nombreInstitucion, String tituloDeEstudios, String logoInstitucion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idEducacion = idEducacion;
        this.nombreInstitucion = nombreInstitucion;
        this.tituloDeEstudios = tituloDeEstudios;
        this.logoInstitucion = logoInstitucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
}
