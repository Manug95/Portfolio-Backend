
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaProyecto;
import com.portfolio.PortfolioBackend.model.PersonaProyectoID;
import com.portfolio.PortfolioBackend.model.Proyecto;
import com.portfolio.PortfolioBackend.repository.PersonaProyectoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class PersonaProyectoService implements IPersonaProyectoService {

    @Autowired
    private PersonaProyectoRepository persoProyRepo;

    @Override
    public void guardarPersonaProyecto(Persona perso, Proyecto proy, LocalDate fechaIni, LocalDate fechaFin) {
        
        PersonaProyecto persoProy;
        
        try {
            
            persoProy = new PersonaProyecto(perso, proy, fechaIni, fechaFin);
            
            this.savePersonaProyecto(persoProy);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la PersonaProyecto Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------------------");
        }
        
    }

    @Override
    public List<PersonaProyecto> traerListaDeProyectosDeUnaPersona(int idPersona) {
        
        List<PersonaProyecto> listaProyectos;
        
        try {
            listaProyectos = this.persoProyRepo.traerPersonaProyectoQuery(idPersona);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la lista Proyectos Query---------------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------------------");
            listaProyectos = null;
        }
        
        return listaProyectos;
        
    }

    @Override
    public void editarPersonaProyecto(Proyecto proy, Persona perso, LocalDate fechaIni, LocalDate fechaFin) {
        
        try {
            PersonaProyecto persoProy = new PersonaProyecto(perso, proy, fechaIni, fechaFin);
            
            this.savePersonaProyecto(persoProy);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar PersonaProyecto---------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void eliminarProyectoDePersona(Proyecto proy, Persona perso) {
        
        PersonaProyectoID id = new PersonaProyectoID(perso, proy);
        
        try {
            this.persoProyRepo.deleteById(id);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar el Proyecto de Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------");
        }
        
    }
    
    private PersonaProyecto savePersonaProyecto(PersonaProyecto pp) {
        
        PersonaProyecto persoProy = null;
        
        try {
            persoProy = this.persoProyRepo.save(pp);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la PersonaProyecto Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------------------------------------------------------");
        }
        
        return persoProy;
    }
    
}
