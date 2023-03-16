
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
//    @Query(nativeQuery = true,
//           value = "SELECT * "
//                 + "FROM usuarios "
//                 + "WHERE nombre_usuario = :nombreUsuario"
//    )
//    public boolean existeUsuario(@Param("nombreUsuario") String nombreUsuario);
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM usuarios "
                 + "WHERE nombre_usuario = (?1)"
    )
    public Usuario existeUsuario(String nombreUsuario);
    
    @Query(nativeQuery = true,
           value = "SELECT * "
                 + "FROM usuarios "
                 + "WHERE nombre_usuario = :nombreUsuario AND contrasenia = :contrasenia"
    )
    public Usuario buscarUsuario(@Param("nombreUsuario") String nombreUsuario, @Param("contrasenia") String contrasenia);
    
    public Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    public boolean existsByNombreUsuario(String nombreUsuario);
    
//    public boolean existsByEmail();
    
}
