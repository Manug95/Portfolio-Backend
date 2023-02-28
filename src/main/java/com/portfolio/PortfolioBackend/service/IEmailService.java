
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EmailDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import java.util.List;

/**
 * @author Manuel
 */
public interface IEmailService {
    
    public void guardarEmail(String email, Persona persona);
    
    public void guardarEmails(List<EmailDTO> emails, Persona persona);
    
}
