

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.dto.UsuarioPersonaDTO;
import com.portfolio.PortfolioBackend.model.Domicilio;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Usuario;
import com.portfolio.PortfolioBackend.repository.UsuarioRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository userRepo;
    
//    @Autowired
//    private IPersonaService persoServ;
    
    @Override
    public int crearUsuario(UsuarioPersonaDTO usuario) throws Exception {
        
        Usuario u = this.userRepo.existeUsuario(usuario.getNombreUsuario());
        
        if(u != null) {
            return -1;
        }
        
        Persona persona = new Persona(
                usuario.getPersona().getNombre(),
                usuario.getPersona().getApellido(),
                usuario.getPersona().getFechaNacimiento()
        );
        
        if (usuario.getPersona().getIdDomicilio() != null) {  //usuario.getPersona().getDomicilio() != null
            persona.setDomicilio(new Domicilio());
//            persona.setDomicilio(usuario.getPersona().getDomicilio());
        }

        Usuario nuevoUser = new Usuario(
                usuario.getNombreUsuario(),
                usuario.getContrasenia(),
                persona
        );

        nuevoUser = this.userRepo.save(nuevoUser);

        return nuevoUser.getIdUsuario();
        
    }

    @Override
    public UsuarioDTO autenticarUsuario(String nombreUsuario, String contrasenia) {
        
        try {
            Usuario u = this.userRepo.buscarUsuario(nombreUsuario, contrasenia);
        
            if (u != null) {
                UsuarioDTO usuario = new UsuarioDTO(
                        u.getIdUsuario(),
                        u.getNombreUsuario(),
                        u.getContrasena()
                );

                return usuario;
            } else {
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public UsuarioDTO traerUsuarioDTO(int id) {
        try {
            Usuario usuario = this.traerUsuario(id);
        
            if(usuario != null) {
                UsuarioDTO userRespuesta = new UsuarioDTO(
                    usuario.getIdUsuario(),
                        usuario.getNombreUsuario(),
                        usuario.getContrasena(),
                        usuario.getPersonaUser().getIdPersona()
                );

                return userRespuesta;
            }else {
                return null;
            }
        }
        catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
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
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

}
