
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.security.dto.Login;
import com.portfolio.PortfolioBackend.service.DomicilioService;
import com.portfolio.PortfolioBackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService persoServ;
    
    @Autowired
    private DomicilioService domiServ;
    
    @GetMapping("/traer")
    public @ResponseBody ResponseEntity<PersonaDTO> traerPersona(@RequestParam int id, @RequestHeader("authorization") String token) {
        
        PersonaDTO personaRespuesta = this.persoServ.traerPersonaDTO(id);
            
        if (personaRespuesta != null) {
            return new ResponseEntity<>(personaRespuesta, HttpStatus.OK);
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
    
    @GetMapping("/domicilios/traer")
    public @ResponseBody ResponseEntity<String> traerDomicilio(@RequestBody DomicilioDTO domicilio) {
        
        Integer id = this.domiServ.buscarDomicilio(domicilio);
        
        if (id != null) {
            return new ResponseEntity<>("Domicilio encontrado - " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se pudo encontrar el domicilio - " + id, HttpStatus.BAD_REQUEST);
        }
        
    }
    
//    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/editar")
    public ResponseEntity<?> editarPersona(@RequestBody PersonaDTO personaDTO) {
        
        if (personaDTO != null) {
            this.persoServ.editarPersona(personaDTO);
            
            return new ResponseEntity("{}", HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
