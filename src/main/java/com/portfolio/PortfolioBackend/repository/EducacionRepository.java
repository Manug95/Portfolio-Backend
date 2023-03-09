
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM educacion "
                 + "WHERE educacion.nombre_institucion = (?1) AND educacion.titulo_estudios = (?2)")
    public Educacion buscarEducacionPorNombreYTituloQuery(String nombreInstitucion, String titulo);
    
}
