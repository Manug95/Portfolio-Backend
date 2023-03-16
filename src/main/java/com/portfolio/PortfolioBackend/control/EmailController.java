
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.EditarEmailDTO;
import com.portfolio.PortfolioBackend.service.EmailService;
import com.portfolio.PortfolioBackend.service.IEmailService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import com.portfolio.PortfolioBackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/emails")
public class EmailController {

    @Autowired
    private EmailService emailServ;
    
    @Autowired
    private PersonaService persoServ;
    
    @PutMapping("/editar")
    public void editarEmail(@RequestBody EditarEmailDTO listaEmails) {
        
        //Persona persona = this.persoServ.traerPersona(idPersona);
        
        this.emailServ.editarEmails(listaEmails, null);
        
    }
    
}
