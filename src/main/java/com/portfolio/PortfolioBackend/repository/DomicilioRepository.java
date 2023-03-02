
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
    
    @Query(nativeQuery = true,
           value = "SELECT id_domicilio "
                 + "FROM ((domicilios "
                 + "INNER JOIN localidades ON domicilios.id_localidad = localidades.id_localidad) "
                 + "INNER JOIN provincias ON localidades.id_provincia = provincias.id_provincia) "
                 + "WHERE domicilios.calle = (?1) AND domicilios.altura = (?2) AND localidades.nombre = (?3) AND provincias.nombre = (?4)"
    )
    public Integer buscarDomicilioQuery(String calle, int altura, String localidad, String provincia);
    
//    @Query(nativeQuery = true,
//           value = "SELECT id_domicilio "
//                 + "FROM ((domicilios "
//                 + "INNER JOIN localidades ON domicilios.id_localidad = localidades.id_localidad) "
//                 + "INNER JOIN provincias ON localidades.id_provincia = provincias.id_provincia) "
//                 + "WHERE domicilios.calle = :calle AND domicilios.altura = :altura AND localidades.nombre = :localidad AND provincias.nombre = :provincia"
//    )
//    public int buscarDomicilio(@Param("calle")String calle, @Param("altura") int altura, @Param("localidad") String localidad, @Param("provincia") String provincia);
    
}
