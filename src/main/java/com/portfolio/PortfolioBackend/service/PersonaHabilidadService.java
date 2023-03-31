

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaHabilidad;
import com.portfolio.PortfolioBackend.model.PersonaHabilidadID;
import com.portfolio.PortfolioBackend.repository.PersonaHabilidadRepository;
import com.portfolio.PortfolioBackend.utils.Mensaje;
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
    public PersonaHabilidad guardarPersonaHabilidad(Persona p, Habilidad h, short progreso) {
        
        //PersonaHabilidadID persoHabID;
        PersonaHabilidad persoHab;
        
        try {
            //persoHabID = new PersonaHabilidadID(p, h);
            
            persoHab = new PersonaHabilidad(p, h, progreso);
            
            persoHab = this.savePersonaHabilidad(persoHab);
            
            return persoHab;
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la PersonaHabilidad en PersonaHabilidadService");
            return null;
        }
        
    }

    private PersonaHabilidad savePersonaHabilidad(PersonaHabilidad ph) {
        
        PersonaHabilidad persoHab = null;
        
        try {
            persoHab = this.persoHabRepo.save(ph);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la PersonaHabilidad Entidad en PersonaHabilidadService");
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
            Mensaje.mensajeCatch(e, "Error al traer la lista Habilidades Query en PersonaHabilidadService");
            listaHabilidades = null;
        }
        
        return listaHabilidades;
    }

    @Override
    public PersonaHabilidad editarProgresoDeHabilidad(Habilidad hab, Persona perso, short progreso) {
        
        try {
            PersonaHabilidad persoHab = new PersonaHabilidad(perso, hab, progreso);
            
            persoHab = this.savePersonaHabilidad(persoHab);
            
            return persoHab;
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al editar el progreso de la Habilidad en PersonaHabilidadService");
            return null;
        }
        
    }

    @Override
    public void eliminarHabilidadDePersona(Habilidad hab, Persona perso) {
        
        PersonaHabilidadID id = new PersonaHabilidadID(perso, hab);
        
        try {
            this.persoHabRepo.deleteById(id);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al eliminar la Habilidad de Persona en PersonaHabilidadService");
        }
        
    }
    
}
