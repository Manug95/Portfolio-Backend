
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EditarEmailDTO;
import com.portfolio.PortfolioBackend.dto.EmailDTO;
import com.portfolio.PortfolioBackend.model.Email;
import com.portfolio.PortfolioBackend.model.EmailID;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.repository.EmailRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
@Transactional //tengo que tener esta annotation aca(que es la clase que usa el repository donde esta la query UPDATE y/o DELETE), y en el repository
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
                listaEmails = this.transformarAListaEmail(emails, persona);
                
                this.emailRepo.saveAll((List<Email>)listaEmails);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar los Emails------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void editarEmails(EditarEmailDTO email, Persona persona) {
        
        try {
            this.emailRepo.editarEmailQuery(email.getEmailNuevo(), email.getEmailViejo(), email.getIdPersona());
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar el Email------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }
    
    @Override
    public List<Email> traerEmails(List<EmailDTO> listaEmails, Persona persona) {
        
        List<Email> emails;
        
        List<EmailID> ids = new ArrayList<>();
        
        for (EmailDTO dto : listaEmails) {
            ids.add(new EmailID(dto.getEmail(), persona));
        }
        
        try {
            emails = this.emailRepo.findAllById(ids);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer los Emails------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
            emails = null;
        }
        
        return emails;
        
    }
    
//    @Override
//    public void editarEmails(List<EmailDTO> le, int idPersona) {
//        
//        Persona persona = this.persoServ.traerPersona(idPersona);
//        
//        this.guardarEmails(le, persona);
//        
//    }

    @Override
    public void eliminarEmails(List<EmailDTO> le, Persona persona) {
        
        List<Email> listaEmails;
        
        try {
            //Persona persona = this.persoServ.traerPersona(idPersona);
            
            listaEmails = this.transformarAListaEmail(le, persona);
            
            for (Email e : listaEmails) {
                this.emailRepo.delete(e);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar Email------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------");
        }
        
    }
    
    @Override
    public void eliminarEmail(EmailDTO eDTO, Persona persona) {
        
        Email email;
        
        try {
            //Persona persona = this.persoServ.traerPersona(idPersona);
            
            email = new Email(eDTO.getEmail(), persona);
            
            this.emailRepo.delete(email);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar Email------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------");
        }
        
    }

    @Override
    public ArrayList<EmailDTO> transformarAListaEmailDTO(List<Email> le, int idPersona) {
        
        ArrayList<EmailDTO> emails = new ArrayList<>();
        
        if (!le.isEmpty()) {
            for(Email e : le) {
                emails.add(new EmailDTO(
                    e.getEmail(),
                    idPersona
                ));
            }
        }
        
        return emails;
        
    }

    @Override
    public ArrayList<Email> transformarAListaEmail(List<EmailDTO> le, Persona p) {
        
        ArrayList<Email> emails = new ArrayList<>();
        
        if (!le.isEmpty()) {
            for (EmailDTO e : le) {
                emails.add(new Email(
                    e.getEmail(),
                        p
                ));
            }
        }
        
        return emails;
        
    }
    
}
