
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.EditarEmailDTO;
import com.portfolio.PortfolioBackend.dto.EmailDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.IEmailService;
import com.portfolio.PortfolioBackend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@RestController
@RequestMapping(path = "/emails")
public class EmailController {

    @Autowired
    private IEmailService emailServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @PutMapping("/editar")
    public void editarEmail(@RequestBody EditarEmailDTO listaEmails) {
        
        //Persona persona = this.persoServ.traerPersona(idPersona);
        
        this.emailServ.editarEmails(listaEmails, null);
        
    }
    
}
