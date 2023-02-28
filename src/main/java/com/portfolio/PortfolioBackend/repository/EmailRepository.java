
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Email;
import com.portfolio.PortfolioBackend.model.EmailID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, EmailID> {
    
}
