
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM experiencias "
                 + "WHERE experiencias.id_persona = (?1)")
    public List<Experiencia> traerExperienciasPersonaQuery(int idPersona);
    
}
