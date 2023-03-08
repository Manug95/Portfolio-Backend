

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaHabilidad;
import com.portfolio.PortfolioBackend.model.PersonaHabilidadID;
import com.portfolio.PortfolioBackend.repository.PersonaHabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class PersonaHabilidadService implements IPersonaHabilidadService {
    
    @Autowired
    private PersonaHabilidadRepository persoHabRepo;

    @Override
    public void guardarPersonaHabilidad(Persona p, Habilidad h, short progreso) {
        
        //PersonaHabilidadID persoHabID;
        PersonaHabilidad persoHab;
        
        try {
            //persoHabID = new PersonaHabilidadID(p, h);
            
            persoHab = new PersonaHabilidad(p, h, progreso);
            
            this.savePersonaHabilidad(persoHab);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la PersonaHabilidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------------");
            persoHab = null;
        }
        
        //return persoHab;
        
    }

    private PersonaHabilidad savePersonaHabilidad(PersonaHabilidad ph) {
        
        PersonaHabilidad persoHab = null;
        
        try {
            this.persoHabRepo.save(ph);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la PersonaHabilidad Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------");
        }
        
        return persoHab;
    }

    @Override
    public List<PersonaHabilidad> traerListaDeHabilidadesDeUnaPersona(int idPersona) {
        
        List<PersonaHabilidad> listaHabilidades;
        
        try {
            listaHabilidades = this.persoHabRepo.traerPersonaHabilidadesQuery(idPersona);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la lista Habilidades Query---------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------");
            listaHabilidades = null;
        }
        
        return listaHabilidades;
    }

    @Override
    public void editarProgresoDeHabilidad(Habilidad hab, Persona perso, short progreso) {
        
        try {
            PersonaHabilidad persoHab = new PersonaHabilidad(perso, hab, progreso);
            
            this.savePersonaHabilidad(persoHab);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar el progreso de la Habilidad---------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void eliminarHabilidadDePersona(Habilidad hab, Persona perso) {
        
        PersonaHabilidadID id = new PersonaHabilidadID(perso, hab);
        
        try {
            this.persoHabRepo.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar la Habilidad de Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------------");
        }
        
    }
    
}
