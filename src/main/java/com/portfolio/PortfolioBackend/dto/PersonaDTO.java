

package com.portfolio.PortfolioBackend.dto;

import java.time.LocalDate;
import java.util.List;
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
    private List<EmailDTO> emails;
    private List<TelefonoDTO> telefonos;
    private DomicilioDTO domicilio;
    private List<ExperienciaDTO> experiencias;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaDTO(String nombre, String apellido, LocalDate fechaNacimiento, DomicilioDTO domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, List<EmailDTO> emails, List<TelefonoDTO> telefonos) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.emails = emails;
        this.telefonos = telefonos;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, DomicilioDTO domicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, List<EmailDTO> emails, DomicilioDTO domicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.emails = emails;
        this.domicilio = domicilio;
    }

    public PersonaDTO(String nombre, String apellido, LocalDate fechaNacimiento, List<EmailDTO> emails, List<TelefonoDTO> telefonos, DomicilioDTO domicilio, 
            List<ExperienciaDTO> experiencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.emails = emails;
        this.telefonos = telefonos;
        this.domicilio = domicilio;
        this.experiencias = experiencias;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, List<EmailDTO> emails, List<TelefonoDTO> telefonos, DomicilioDTO domicilio,
            List<ExperienciaDTO> experiencias) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.emails = emails;
        this.telefonos = telefonos;
        this.domicilio = domicilio;
        this.experiencias = experiencias;
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
