

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.DatosLogin;
import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Usuario;
import com.portfolio.PortfolioBackend.repository.UsuarioRepository;
import com.portfolio.PortfolioBackend.security.model.Rol;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import jakarta.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository userRepo;
    
    /**
     * @param usuario
     * @return los datos del suario creado, no la persona
     * @throws Exception 
     */
    @Override
    public DatosLogin crearUsuario(UsuarioDTO usuario) throws Exception {
        
        try {
            Usuario u = this.userRepo.existeUsuario(usuario.getNombreUsuario());
        
            if(u != null) {
                return null;
            }

            Set<Rol> roles = new HashSet<>();

            usuario.getRoles().forEach((r) -> roles.add(new Rol(r)));

            Usuario nuevoUser = new Usuario(
                    usuario.getNombreUsuario(),
                    usuario.getContrasenia(),
                    roles,
                    new Persona()
            );

            nuevoUser = this.saveUsuario(nuevoUser);

            DatosLogin datos = new DatosLogin(
                    nuevoUser.getIdUsuario(),
                    nuevoUser.getNombreUsuario(),
                    nuevoUser.getPersonaUser().getIdPersona()
            );

            return datos;
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al crear usuario");
            return null;
        }
        
    }
    
    private Usuario saveUsuario(Usuario usuario) {
        
        try {
            return this.userRepo.save(usuario);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar Usuario");
            return null;
        }
        
    }

    @Override
    public UsuarioDTO autenticarUsuario(String nombreUsuario, String contrasenia) {
        
        try {
            Usuario u = this.userRepo.buscarUsuario(nombreUsuario, contrasenia);
        
            if (u != null) {
                Set<String> roles = new HashSet<>();
                
                u.getRoles().forEach((r) -> roles.add(r.getRolNombre()));
                
                UsuarioDTO usuario = new UsuarioDTO(
                        u.getIdUsuario(),
                        u.getNombreUsuario(),
                        u.getContrasena(),
                        u.getPersonaUser().getIdPersona(),
                        roles
                );

                return usuario;
            } else {
                return null;
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al Autenticar Usuario");
            return null;
        }
        
    }

    @Override
    public UsuarioDTO traerUsuarioDTO(int id) {
        try {
            Usuario usuario = this.traerUsuario(id);
            
            Set<String> roles = new HashSet<>();
                
            usuario.getRoles().forEach((r) -> roles.add(r.getRolNombre()));
        
            if(usuario != null) {
                UsuarioDTO userRespuesta = new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getNombreUsuario(),
                    usuario.getContrasena(),
                    usuario.getPersonaUser().getIdPersona(),
                    roles
                );

                return userRespuesta;
            }else {
                return null;
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer UsuarioDTO");
            return null;
        }
    }

    @Override
    public Usuario traerUsuario(int id) {
        try {
            Usuario usuario = this.userRepo.findById(id).orElse(null);
        
            return usuario;
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer Usuario");
            return null;
        }
    }

    @Override
    public Usuario traerPorNombreUsuario(String nombreUsuario) {
        
        try {
            //return this.userRepo.findByNombreUsuario(nombreUsuario).orElse(null);
            return this.userRepo.existeUsuario(nombreUsuario);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer Usuario por nombre");
            return null;
        }
        
    }

    @Override
    public boolean existeNombreUsuario(String nombreUsuario) {
        return this.userRepo.existsByNombreUsuario(nombreUsuario);
    }

}
