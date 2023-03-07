
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.model.TipoEmpleo;
import com.portfolio.PortfolioBackend.repository.TipoEmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class TipoEmpleoService implements ITipoEmpleoService {

    @Autowired
    private TipoEmpleoRepository tipoEmpRepo;

    @Override
    public TipoEmpleo traerTipoEmpleo(String tipoEmpleo) {
        
        TipoEmpleo te;
        
        try {
            te = this.tipoEmpRepo.traerTipoEmpleoQuery(tipoEmpleo);
            
            if(te == null) {
                te = this.guardarTipoEmpleoNuevo(tipoEmpleo);
            }
        }
        catch (Exception e) {
            System.out.println("---------------------Error al taer el TipoEmpelo Entidad-----------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("---------------------------------------------------------------------------------");
            te = null;
        }
        
        return te;
        
    }

    @Override
    public TipoEmpleo guardarTipoEmpleoNuevo(String tipoEmpleo) {
        
        TipoEmpleo nuevoTipoEmp = new TipoEmpleo(tipoEmpleo);
        
        try {
            nuevoTipoEmp = this.tipoEmpRepo.save(nuevoTipoEmp);
        }
        catch (Exception e) {
            System.out.println("---------------------Error al guardar el TipoEmpelo Entidad-----------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
        }
        
        return nuevoTipoEmp;
        
    }
    
    
    
}
