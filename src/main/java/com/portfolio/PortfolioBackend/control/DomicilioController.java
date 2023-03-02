

package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@RestController
@RequestMapping(path = "/domicilio")
public class DomicilioController {

    @Autowired
    private IDomicilioService domiServ;
    
    @GetMapping("/editar")
    public void editarDomicilio(@RequestBody DomicilioDTO domi) {
        this.domiServ.editarDomicilio(domi);
    }
    
}
