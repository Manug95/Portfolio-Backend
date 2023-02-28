
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.TelefonoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Telefono;
import com.portfolio.PortfolioBackend.repository.TelefonoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class TelefonoService implements ITelefonoService {

    @Autowired
    private TelefonoRepository telRepo;

    @Override
    public void guardarTelefono(Long telefono, Persona persona) {
        
        Telefono telGuardar;
        
        try {
            if (telefono != null) {
                telGuardar = new Telefono(telefono, persona);
                
                this.telRepo.save(telGuardar);
            }
        }
        catch (Exception e) {
            System.out.println("-----------------------Error al guardar el Telefono-------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }

    @Override
    public void guardarTelefonos(List<TelefonoDTO> emails, Persona persona) {
        
        List<Telefono> listaTelefonos;
        
        try {
            if (emails != null) {
                listaTelefonos = new ArrayList<Telefono>();
                
                for(TelefonoDTO tel : emails) {
                    listaTelefonos.add(new Telefono(tel.getTelefono(), persona));
                }
                
                this.telRepo.saveAll((List<Telefono>)listaTelefonos);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar los Telefonos------------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------");
        }
        
    }
    
}
