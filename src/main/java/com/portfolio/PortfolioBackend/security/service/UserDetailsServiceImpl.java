
package com.portfolio.PortfolioBackend.security.service;

import com.portfolio.PortfolioBackend.model.Usuario;
import com.portfolio.PortfolioBackend.security.model.UsuarioPrincipal;
import com.portfolio.PortfolioBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService userServ;
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        
        Usuario usuario = this.userServ.traerPorNombreUsuario(nombreUsuario);
        
        if (usuario != null) {
            return UsuarioPrincipal.build(usuario);
        } else {
            return null;
        }
        
    }

    
    
}
