
package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel
 */
@Entity
@Table(name = "personas")
@Getter
@Setter
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
    
    /*
    ManyToOne va en la entidad "muchos" (Persona)
    y es el owning side, creo que es porque en la bd, la tabla que tiene la clave foranea es la tabla del muchos
    */
    @ManyToOne
    //JoinColumn va en la entidad que va a tener la columna con la clave foranea
    @JoinColumn(name="id_domicilio", nullable=true) //hago referencia a la id de la entidad "uno" OneToMany(Domicilio)
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

    public Persona(Integer idPersona, String nombre, String apellido, LocalDate fechaNacimiento, Domicilio domicilio) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }
    
}
