

package com.portfolio.PortfolioBackend.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */

@Getter
@Setter
public class UsuarioDTO {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private Integer idPersona;
    private Set<String> roles;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public UsuarioDTO(String nombreUsuario, String contrasenia, Integer idPersona, Set<String> roles) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.roles = roles;
    }

    public UsuarioDTO(int idUsuario, String nombreUsuario, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public UsuarioDTO(int idUsuario, String nombreUsuario, String contrasenia, Integer idPersona,Set<String> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.idPersona = idPersona;
        this.roles = roles;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idUsuario;
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        return this.idUsuario == other.idUsuario;
    }
    
}
