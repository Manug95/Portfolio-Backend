
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.TipoHabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.TipoHabilidad;
import java.util.List;

/**
 * @author Manuel
 */
public interface ITipoHabilidadService {
    
    public List<TipoHabilidadDTO> traerTiposHabilidades();
    
    public TipoHabilidad traerTipoHabilidad(String h);
    
}
