
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EditarTelefonoDTO;
import com.portfolio.PortfolioBackend.dto.TelefonoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Telefono;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel
 */
public interface ITelefonoService {
    
    public void guardarTelefono(Long telefono, Persona persona);
    
    public void guardarTelefonos(List<TelefonoDTO> emails, Persona persona);
    
    public List<Telefono> traerTelefonos(List<TelefonoDTO> listaTel, Persona p);
    
    public void editarTelefonos(EditarTelefonoDTO telefono, Persona p);
    
    public void eliminarTelefonos(List<TelefonoDTO> listaTel, Persona persona);
    
    public void eliminarTelefono(TelefonoDTO e, Persona persona);
    
    public ArrayList<TelefonoDTO> transformarAListaTelefonoDTO(List<Telefono> le, int idPersona);
    
    public ArrayList<Telefono> transformarAListaTelefono(List<TelefonoDTO> le, Persona p);
    
}
