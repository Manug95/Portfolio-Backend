
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Telefono;
import com.portfolio.PortfolioBackend.model.TelefonoID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, TelefonoID> {
    
}
