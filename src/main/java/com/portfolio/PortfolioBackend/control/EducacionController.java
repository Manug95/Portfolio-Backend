
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.IEducacionService;
import com.portfolio.PortfolioBackend.service.IPersonaEducacionService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/educacion")
public class EducacionController {

    @Autowired
    private IEducacionService eduServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @Autowired
    private IPersonaEducacionService persoEduServ;
    
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarEducacion(@RequestBody EducacionDTO eduDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            
            Educacion educacion = this.eduServ.guardarEducacion(eduDTO, persona);
            
            this.persoEduServ.guardarPersonaEducacion(persona, educacion, eduDTO.getFechaInicio(), eduDTO.getFechaFin());
            
            return new ResponseEntity(educacion.getIdEducacion(), HttpStatus.CREATED);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Educacion Controller");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping("/traer")
    //public ResponseEntity<List<EducacionDTO>> traerEducaciones(@RequestParam("idPersona") int idPersona) {
    public ResponseEntity<?> traerEducaciones(@RequestParam("idPersona") int idPersona) {
        
        List<EducacionDTO> lista = null;
        
        try {
            lista = this.eduServ.traerListaDeEducacionesDeUnaPersona(idPersona);
            
            if ( lista != null) {
                return new ResponseEntity(lista, HttpStatus.OK);
            } else {
                return new ResponseEntity("Usuarion sin Educación", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer las Educaciones Controller");
            
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/editar")
    public ResponseEntity<?> editarEducacionDePersona(@RequestBody EducacionDTO eduDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            
            Educacion edu = this.eduServ.editarEducacion(eduDTO, persona);
            
            this.persoEduServ.editarPersonaEducacion(edu, persona, eduDTO.getFechaInicio(), eduDTO.getFechaFin());
            
            //si la educacion editada tiene una id diferente de la educacion que se quiso editar
            //quiere decir que se creo una nueva xq en el frontend se modificaron el nombreInstitucion y tituloDeEstudios
            if (edu.getIdEducacion() != eduDTO.getIdEducacion()) {
                Educacion educacion = this.eduServ.transformarAEducacion(eduDTO);
                
                //en este caso de elimina la educacion anterior xq ya no esta mas relacionada con la persona
                this.persoEduServ.eliminarEducacionDePersona(educacion, persona);
            }
            
            return new ResponseEntity(edu.getIdEducacion(), HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al editar la Educacion Controller");
            
            return new ResponseEntity(-1, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarEducacionDePersona(@RequestParam("idEducacion") int idEducacion, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            Educacion educacion = this.eduServ.traerEducacion(idEducacion);
            
            this.persoEduServ.eliminarEducacionDePersona(educacion, persona);
            
            return new ResponseEntity(1, HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al eliminar la Educacion de Persona Controller");
            return new ResponseEntity(-1, HttpStatus.NOT_FOUND);
        }
        
    }
    
}
