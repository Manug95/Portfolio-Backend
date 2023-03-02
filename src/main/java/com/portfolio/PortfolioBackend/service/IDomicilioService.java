
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.model.Domicilio;

/**
 * @author Manuel
 */
public interface IDomicilioService {
    
    public Domicilio guardarDomicilioEntidad(Domicilio domicilio);
    
    public Domicilio guardarDomicilioPersona(DomicilioDTO domi);
    
    public Domicilio traerDomicilio(int id);
    
    public Domicilio traerDomicilio(DomicilioDTO domicilio);
    
    public Integer buscarDomicilio(DomicilioDTO domicilio);
    
    public void editarDomicilio(DomicilioDTO domicilio);
    
    public Domicilio transformarADomicilio(DomicilioDTO d);
    
    public DomicilioDTO transformarADomicilioDTO(Domicilio d);
    
}
