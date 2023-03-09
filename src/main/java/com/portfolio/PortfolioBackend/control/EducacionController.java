
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.IEducacionService;
import com.portfolio.PortfolioBackend.service.IPersonaEducacionService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
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
    public void guardarEducacion(@RequestBody EducacionDTO eduDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            
            Educacion educacion = this.eduServ.guardarEducacion(eduDTO, persona);
            
            this.persoEduServ.guardarPersonaEducacion(persona, educacion, eduDTO.getFechaInicio(), eduDTO.getFechaFin());
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la Educacion Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------");
        }
        
    }
    
    @GetMapping("/traer")
    public ResponseEntity<List<EducacionDTO>> traerEducaciones(@RequestParam("idPersona") int idPersona) {
        
        List<EducacionDTO> lista;
        
        try {
            lista = this.eduServ.traerListaDeEducacionesDeUnaPersona(idPersona);
            
            return new ResponseEntity(lista, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer las Educaciones Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------------");
            
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/editar")
    public void editarEducacionDePersona(@RequestBody EducacionDTO eduDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            Educacion educacion = this.eduServ.transformarAEducacion(eduDTO);
            
            this.persoEduServ.editarPersonaEducacion(educacion, persona, eduDTO.getFechaInicio(), eduDTO.getFechaFin());
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar la Educacion Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------");
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarEducacionDePersona(@RequestParam("idEducacion") int idEducacion, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            Educacion educacion = this.eduServ.traerEducacion(idEducacion);
            
            this.persoEduServ.eliminarEducacionDePersona(educacion, persona);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar la Educacion de Persona Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
        
    }
    
}
