
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaProyecto;
import com.portfolio.PortfolioBackend.model.Proyecto;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Manuel
 */
public interface IPersonaProyectoService {
    
    public void guardarPersonaProyecto(Persona perso, Proyecto proy, LocalDate fechaIni, LocalDate fechaFin);
    
    public List<PersonaProyecto> traerListaDeProyectosDeUnaPersona(int idPersona);
    
    public void editarPersonaProyecto(Proyecto proy, Persona perso, LocalDate fechaIni, LocalDate fechaFin);
    
    public void eliminarProyectoDePersona(Proyecto proy, Persona perso);
    
}
