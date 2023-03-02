
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.dto.PersonaDTO;
import com.portfolio.PortfolioBackend.model.Persona;

/**
 * @author Manuel
 */
public interface IPersonaService {
    
    public int inicializarPersona(/*int idUsuario, */PersonaDTO persona);
    
    public PersonaDTO traerPersonaDTO(int id);
    
    public Persona traerPersona(int id);
    
    public void editarPersona(PersonaDTO persona);
    
    public void eliminarPersona(int id);
    
    public void cambiarDomicilio(DomicilioDTO domi, int idPersona);
    
    public Persona transformarAPersona(PersonaDTO p);
    
    public PersonaDTO transformarAPersonaDTO(Persona p);
    
}
