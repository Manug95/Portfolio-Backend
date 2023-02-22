
package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Column(name = "nombre_usuario", length = 20)
    private String nombreUsuario;
    
    @Column(name = "contrasenia", length = 50)
    private String contrasena;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona personaUser;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(String nombreUsuario, String contrasena, Persona personaUser) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.personaUser = personaUser;
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrasena, Persona personaUser) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.personaUser = personaUser;
    }
    
}
