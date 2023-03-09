
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.PersonaEducacion;
import com.portfolio.PortfolioBackend.model.PersonaEducacionID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface PersonaEducacionRepository extends JpaRepository<PersonaEducacion, PersonaEducacionID> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM persona_estudio "
                 + "WHERE persona_estudio.id_persona = (?1)")
    public List<PersonaEducacion> traerPersonaEducacionQuery(int idPersona);
    
}
