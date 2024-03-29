
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.ProyectoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaProyecto;
import com.portfolio.PortfolioBackend.model.Proyecto;
import com.portfolio.PortfolioBackend.service.IPersonaProyectoService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import com.portfolio.PortfolioBackend.service.IProyectoService;
import com.portfolio.PortfolioBackend.service.PersonaProyectoService;
import com.portfolio.PortfolioBackend.service.PersonaService;
import com.portfolio.PortfolioBackend.service.ProyectoService;
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
@RequestMapping(path = "/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyServ;
    
    @Autowired
    private PersonaService persoServ;
    
    @Autowired
    private PersonaProyectoService persoProyServ;
    
    @PostMapping("/guardar")
    public ResponseEntity<Integer> guardarProyecto(@RequestBody ProyectoDTO proyDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            
            Proyecto proyecto = this.proyServ.guardarProyecto(proyDTO, persona);
            
            //si proyecto es null no se pudo guardar
            if (proyecto == null) {
                return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
            }
            
            PersonaProyecto persoProy = this.persoProyServ.guardarPersonaProyecto(persona, proyecto, proyDTO.getFechaInicio(), proyDTO.getFechaFin());
            
            if (persoProy == null) {
                return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
            }
            
            return new ResponseEntity(proyecto.getIdProyecto(), HttpStatus.CREATED);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Proyecto Controller");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping("/traer")
    public ResponseEntity<List<ProyectoDTO>> traerProyectos(@RequestParam("idPersona") int idPersona) {
        
        List<ProyectoDTO> lista;
        
        try {
            lista = this.proyServ.traerListaDeProyectosDeUnaPersona(idPersona);
            
            return new ResponseEntity(lista, HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer las Proyectos Controller");
            
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/editar")
    public ResponseEntity<Integer> editarProyectoDePersona(@RequestBody ProyectoDTO proyDTO, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
//            Proyecto proyecto = this.proyServ.transformarAProyecto(proyDTO);
            
            Proyecto proyecto = this.proyServ.editarProyecto(proyDTO);
            
            if (proyecto == null) {
                return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
            }
            
            PersonaProyecto persoProy = this.persoProyServ.editarPersonaProyecto(proyecto, persona, proyDTO.getFechaInicio(), proyDTO.getFechaFin());
            
            if (persoProy == null) {
                return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
            }
            
            return new ResponseEntity(1, HttpStatus.OK);
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al editar la Proyecto Controller");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Integer> eliminarProyectoDePersona(@RequestParam("idProyecto") int idProyecto, @RequestParam("idPersona") int idPersona) {
        
        try {
            Persona persona = this.persoServ.traerPersona(idPersona);
            Proyecto proyecto = this.proyServ.traerProyecto(idProyecto);
            
            this.persoProyServ.eliminarProyectoDePersona(proyecto, persona);
            
            return new ResponseEntity(1, HttpStatus.OK);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al eliminar la Proyecto de Persona Controller");
            return new ResponseEntity(-1, HttpStatus.BAD_REQUEST);
        }
        
    }
    
}
