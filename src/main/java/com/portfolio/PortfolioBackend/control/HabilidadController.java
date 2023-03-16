
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.HabilidadService;
import com.portfolio.PortfolioBackend.service.IHabilidadService;
import com.portfolio.PortfolioBackend.service.IPersonaHabilidadService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import com.portfolio.PortfolioBackend.service.PersonaHabilidadService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/habilidades")
public class HabilidadController {
    
    @Autowired
    private HabilidadService habServ;
    
    @Autowired
    private PersonaService persoServ;
    
    @Autowired
    private PersonaHabilidadService persoHabServ;
    
    @PostMapping("/guardar")
    public void guardarHabilidad(@RequestBody HabilidadDTO habDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            
            Habilidad habilidad = this.habServ.guardarHabilidad(habDTO, persona);
            
            this.persoHabServ.guardarPersonaHabilidad(persona, habilidad, habDTO.getProgreso());
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Habilidad Controller");
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
            Mensaje.mensajeCatch(e, "Error al traer las Habilidades Controller");
            
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
            Mensaje.mensajeCatch(e, "Error al editar la Habilidad Controller");
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
            Mensaje.mensajeCatch(e, "Error al eliminar la Habilidad de Persona Controller");
        }
        
    }

}
