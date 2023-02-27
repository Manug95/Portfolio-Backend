
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
    
//    @Autowired
//    private IUsuarioService userServ;
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    /**
     * crea una nueva persona y la guarda en la BD
     * @param persona datos de la persona nueva
     * @return la ID de la persona nueva
     */
    @Override
    public int crearPersona(int idUsuario, PersonaDTO persona) {  //POR EL MOMENTO ESTE METODO NO SE VA A USAR
        
        try {
            if(persona != null) {
                Persona p = new Persona(
                    //persona.getIdPersona(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getFechaNacimiento()
                );

                Persona personaGenerada = this.persoRepo.save(p);
                
                //this.userServ.enlazarPersona(idUsuario, personaGenerada.getIdPersona());

                return personaGenerada.getIdPersona();
            } else {
                return -1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
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
