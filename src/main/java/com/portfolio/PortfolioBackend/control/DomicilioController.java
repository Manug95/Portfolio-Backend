

package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.service.DomicilioService;
import com.portfolio.PortfolioBackend.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioService domiServ;
    
    @PutMapping("/editar")
    public void editarDomicilio(@RequestBody DomicilioDTO domi) {
        this.domiServ.editarDomicilio(domi);
    }
    
}
