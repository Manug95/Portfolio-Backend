
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.TipoHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface TipoHabilidadRepository extends JpaRepository<TipoHabilidad, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM tipo_habilidad "
                 + "WHERE tipo_habilidad.nombre_tipo_habilidad = (?1)")
    public TipoHabilidad buscarHabilidad(String nombreTipoHab);
    
}
