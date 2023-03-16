

package com.portfolio.PortfolioBackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class DatosLogin {

    private int idUsuario;
    private String nombreUsuario;
    private int idPersona;
    private String token;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public DatosLogin() {
    }
    
    public DatosLogin(String nombreUsuario, int idPersona) {
        this.nombreUsuario = nombreUsuario;
        this.idPersona = idPersona;
    }
    
    public DatosLogin(int idUsuario, String nombreUsuario, int idPersona) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idPersona = idPersona;
    }

    public DatosLogin(int idUsuario, String nombreUsuario, int idPersona, String token) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idPersona = idPersona;
        this.token = token;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idUsuario;
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
        final DatosLogin other = (DatosLogin) obj;
        return this.idUsuario == other.idUsuario;
    }
    
}
