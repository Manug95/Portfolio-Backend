
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import java.util.List;

/**
 * @author Manuel
 */
public interface IHabilidadService {
    
    public Habilidad guardarHabilidad(HabilidadDTO habDTO, Persona p);
    
    public Habilidad traerHabilidad(int idHabilidad);
    
    public List<HabilidadDTO> traerListaDeHabilidadesDeUnaPersona(int idPersona);
    
}
