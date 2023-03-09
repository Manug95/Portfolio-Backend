
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM proyectos "
                 + "WHERE proyectos.nombre = (?1) AND proyectos.url_repo = (?2)")
    public Proyecto buscarProyectoPorNombreYUrlQuery(String nombreProyecto, String url);
    
}
