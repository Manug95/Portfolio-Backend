
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.PersonaDTO;

/**
 * @author Manuel
 */
public interface IPersonaService {
    
    public int crearPersona(int idUsuario, PersonaDTO persona);
    
    public PersonaDTO traerPersona(int id);
    
    public void editarPersona(PersonaDTO persona);
    
    public void eliminarPersona(int id);
    
}
