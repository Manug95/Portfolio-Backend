
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EditarEmailDTO;
import com.portfolio.PortfolioBackend.dto.EmailDTO;
import com.portfolio.PortfolioBackend.model.Email;
import com.portfolio.PortfolioBackend.model.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel
 */
public interface IEmailService {
    
    public void guardarEmail(String email, Persona persona);
    
    public void guardarEmails(List<EmailDTO> emails, Persona persona);
    
    public List<Email> traerEmails(List<EmailDTO> listaEmails, Persona p);
    
    public void editarEmails(EditarEmailDTO email, Persona p);
    
//    public void editarEmails(List<EmailDTO> le, int idPersona);
    
    public void eliminarEmails(List<EmailDTO> le, Persona persona);
    
    public void eliminarEmail(EmailDTO e, Persona persona);
    
    public ArrayList<EmailDTO> transformarAListaEmailDTO(List<Email> le, int idPersona);
    
    public ArrayList<Email> transformarAListaEmail(List<EmailDTO> le, Persona p);
    
}
