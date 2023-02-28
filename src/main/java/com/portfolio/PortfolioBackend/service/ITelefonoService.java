
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.TelefonoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import java.util.List;

/**
 * @author Manuel
 */
public interface ITelefonoService {
    
    public void guardarTelefono(Long telefono, Persona persona);
    
    public void guardarTelefonos(List<TelefonoDTO> emails, Persona persona);
    
}
