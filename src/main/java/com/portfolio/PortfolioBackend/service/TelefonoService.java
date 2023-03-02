
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EditarTelefonoDTO;
import com.portfolio.PortfolioBackend.dto.TelefonoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Telefono;
import com.portfolio.PortfolioBackend.model.TelefonoID;
import com.portfolio.PortfolioBackend.repository.TelefonoRepository;
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

    @Override
    public List<Telefono> traerTelefonos(List<TelefonoDTO> listaTel, Persona persona) {
        
        List<Telefono> telefonos;
        
        List<TelefonoID> ids = new ArrayList<>();
        
        for (TelefonoDTO dto : listaTel) {
            ids.add(new TelefonoID(dto.getTelefono(), persona));
        }
        
        try {
            telefonos = this.telRepo.findAllById(ids);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer los Telefonos------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
            telefonos = null;
        }
        
        return telefonos;
        
    }

    @Override
    public void eliminarTelefonos(List<TelefonoDTO> listaTel, Persona persona) {
        
        List<Telefono> listaTelefonos;
        
        try {
            
            listaTelefonos = this.transformarAListaTelefono(listaTel, persona);
            
            for (Telefono tel : listaTelefonos) {
                this.telRepo.delete(tel);
            }
            
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar Telefono------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------");
        }
        
    }

    @Override
    public void eliminarTelefono(TelefonoDTO telDTO, Persona persona) {
        
        Telefono telefono;
        
        try {
            
            telefono = new Telefono(telDTO.getTelefono(), persona);
            
            this.telRepo.delete(telefono);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al eliminar Telefono------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------");
        }
        
    }

    @Override
    public ArrayList<TelefonoDTO> transformarAListaTelefonoDTO(List<Telefono> listaTel, int idPersona) {
        
        ArrayList<TelefonoDTO> telefonos = new ArrayList<>();
        
        if (!listaTel.isEmpty()) {
            for(Telefono tel : listaTel) {
                telefonos.add(new TelefonoDTO(
                    tel.getTelefono(),
                    idPersona
                ));
            }
        }
        
        return telefonos;
        
    }

    @Override
    public ArrayList<Telefono> transformarAListaTelefono(List<TelefonoDTO> listaTel, Persona persona) {
        
        ArrayList<Telefono> telefonos = new ArrayList<>();
        
        if (!listaTel.isEmpty()) {
            for (TelefonoDTO tel : listaTel) {
                telefonos.add(new Telefono(
                    tel.getTelefono(),
                        persona
                ));
            }
        }
        
        return telefonos;
        
    }

    @Override
    public void editarTelefonos(EditarTelefonoDTO telefonoEd, Persona persona) {
        
        try {
            this.telRepo.editarTelefonoQuery(telefonoEd.getTelNuevo(), telefonoEd.getTelViejo(), telefonoEd.getIdPersona());
        }
        catch (Exception e) {
            System.out.println("----------------------Error al editar el Telefono------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------");
        }
        
    }
    
}
