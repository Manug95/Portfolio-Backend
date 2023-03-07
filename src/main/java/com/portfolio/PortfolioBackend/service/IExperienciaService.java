
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.model.Experiencia;
import com.portfolio.PortfolioBackend.model.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel
 */
public interface IExperienciaService {
    
    public List<ExperienciaDTO> traerExperienciasPersona(int idPersona);
    
    public Experiencia guardarExperiencia(ExperienciaDTO exp, Persona p);
    
    public void editarExperiencia(ExperienciaDTO exp, Persona p);
    
    public void eliminarExperiencia(ExperienciaDTO exp, Persona p);
    
    public void eliminarExperiencia(int idExperiencia);
    
    public ExperienciaDTO transformarAExperienciaDTO(Experiencia exp);
    
    public Experiencia transformarAExperiencia(ExperienciaDTO expDTO, Persona p);
    
    public ArrayList<ExperienciaDTO> transformarAListaExperienciaDTO(List<Experiencia> exp);
    
}
