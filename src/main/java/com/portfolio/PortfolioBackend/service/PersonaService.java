
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.dto.LocalidadDTO;
import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.dto.ProvinciaDTO;
import com.portfolio.PortfolioBackend.model.Domicilio;
import com.portfolio.PortfolioBackend.model.Localidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Provincia;
import com.portfolio.PortfolioBackend.repository.PersonaRepository;
import java.time.LocalDate;
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
    private LocalidadService localServ;
    
    @Autowired
    private DomicilioService domiServ;
    
//    @Autowired
//    private IUsuarioService userServ;
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    /**
     * guarda los datos de la persona que se creo cuando se creo el usuario
     * @param persona datos de la persona nueva
     * @return la ID de la persona nueva
     */
    @Override
    public int inicializarPersona(/*int idUsuario, */PersonaDTO persona) {
        
        try {
            if(persona != null) {
                
                Provincia provincia = new Provincia(
                        persona.getDomicilio().getLocalidad().getProvincia().getIdProvincia(),
                        persona.getDomicilio().getLocalidad().getProvincia().getNombre()
                );
                
                Localidad localidad = new Localidad(
                        persona.getDomicilio().getLocalidad().getNombre(),
                        provincia
                );
                
                this.localServ.guardarLocalidad(localidad);
                
                Domicilio domicilio = new Domicilio(
                        persona.getDomicilio().getCalle(),
                        persona.getDomicilio().getAltura(),
                        localidad
                );
                
                this.domiServ.guardarDomicilio(domicilio);
                
                Persona p = new Persona(
                    persona.getIdPersona(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getFechaNacimiento(),
                        domicilio
                );

                Persona personaGenerada = this.persoRepo.save(p);

                return personaGenerada.getIdPersona();
            } else {
                return -1;
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
            return -1;
        }
        
    }

    /**
     * Trae una persona dada una ID
     * @param id de la persona
     * @return la persona si es encontrada, si no, null
     */
    @Override
    public PersonaDTO traerPersona(int id) {
        
        try {
            Persona p = this.persoRepo.findById(id).orElse(null);
        
            if(p != null) {
                
                ProvinciaDTO provincia = new ProvinciaDTO(
                        p.getDomicilio().getLocalidad().getProvincia().getIdProvincia(),
                        p.getDomicilio().getLocalidad().getProvincia().getNombre()
                );
                
                LocalidadDTO localidad = new LocalidadDTO(
                        p.getDomicilio().getLocalidad().getIdLocalidad(),
                        p.getDomicilio().getLocalidad().getNombre(),
                        provincia
                );

                DomicilioDTO domicilio = new DomicilioDTO(
                        p.getDomicilio().getIdDomicilio(),
                        p.getDomicilio().getCalle(),
                        p.getDomicilio().getAltura(),
                        localidad
                );

                PersonaDTO persona = new PersonaDTO(
                    p.getIdPersona(),
                    p.getNombre(),
                    p.getApellido(),
                    p.getFechaNacimiento(),
                    domicilio
                );

                return persona;
            }else {
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public void editarPersona(PersonaDTO persona) {
        
//        if(persona != null) {
//            Persona p = new Persona(
//                //persona.getIdPersona(),
//                persona.getNombre(),
//                persona.getApellido(),
//                persona.getFechaNacimiento()
//            );
//        
//            this.persoRepo.save(p);
//            
//        }
        
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
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }

}
