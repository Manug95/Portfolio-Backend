
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel
 */
@RestController
@RequestMapping(path = "/personas")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/traer")
    public @ResponseBody ResponseEntity<PersonaDTO> traerPersona(@RequestParam int id) {
        
        PersonaDTO personaRespuesta = this.persoServ.traerPersona(id);
        
        if (personaRespuesta != null) {
            return new ResponseEntity<>(personaRespuesta, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    /**
     * 
     * @param persona
     * @return 
     */
    @PutMapping("/crear")
    public @ResponseBody ResponseEntity<String> inicializarPersona(@RequestBody PersonaDTO persona/*, @RequestParam int idUsuario*/) {
        
        int id = this.persoServ.inicializarPersona(/*idUsuario, */persona);
        
        if (id != -1) {
            return new ResponseEntity<>("Persona guardada - " + id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("No se pudo guardar la persona - " + id, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarPersona(@RequestParam int id) {
        this.persoServ.eliminarPersona(id);
    }
    
}
