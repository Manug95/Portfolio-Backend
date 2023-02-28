
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Integer> {
    
}
