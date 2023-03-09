
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaEducacion;
import com.portfolio.PortfolioBackend.model.PersonaEducacionID;
import com.portfolio.PortfolioBackend.repository.PersonaEducacionRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class PersonaEducacionService implements IPersonaEducacionService {

    @Autowired
    private PersonaEducacionRepository persoEduRepo;

    @Override
    public void guardarPersonaEducacion(Persona p, Educacion edu, LocalDate fechaIni, LocalDate fechaFin) {
        
        PersonaEducacion persoEdu;
        
        try {
            
            persoEdu = new PersonaEducacion(p, edu, fechaIni, fechaFin);
            
            this.savePersonaEducacion(persoEdu);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la PersonaEducacion Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------");
        }
        
    }

    @Override
    public List<PersonaEducacion> traerListaDeEducacionesDeUnaPersona(int idPersona) {
        
        List<PersonaEducacion> listaEducaciones;
        
        try {
            listaEducaciones = this.persoEduRepo.traerPersonaEducacionQuery(idPersona);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la lista Educaciones Query---------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------");
            listaEducaciones = null;
        }
        
        return listaEducaciones;
        
    }

    @Override
    public void editarPersonaEducacion(Educacion edu, Persona p, LocalDate fechaIni, LocalDate fechaFin) {
        
        try {
            PersonaEducacion persoEdu = new PersonaEducacion(p, edu, fechaIni, fechaFin);
            
            this.savePersonaEducacion(persoEdu);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar PersonaEducacion---------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void eliminarEducacionDePersona(Educacion edu, Persona perso) {
        
        PersonaEducacionID id = new PersonaEducacionID(edu, perso);
        
        try {
            this.persoEduRepo.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar la Educacion de Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------------");
        }
        
    }
    
    private PersonaEducacion savePersonaEducacion(PersonaEducacion pe) {
        
        PersonaEducacion persoEdu = null;
        
        try {
            persoEdu = this.persoEduRepo.save(pe);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la PersonaEducacion Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------");
        }
        
        return persoEdu;
    }
    
}
