
package com.portfolio.PortfolioBackend.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class ProyectoDTO {

    private int idProyecto;
    private String nombreProyecto;
    private String descripcion;
    private String urlRepositorio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public ProyectoDTO() {
    }

    public ProyectoDTO(String nombreProyecto, String descripcion, String urlRepositorio, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.urlRepositorio = urlRepositorio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ProyectoDTO(int idProyecto, String nombreProyecto, String descripcion, String urlRepositorio, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.urlRepositorio = urlRepositorio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
}
