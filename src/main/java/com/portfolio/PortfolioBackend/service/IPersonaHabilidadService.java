
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaHabilidad;
import java.util.List;

/**
 * @author Manuel
 */
public interface IPersonaHabilidadService {
    
    public void guardarPersonaHabilidad(Persona p, Habilidad h, short progreso);
    
    public List<PersonaHabilidad> traerListaDeHabilidadesDeUnaPersona(int idPersona);
    
    public void editarProgresoDeHabilidad(Habilidad h, Persona p, short progreso);
    
    public void eliminarHabilidadDePersona(Habilidad h, Persona p);
    
}
