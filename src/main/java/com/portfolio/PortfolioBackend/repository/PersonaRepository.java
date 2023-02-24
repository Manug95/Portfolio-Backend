
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
}
