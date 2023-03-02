

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.DomicilioDTO;
import com.portfolio.PortfolioBackend.dto.LocalidadDTO;
import com.portfolio.PortfolioBackend.dto.ProvinciaDTO;
import com.portfolio.PortfolioBackend.model.Domicilio;
import com.portfolio.PortfolioBackend.model.Localidad;
import com.portfolio.PortfolioBackend.model.Provincia;
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
    
    @Autowired
    private LocalidadService localServ;
    
    @Override
    public Domicilio guardarDomicilioEntidad(Domicilio domicilio) {
        
        Domicilio domi = null;
        
        try {
            domi = this.domiRepo.save(domicilio);
            
        }
        catch (Exception e) {
            System.out.println("---------------------Error al guardar el Domicilio Entidad-----------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
            domi = null;
        }
        
        return domi;
        
    }

    @Override
    public Integer buscarDomicilio(DomicilioDTO domicilio) {
        
        Integer res= this.domiRepo.buscarDomicilioQuery(domicilio.getCalle(), 
                domicilio.getAltura(), 
                domicilio.getLocalidad().getNombre(), 
                domicilio.getLocalidad().getProvincia().getNombre()
        );
        
        return res;
    }

    @Override
    public Domicilio traerDomicilio(int id) {
        
        Domicilio domicilio;
        
        try {
            domicilio = this.domiRepo.findById(id).orElse(null);
        }
        catch (Exception e) {
            domicilio = null;
            System.out.println("---------------------Error al traer el Domicilio-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------");
        }
        
        return domicilio;
    }
    
    @Override
    public Domicilio traerDomicilio(DomicilioDTO domi) {
        
        Domicilio domicilio;
        
        try {
            Integer idDomi = this.buscarDomicilio(domi);
            
            domicilio = this.traerDomicilio(idDomi);
        }
        catch (Exception e) {
            domicilio = null;
            System.out.println("---------------------Error al traer el Domicilio-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------");
        }
        
        return domicilio;
        
    }
    
    /**
     * Busca si el domicilio a registrar ya existe
     * Si no existe crea el domicilio y lo guarda
     * Si existe trae el domicilio y lo devuelve
     * @param domi
     * @return El Domicilio a setear en la entidad Persona
     */
    @Override
    public Domicilio guardarDomicilioPersona(DomicilioDTO domi) {
        
        Domicilio domicilio = null;
        
        try {
            
            Integer idDomi = this.buscarDomicilio(domi);
            
            if (idDomi == null) {
                
                domicilio = this.transformarADomicilio(domi);
                
                this.localServ.guardarLocalidad(domicilio.getLocalidad());
                
                this.guardarDomicilioEntidad(domicilio);
                //si la persona no se asocia al domicilio nuevo cambiar la linea de arriba por la de abajo
                //domicilio = this.guardarDomicilioEntidad(domicilio);
                
            } else {
                domicilio = this.traerDomicilio(idDomi);
            }

        }
        catch (Exception e) {
            domicilio = null;
            System.out.println("---------------------Error al guardar el Domicilio Persona-----------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
        }

        return domicilio;
        
    }

    @Override
    public void editarDomicilio(DomicilioDTO domi) {
        
        Domicilio domicilio;
        
        try {
            domicilio = this.transformarADomicilio(domi);
                
            this.localServ.guardarLocalidad(domicilio.getLocalidad());

            this.guardarDomicilioEntidad(domicilio); 
        }
        catch (Exception e) {
            System.out.println("---------------------Error al modificar el Domicilio Entidad-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        
    }

    @Override
    public Domicilio transformarADomicilio(DomicilioDTO domi) {
        
        Domicilio domicilio = null;
        
        if (domi != null) {
            Provincia provincia = new Provincia(
                domi.getLocalidad().getProvincia().getIdProvincia(),
                domi.getLocalidad().getProvincia().getNombre()
            );

            Localidad localidad = new Localidad(
                domi.getLocalidad().getIdLocalidad(),
                domi.getLocalidad().getNombre(),
                provincia
            );

            domicilio = new Domicilio(
                domi.getIdDomicilio(),
                domi.getCalle(),
                domi.getAltura(),
                localidad
            );
        }
        
        return domicilio;
        
    }

    @Override
    public DomicilioDTO transformarADomicilioDTO(Domicilio domi) {
        
        DomicilioDTO domicilio = null;
        
        if (domi != null) {
            
            ProvinciaDTO provincia = new ProvinciaDTO(
                domi.getLocalidad().getProvincia().getIdProvincia(),
                domi.getLocalidad().getProvincia().getNombre()
            );

            LocalidadDTO localidad = new LocalidadDTO(
                domi.getLocalidad().getIdLocalidad(),
                domi.getLocalidad().getNombre(),
                provincia
            );

            domicilio = new DomicilioDTO(
                domi.getIdDomicilio(),
                domi.getCalle(),
                domi.getAltura(),
                localidad
            );
            
        }
        
        return domicilio;
        
    }

    

}
