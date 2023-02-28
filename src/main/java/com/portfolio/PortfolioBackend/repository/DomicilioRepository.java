
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
    
}
