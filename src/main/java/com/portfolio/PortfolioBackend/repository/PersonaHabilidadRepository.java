
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.PersonaHabilidad;
import com.portfolio.PortfolioBackend.model.PersonaHabilidadID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface PersonaHabilidadRepository extends JpaRepository<PersonaHabilidad, PersonaHabilidadID> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM persona_habilidad "
                 + "WHERE persona_habilidad.id_persona = (?1)")
    public List<PersonaHabilidad> traerPersonaHabilidadesQuery(int idPersona);
    
}
