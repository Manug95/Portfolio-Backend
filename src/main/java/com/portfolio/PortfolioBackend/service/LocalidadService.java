
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.Localidad;
import com.portfolio.PortfolioBackend.repository.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class LocalidadService implements ILocalidadService {

    @Autowired
    private LocalidadRepository localRepo;
    
    @Override
    public void guardarLocalidad(Localidad localidad) {
        
        try {
            this.localRepo.save(localidad);
        }
        catch (Exception e) {
            System.out.println("---------------------Error al guardar la Localidad-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }

    }

}
