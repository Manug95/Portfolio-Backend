
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.model.Experiencia;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.ExperienciaService;
import com.portfolio.PortfolioBackend.service.IExperienciaService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import com.portfolio.PortfolioBackend.service.PersonaService;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService expServ;
    
    @Autowired
    private PersonaService persoServ;
    
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarExperiencia(@RequestBody ExperienciaDTO expDTO) {
        
        Experiencia exp;
        
        try {
            Persona p = this.persoServ.traerPersona(expDTO.getIdPersona());
            
            exp = this.expServ.guardarExperiencia(expDTO, p);
            
            return new ResponseEntity(exp.getIdExperiencia(), HttpStatus.CREATED);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la experiencia en ExperienciaController");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping("/traer")
    public @ResponseBody ResponseEntity<List<ExperienciaDTO>> traerExperiencias(@RequestParam("idPersona") int idPersona) {
        
        List<ExperienciaDTO> listaExperiencias = null;
        
        try {
            listaExperiencias = this.expServ.traerExperienciasPersona(idPersona);
            
            return new ResponseEntity<>(listaExperiencias, HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer las experiencias en ExperienciaController");
            return new ResponseEntity<>(listaExperiencias, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/editar")
    public ResponseEntity<?> editarExperiencia(@RequestBody ExperienciaDTO expDTO) {
        
        Experiencia exp;
        
        try {
            Persona p = this.persoServ.traerPersona(expDTO.getIdPersona());
            
            exp = this.expServ.editarExperiencia(expDTO, p);
            
            return new ResponseEntity(exp.getIdExperiencia(), HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al editar la experiencia en ExperienciaController");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarExperiencia(@RequestParam("idExp") int idExp) {
        
        try{
            this.expServ.eliminarExperiencia(idExp);
            
            return new ResponseEntity(1, HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al eliminar la experiencia en ExperienciaController");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
