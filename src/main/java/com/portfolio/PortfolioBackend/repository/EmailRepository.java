
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Email;
import com.portfolio.PortfolioBackend.model.EmailID;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
@Transactional //esta annotation es para poder hacer las query con UPDATE y DELETE
public interface EmailRepository extends JpaRepository<Email, EmailID> {
    
    @Modifying
    @Query(nativeQuery = true,
           value = "UPDATE emails "
                 + "SET emails.email = (?1) "
                 + "WHERE emails.email = (?2) AND id_persona = (?3);")
    public  void editarEmailQuery(String emailNuevo, String emailViejo, int idPersona);
    
}
