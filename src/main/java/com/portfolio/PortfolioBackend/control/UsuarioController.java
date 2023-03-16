
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.DatosLogin;
import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.model.Usuario;
import com.portfolio.PortfolioBackend.security.jwt.JwtToken;
import com.portfolio.PortfolioBackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService userServ;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    
//    @PostMapping("/crear")
//    public @ResponseBody ResponseEntity<DatosLogin> crearUsuario(@RequestBody UsuarioDTO usuario) {
//        
//        try {
//            DatosLogin datos = this.userServ.crearUsuario(usuario);
//            
//            if (datos != null) {
//                return new ResponseEntity<>(datos, HttpStatus.CREATED);
//            } else {
//                return new ResponseEntity<>(datos, HttpStatus.BAD_REQUEST);
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//
//    }

//    @PostMapping("/login")
//    public @ResponseBody ResponseEntity<DatosLogin> login(@RequestBody UsuarioDTO login) {
//        
//        UsuarioDTO user = this.userServ.autenticarUsuario(login.getNombreUsuario(), login.getContrasenia());
//        
//        if (user != null) {
//            JwtToken jwt = new JwtToken();
//            
//            String token = jwt.getJWTToken(login.getNombreUsuario());
//            
//            DatosLogin datos = new DatosLogin(user.getIdUsuario(), user.getNombreUsuario(), user.getIdPersona(), token);
//
//            return new ResponseEntity<>(datos, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
//        }
//        
//    }
    
//    @GetMapping("/traer")
//    public UsuarioDTO traer(@RequestParam("id") int id) {
//        
//        return this.userServ.traerUsuarioDTO(id);
//    }
    
}
