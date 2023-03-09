
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.PersonaProyecto;
import com.portfolio.PortfolioBackend.model.PersonaProyectoID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface PersonaProyectoRepository extends JpaRepository<PersonaProyecto, PersonaProyectoID> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM persona_proyecto "
                 + "WHERE persona_proyecto.id_persona = (?1)")
    public List<PersonaProyecto> traerPersonaProyectoQuery(int idPersona);
    
}
