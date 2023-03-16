
package com.portfolio.PortfolioBackend.security.dto;

/**
 * @author Manuel Gutiérrez
 */
public class Login {

    private String nombreUsuario;
    private String contrasenia;

    public Login() {
    }

    public Login(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
