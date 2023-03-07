
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.IExperienciaService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@RestController
@RequestMapping(path = "/experiencias")
public class ExperienciaController {

    @Autowired
    private IExperienciaService expServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping("/guardar")
    public void guardarExperiencia(@RequestBody ExperienciaDTO expDTO) {
        
        try {
            Persona p = this.persoServ.traerPersona(expDTO.getIdPersona());
            
            this.expServ.guardarExperiencia(expDTO, p);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la experiencia en ExperienciaController------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------------------");
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
            System.out.println("----------------------Error al traer las experiencias en ExperienciaController------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------------------");
            return new ResponseEntity<>(listaExperiencias, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/editar")
    public void editarExperiencia(@RequestBody ExperienciaDTO expDTO) {
        
        try {
            Persona p = this.persoServ.traerPersona(expDTO.getIdPersona());
            
            this.expServ.editarExperiencia(expDTO, p);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar la experiencia en ExperienciaController-------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------------------");
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarExperiencia(@RequestParam("idExp") int idExp) {
        
        try{
            this.expServ.eliminarExperiencia(idExp);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar la experiencia en ExperienciaController------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------------------------");
        }
        
    }
    
}
