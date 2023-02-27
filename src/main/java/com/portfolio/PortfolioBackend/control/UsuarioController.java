

package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.UsuarioDTO;
import com.portfolio.PortfolioBackend.dto.UsuarioPersonaDTO;
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
     * al crear el usuario se creara la persona, por lo que esta funcion debe recibir todos los datos
     * @param usuario son los datos del usuario y la persona
     * @return la ID del usuario creado o -1 si no se pudo crear
     */
    @PostMapping("/crear")
    public @ResponseBody ResponseEntity<Integer> crearUsuario(@RequestBody UsuarioPersonaDTO usuario) {
        
        try {
            int id = this.userServ.crearUsuario(usuario);
            
            if (id != -1) {
                return new ResponseEntity<>(id, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
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
