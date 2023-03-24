

package com.portfolio.PortfolioBackend.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Gutiérrez
 */
@Component
public class PersonaDTO {

    private int idPersona;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String sobreMi;
    private List<EmailDTO> emails;
    private List<TelefonoDTO> telefonos;
    private DomicilioDTO domicilio;
    private List<ExperienciaDTO> experiencias;
    private List<HabilidadDTO> habilidades;
    private List<EducacionDTO> educaciones;
    private List<ProyectoDTO> proyectos;
    //private Set<String> roles;
    
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

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, String sobreMi, DomicilioDTO domicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sobreMi = sobreMi;
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

    public PersonaDTO(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, String sobreMi, List<EmailDTO> emails, List<TelefonoDTO> telefonos, DomicilioDTO domicilio,
            List<ExperienciaDTO> experiencias, List<HabilidadDTO> habilidades, List<EducacionDTO> educaciones, List<ProyectoDTO> proyectos) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sobreMi = sobreMi;
        this.emails = emails;
        this.telefonos = telefonos;
        this.domicilio = domicilio;
        this.experiencias = experiencias;
        this.habilidades = habilidades;
        this.educaciones = educaciones;
        this.proyectos = proyectos;
    }
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }

    public List<TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }

    public DomicilioDTO getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDTO domicilio) {
        this.domicilio = domicilio;
    }

    public List<ExperienciaDTO> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<ExperienciaDTO> experiencias) {
        this.experiencias = experiencias;
    }

    public List<HabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabilidadDTO> habilidades) {
        this.habilidades = habilidades;
    }

    public List<EducacionDTO> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<EducacionDTO> educaciones) {
        this.educaciones = educaciones;
    }

    public List<ProyectoDTO> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<ProyectoDTO> proyectos) {
        this.proyectos = proyectos;
    }

//    public Set<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<String> roles) {
//        this.roles = roles;
//    }
    
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
