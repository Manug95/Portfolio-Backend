
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.TipoEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface TipoEmpleoRepository extends JpaRepository<TipoEmpleo, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT id_tipo_empleo, tipo "
                 + "FROM tipo_empleo "
                 + "WHERE tipo_empleo.tipo = (?1)")
    public TipoEmpleo traerTipoEmpleoQuery(String nombreTipo);
    
}
