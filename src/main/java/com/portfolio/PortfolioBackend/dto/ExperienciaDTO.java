
package com.portfolio.PortfolioBackend.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class ExperienciaDTO {

    private int idExperiencia;
    private int idPersona;
    private String nombreExperiencia;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String imgLogo;
    private String tipoExperiencia;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String nombreExperiencia, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String tipoExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoExperiencia = tipoExperiencia;
    }

    public ExperienciaDTO(String nombreExperiencia, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String imgLogo, String tipoExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imgLogo = imgLogo;
        this.tipoExperiencia = tipoExperiencia;
    }

    public ExperienciaDTO(int idPersona, String nombreExperiencia, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String imgLogo, String tipoExperiencia) {
        this.idPersona = idPersona;
        this.nombreExperiencia = nombreExperiencia;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imgLogo = imgLogo;
        this.tipoExperiencia = tipoExperiencia;
    }

    public ExperienciaDTO(int idExperiencia, int idPersona, String nombreExperiencia, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, 
            String imgLogo, String tipoExperiencia) {
        this.idExperiencia = idExperiencia;
        this.idPersona = idPersona;
        this.nombreExperiencia = nombreExperiencia;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imgLogo = imgLogo;
        this.tipoExperiencia = tipoExperiencia;
    }
    
}
