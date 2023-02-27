

package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class UsuarioPersonaDTO {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private PersonaDTO persona;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public UsuarioPersonaDTO() {
    }

    public UsuarioPersonaDTO(String nombreUsuario, String contrasenia, PersonaDTO persona) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.persona = persona;
    }

    public UsuarioPersonaDTO(int idUsuario, String nombreUsuario, String contrasenia, PersonaDTO persona) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.persona = persona;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idUsuario;
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
        final UsuarioPersonaDTO other = (UsuarioPersonaDTO) obj;
        return this.idUsuario == other.idUsuario;
    }
    
}
