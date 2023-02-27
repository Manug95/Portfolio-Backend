
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.dto.UsuarioPersonaDTO;
import com.portfolio.PortfolioBackend.model.Usuario;

/**
 * @author Manuel
 */
public interface IUsuarioService {
    
    public int crearUsuario(UsuarioPersonaDTO usuario)  throws Exception;
    
    public UsuarioDTO autenticarUsuario(String nombreUsuario, String contrasenia);
    
    public UsuarioDTO traerUsuarioDTO(int id);
    
    public Usuario traerUsuario(int id);
    
}
