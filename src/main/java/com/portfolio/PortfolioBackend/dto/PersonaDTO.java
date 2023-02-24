

package com.portfolio.PortfolioBackend.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Gutiérrez
 */
@Component
@Getter
@Setter
public class PersonaDTO {

    private int idPersona;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer idDomicilio;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaDTO(String nombre, String apellido, LocalDate fechaNacimiento, Integer idDomicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, Integer idDomicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.idDomicilio = idDomicilio;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idPersona;
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
        final PersonaDTO other = (PersonaDTO) obj;
        return this.idPersona == other.idPersona;
    }
    
}
