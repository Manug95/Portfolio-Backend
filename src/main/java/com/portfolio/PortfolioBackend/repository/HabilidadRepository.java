
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {
    
}
