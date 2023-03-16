
package com.portfolio.PortfolioBackend.security.service;

import com.portfolio.PortfolioBackend.security.model.Rol;
import java.util.Optional;

/**
 * @author Manuel
 */
public interface IRolService {
    
    public Optional<Rol> traerPorRolNombre(String rolNombre);
    
}
