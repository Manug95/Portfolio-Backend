
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EmailDTO;
import com.portfolio.PortfolioBackend.model.Email;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.repository.EmailRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class EmailService implements IEmailService {

    @Autowired
    private EmailRepository emailRepo;

    @Override
    public void guardarEmail(String email, Persona persona) {
        
        Email emailGuardar;
        
        try {
            if (email != null) {
                emailGuardar = new Email(email, persona);
                
                this.emailRepo.save(emailGuardar);
            }
        }
        catch (Exception e) {
            System.out.println("-----------------------Error al guardar el Email-------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void guardarEmails(List<EmailDTO> emails, Persona persona) {
        
        List<Email> listaEmails;
        
        try {
            if (emails != null) {
                listaEmails = new ArrayList<Email>();
                
                for(EmailDTO em : emails) {
                    listaEmails.add(new Email(em.getEmail(), persona));
                }
                
                this.emailRepo.saveAll((List<Email>)listaEmails);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar los Emails------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }
    
}
