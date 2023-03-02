
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Telefono;
import com.portfolio.PortfolioBackend.model.TelefonoID;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
@Transactional //esta annotation es para poder hacer las query con UPDATE y DELETE
public interface TelefonoRepository extends JpaRepository<Telefono, TelefonoID> {
    
    @Modifying
    @Query(nativeQuery = true,
           value = "UPDATE telefonos "
                 + "SET telefonos.telefono = (?1) "
                 + "WHERE telefonos.telefono = (?2) AND telefonos.id_persona = (?3);")
    public  void editarTelefonoQuery(long telNuevo, long telViejo, int idPersona);
    
}
