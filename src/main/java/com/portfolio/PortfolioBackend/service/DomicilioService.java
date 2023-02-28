

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.Domicilio;
import com.portfolio.PortfolioBackend.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private DomicilioRepository domiRepo;
    
    @Override
    public void guardarDomicilio(Domicilio domicilio) {
        
        try {
            this.domiRepo.save(domicilio);
        }
        catch (Exception e) {
            System.out.println("---------------------Error al guardar el Domicilio-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }

}
