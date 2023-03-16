
package com.portfolio.PortfolioBackend.security.control;

import com.portfolio.PortfolioBackend.dto.DatosLogin;
import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.security.jwt.JwtToken;
import com.portfolio.PortfolioBackend.security.dto.Login;
import com.portfolio.PortfolioBackend.security.jwt.JwtProvider;
import com.portfolio.PortfolioBackend.security.service.RolService;
import com.portfolio.PortfolioBackend.service.IUsuarioService;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/auth")
public class AutenticacionController {

    @Autowired
    private IUsuarioService userServ;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private RolService rolServ;
    
    @Autowired
    private JwtProvider jwtProvider;
    
    
    /**
     * Crea un nuevo usuario y una nueva persona con todos sus datos en null
     * 
     * @param usuario son los datos del usuario y la persona
     * @return un objeto con los datos del usuario creado (idUsuario, nombreUsuario, idPersona), o si no, null
     * 
     * NOTA:
     * Como un usuario es una persona y viceversa, idUsuario = idPersona, por lo que no seria necesario devolver la idPersona.
     * por el momento lo dejo asi, devolviendo la idPersona...
     */
    @PostMapping("/crear")
    public @ResponseBody ResponseEntity<DatosLogin> crearUsuario(@RequestBody UsuarioDTO usuario) {
        
        if (usuario.getNombreUsuario().isEmpty() || usuario.getContrasenia().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
//        if (this.userServ.existeNombreUsuario(usuario.getNombreUsuario())) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
        
        try {
            Set roles = new HashSet<>();
            roles.add(this.rolServ.traerPorRolNombre("ROLE_USER"));
            usuario.setRoles(roles);
            
            DatosLogin datos = this.userServ.crearUsuario(usuario);
            
            if (datos != null) {
                return new ResponseEntity<>(datos, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(datos, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al crear Usuario en UsuarioController");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
    
    
    @PostMapping("/login")
    public @ResponseBody ResponseEntity<DatosLogin> login(@RequestBody Login usuarioLogin, BindingResult bindingResult) {
        
        if (usuarioLogin.getNombreUsuario().isEmpty() || usuarioLogin.getContrasenia().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
        try {
            
//            Authentication authentication = this.authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(usuarioLogin.getNombreUsuario(), usuarioLogin.getContrasenia()));
//            //if(authentication.isAuthenticated()) System.out.println("autenticado"); else System.out.println("no autenticado");
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            
//            String token = this.jwtProvider.generateToken(authentication);
            
            //UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            
            UsuarioDTO user = this.userServ.autenticarUsuario(usuarioLogin.getNombreUsuario(), usuarioLogin.getContrasenia());
        
            if (user != null) {
                JwtToken jwt = new JwtToken();
            
                String token = jwt.getJWTToken(usuarioLogin.getNombreUsuario());

                DatosLogin datos = new DatosLogin(user.getIdUsuario(), user.getNombreUsuario(), user.getIdPersona(), token);

                return new ResponseEntity<>(datos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error en el login en AuthenticationController");
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        
    }
    
}
