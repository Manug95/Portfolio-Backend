

package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.DatosLogin;
import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.model.Usuario;
import com.portfolio.PortfolioBackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService userServ;
    
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
        
        try {
            DatosLogin datos = this.userServ.crearUsuario(usuario);
            
            if (datos != null) {
                return new ResponseEntity<>(datos, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(datos, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
    
    @PostMapping("/login")
    public @ResponseBody ResponseEntity<UsuarioDTO> login(
                @RequestParam("usuario") String usuario,
                @RequestParam("contrasenia") String contrasenia
            ) 
    {
        UsuarioDTO user = this.userServ.autenticarUsuario(usuario, contrasenia);
        
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
        }
    }
    
}
