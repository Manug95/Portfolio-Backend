
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.TipoEmpleo;

/**
 * @author Manuel
 */
public interface ITipoEmpleoService {
    
    public TipoEmpleo traerTipoEmpleo(String tipoEmpleo);
    
    public TipoEmpleo guardarTipoEmpleoNuevo(String tipoEmpleo);
    
}
