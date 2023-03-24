
package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Manuel
 */
@Entity
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name = "apellido", length = 45)
    private String apellido;
    
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name = "sobre_mi", length = 1500)
    private String SobreMi;
    
    @OneToOne(mappedBy = "personaUser")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "personaEmail")
    private List<Email> emails;
    
    @OneToMany(mappedBy = "personaTel")
    private List<Telefono> telefonos;
    
    @OneToMany(mappedBy = "personaExp")
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "educacion")
    private List<PersonaEducacion> estudios;
    
    @OneToMany(mappedBy = "personaProy")
    private List<PersonaProyecto> proyectos;
    
    @OneToMany(mappedBy = "habilidad")
    private List<PersonaHabilidad> habilidades;
    
    @OneToMany(mappedBy = "personaRS")
    private List<RedSocial> redes;
    
    /*
    ManyToOne va en la entidad "muchos" (Persona)
    y es el owning side, creo que es porque en la bd, la tabla que tiene la clave foranea es la tabla del muchos
    */
    @ManyToOne
    //JoinColumn va en la entidad que va a tener la columna con la clave foranea
    @JoinColumn(name="id_domicilio", nullable=true) //id_domicilio va a ser el nombre del campo con la FK del domicilio en la tabla persona
    private Domicilio domicilio; // el mappedBy del ArrayList que esta en Domicilio se tiene que llamar como este atributo

    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------
    
    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    public Persona(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(int idPersona, String nombre, String apellido, LocalDate fechaNacimiento, String sobreMi, Domicilio domicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.SobreMi = sobreMi;
        this.domicilio = domicilio;
    }

    public Persona(Integer idPersona, String nombre, String apellido, LocalDate fechaNacimiento, String sobreMi, List<Email> emails, List<Telefono> telefonos, Domicilio domicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.SobreMi = sobreMi;
        this.emails = emails;
        this.telefonos = telefonos;
        this.domicilio = domicilio;
    }
    
    //---------------------------------------------------------------Getters & Setters----------------------------------------------------------

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
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
        return SobreMi;
    }

    public void setSobreMi(String SobreMi) {
        this.SobreMi = SobreMi;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<PersonaEducacion> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<PersonaEducacion> estudios) {
        this.estudios = estudios;
    }

    public List<PersonaProyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<PersonaProyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<PersonaHabilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<PersonaHabilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<RedSocial> getRedes() {
        return redes;
    }

    public void setRedes(List<RedSocial> redes) {
        this.redes = redes;
    }
    
}
