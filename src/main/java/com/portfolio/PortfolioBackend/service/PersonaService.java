
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.dto.EmailDTO;
import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.dto.LocalidadDTO;
import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.dto.ProvinciaDTO;
import com.portfolio.PortfolioBackend.dto.ProyectoDTO;
import com.portfolio.PortfolioBackend.dto.TelefonoDTO;
import com.portfolio.PortfolioBackend.model.Domicilio;
import com.portfolio.PortfolioBackend.model.Email;
import com.portfolio.PortfolioBackend.model.Localidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Provincia;
import com.portfolio.PortfolioBackend.model.Telefono;
import com.portfolio.PortfolioBackend.repository.PersonaRepository;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private PersonaRepository persoRepo;
    
    @Autowired
    private ExperienciaService expServ;
    
    @Autowired
    private DomicilioService domiServ;
    
    @Autowired
    private EmailService emailServ;
    
    @Autowired
    private TelefonoService telServ;
    
    @Autowired
    private HabilidadService habServ;
    
    @Autowired
    private EducacionService eduServ;
    
    @Autowired
    private ProyectoService proyServ;
    
//    @Autowired
//    private IUsuarioService userServ;
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    /**
     * guarda los datos de la persona que se creo cuando se creo el usuario
     * @param persona datos de la persona nueva
     * @return la ID de la persona nueva
     */
    @Override
    public int inicializarPersona(PersonaDTO persona) {
        
        try {
            if(persona != null) {

                Persona p = this.transformarAPersona(persona);

                Persona personaGenerada = this.savePersona(p);
                
                if (!persona.getEmails().isEmpty()){
                    this.emailServ.guardarEmails(persona.getEmails(), personaGenerada);
                }
                
                if (!persona.getTelefonos().isEmpty()) {
                    this.telServ.guardarTelefonos(persona.getTelefonos(), personaGenerada);
                }

                return personaGenerada.getIdPersona();
            } else {
                return -1;
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Persona (clase PersonaService - metodo inicializarPersona)");
            return -1;
        }
        
    }

    /**
     * Trae una persona dada una ID y la transforma en PersonaDTO
     * @param id de la persona
     * @return la personaDTO si es encontrada, si no, null
     */
    @Override
    public PersonaDTO traerPersonaDTO(int id) {
        
        try {
            Persona p = this.traerPersona(id);
        
            if(p != null) {
                
                ArrayList<EmailDTO> emails = this.emailServ.transformarAListaEmailDTO(p.getEmails(), p.getIdPersona());
                
                ArrayList<TelefonoDTO> telefonos = this.telServ.transformarAListaTelefonoDTO(p.getTelefonos(), p.getIdPersona());
                
                PersonaDTO persona = this.transformarAPersonaDTO(p);
                persona.setEmails(emails);
                persona.setTelefonos(telefonos);
                
                ArrayList<ExperienciaDTO> experiencias = this.expServ.transformarAListaExperienciaDTO(p.getExperiencias());
                persona.setExperiencias(experiencias);
                
                ArrayList<HabilidadDTO> habilidades = (ArrayList<HabilidadDTO>) this.habServ.traerListaDeHabilidadesDeUnaPersona(p.getIdPersona());
                persona.setHabilidades(habilidades);
                
                ArrayList<EducacionDTO> educaciones = (ArrayList<EducacionDTO>) this.eduServ.traerListaDeEducacionesDeUnaPersona(p.getIdPersona());
                persona.setEducaciones(educaciones);
                
                ArrayList<ProyectoDTO> proyectos = (ArrayList<ProyectoDTO>) this.proyServ.traerListaDeProyectosDeUnaPersona(p.getIdPersona());
                persona.setProyectos(proyectos);

                return persona;
            }else {
                return null;
            }
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer PersonaDTO (clase PersonaService - metodo traerPersonaDTO)");
            return null;
        }
        
    }
    
    /**
     * Trae una persona dada una ID
     * @param id de la persona
     * @return la persona si es encontrada, si no, null
     */
    @Override
    public Persona traerPersona(int id) {
        
        Persona persona;
        
        try {
            persona = this.persoRepo.findById(id).orElse(null);
            
            return persona;
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al traer Peronsa (clase PersonaService - metodo traerPersona)");
            return null;
        }
        
    }

    @Override
    public void editarPersona(PersonaDTO personaDTO) {
        Persona persona;
        
        try {
            
            persona = this.transformarAPersona(personaDTO);
            
            this.savePersona(persona);
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error en metodo editarPersona - clase PersonaService");
        }
        
    }

    /**
     * borra una persona en la BD dada una ID
     * @param id de la persona a borrar
     */
    @Override
    public void eliminarPersona(int id) {
        
        try {
            this.persoRepo.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar la persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void cambiarDomicilio(DomicilioDTO domi, int idPersona) {
        
        Domicilio domicilio;
        
        try {
            domicilio = this.domiServ.guardarDomicilioPersona(domi);
            
            Persona persona = this.traerPersona(idPersona);
            
            persona.setDomicilio(domicilio);
            
            this.persoRepo.save(persona);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la cambiar domicilio (clase PersonaService - metodo cambiarDomicilio)");
        }
        
    }

    @Override
    public Persona transformarAPersona(PersonaDTO p) {
        
        Persona persona = null;
        
        if (p != null) {
            
            Domicilio domicilio = this.domiServ.guardarDomicilioPersona(p.getDomicilio());
            
            persona = new Persona(
                p.getIdPersona(),
                p.getNombre(),
                p.getApellido(),
                p.getFechaNacimiento(),
                p.getSobreMi(),
                domicilio
            );
        }
        
        return persona;
        
    }

    @Override
    public PersonaDTO transformarAPersonaDTO(Persona p) {
        
        PersonaDTO persona = null;
        
        if (p != null) {
            DomicilioDTO domicilio = this.domiServ.transformarADomicilioDTO(p.getDomicilio());
            
            persona = new PersonaDTO(
                p.getIdPersona(),
                p.getNombre(),
                p.getApellido(),
                p.getFechaNacimiento(),
                p.getSobreMi(),
                domicilio
            );
        }
        
        return persona;
        
    }
    
    private Persona savePersona(Persona p) {
        Persona persona;
        
        try {
            persona = this.persoRepo.save(p);
            return persona;
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error savePersona en la clase PersonaService");
            return null;
        }
        
    }
    
}
