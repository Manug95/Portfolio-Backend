
package com.portfolio.PortfolioBackend.repository;

import com.portfolio.PortfolioBackend.model.Usuario;
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
    
//    @Modifying//(flushAutomatically = true, clearAutomatically = true)
//    @Query(nativeQuery = true,
//           value = "UPDATE usuarios "
//                 + "SET nombre_usuario = :nombreUsuario, contrasenia = :contrasenia, id_persona = :idPersona "
//                 + "WHERE id_usuario = :idUsuario"
//    )
//    public void agregarFKPersona(@Param("idUsuario") int idUsuario, 
//                                 @Param("nombreUsuario") String nombreUsuario,
//                                 @Param("contrasenia") String contrasenia,
//                                 @Param("idPersona") int idPersona
//    );
    
//    @Modifying
//    @Query(nativeQuery = true,
//           value = "UPDATE usuarios "
//                 + "SET nombre_usuario = (?2), contrasenia = (?3), id_persona = (?4) "
//                 + "WHERE id_usuario = (?1)"
//    )
//    public void agregarFKPersona(int idUsuario, 
//                                 String nombreUsuario,
//                                 String contrasenia,
//                                 int idPersona
//    );
    
}
