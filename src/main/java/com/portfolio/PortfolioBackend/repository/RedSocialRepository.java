
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.RedSocial;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
@Transactional
public interface RedSocialRepository extends JpaRepository<RedSocial, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM redes_sociales "
                 + "WHERE redes_sociales.id_persona = (?1)")
    public List<RedSocial> traerRedesSocialesDeUnaPersonaQuery(int idPersona);
    
}
