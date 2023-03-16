
package com.portfolio.PortfolioBackend.security.service;

import com.portfolio.PortfolioBackend.security.model.Rol;
import com.portfolio.PortfolioBackend.security.repository.RolRepository;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
@Transactional
public class RolService implements IRolService {

    @Autowired
    private RolRepository rolRepo;

    @Override
    public Optional<Rol> traerPorRolNombre(String rolNombre) {
        
        try {
            return this.rolRepo.findByRolNombre(rolNombre);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer Rol por nombre");
            return null;
        }
        
    }
    
}
