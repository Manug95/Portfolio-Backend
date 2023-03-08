
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.HabilidadService;
import com.portfolio.PortfolioBackend.service.IHabilidadService;
import com.portfolio.PortfolioBackend.service.IPersonaHabilidadService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import java.net.http.HttpResponse;
import java.util.ArrayList;
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
@RequestMapping(path = "/habilidades")
public class HabilidadController {
    
    @Autowired
    private HabilidadService habServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @Autowired
    private IPersonaHabilidadService persoHabServ;
    
    @PostMapping("/guardar")
    public void guardarHabilidad(@RequestBody HabilidadDTO habDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            
            Habilidad habilidad = this.habServ.guardarHabilidad(habDTO, persona);
            
            this.persoHabServ.guardarPersonaHabilidad(persona, habilidad, habDTO.getProgreso());
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la Habilidad Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------");
        }
        
    }
    
    @GetMapping("/traer")
    public ResponseEntity<List<HabilidadDTO>> traerHabilidades(@RequestParam("idPersona") int idPersona) {
        
        List<HabilidadDTO> lista;
        
        try {
            lista = this.habServ.traerListaDeHabilidadesDeUnaPersona(idPersona);
            
            return new ResponseEntity(lista, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer las Habilidades Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------------");
            
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/editar")
    public void editarHabilidadDePersona(@RequestBody HabilidadDTO habDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            Habilidad habilidad = this.habServ.transformarAHabilidad(habDTO);
            
            this.persoHabServ.editarProgresoDeHabilidad(habilidad, persona, habDTO.getProgreso());
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar la Habilidad Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------");
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarHabilidadDePersona(@RequestParam("idHabilidad") int idHabilidad, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            Habilidad habilidad = this.habServ.traerHabilidad(idHabilidad);
            
            this.persoHabServ.eliminarHabilidadDePersona(habilidad, persona);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar la Habilidad de Persona Controller------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
        
    }

}
