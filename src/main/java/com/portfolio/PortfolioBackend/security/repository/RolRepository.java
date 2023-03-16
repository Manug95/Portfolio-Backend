
package com.portfolio.PortfolioBackend.security.repository;

import com.portfolio.PortfolioBackend.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    public Optional<Rol> findByRolNombre(String rolNombre);
    
}
