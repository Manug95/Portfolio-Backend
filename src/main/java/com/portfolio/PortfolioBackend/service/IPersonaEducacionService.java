
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaEducacion;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Manuel
 */
public interface IPersonaEducacionService {
    
    public void guardarPersonaEducacion(Persona p, Educacion e, LocalDate fechaIni, LocalDate fechaFin);
    
    public List<PersonaEducacion> traerListaDeEducacionesDeUnaPersona(int idPersona);
    
    public void editarPersonaEducacion(Educacion e, Persona p, LocalDate fechaIni, LocalDate fechaFin);
    
    public void eliminarEducacionDePersona(Educacion e, Persona p);
    
}
