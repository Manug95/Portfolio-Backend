
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.model.Persona;
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
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean crearPersona(PersonaDTO persona) {
        
        if(persona != null) {
            Persona p = new Persona(
                //persona.getIdPersona(),
                persona.getNombre(),
                persona.getApellido(),
                persona.getFechaNacimiento()
            );
        
            this.persoRepo.save(p);
            
            return true;
        } else {
            return false;
        }
        
    }

    @Override
    public PersonaDTO traerPersona(int id) {
        
        Persona p = this.persoRepo.findById(id).orElse(null);
        
        if(p != null) {
            
//            String nombre = p.getNombre();
//            String apellido = p.getApellido();
//            LocalDate fechaNac = p.getFechaNacimiento();
//            Integer idDomicilio = p.getDomicilio().getIdDomicilio();
            
            PersonaDTO persoRespuesta = new PersonaDTO(
                p.getIdPersona(),
                p.getNombre(),
                p.getApellido(),
                p.getFechaNacimiento(),
                p.getDomicilio().getIdDomicilio()
            );
        
            return persoRespuesta;
        }else {
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

    @Override
    public void eliminarPersona(int id) {
        
        this.persoRepo.deleteById(id);
        
    }

}