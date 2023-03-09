
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.ProyectoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.Proyecto;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Manuel
 */
public interface IProyectoService {
    
    public Proyecto guardarProyecto(ProyectoDTO eduDTO, Persona p);
    
    public Proyecto traerProyecto(int idEducacion);
    
    public List<ProyectoDTO> traerListaDeProyectosDeUnaPersona(int idPersona);
    
    public Proyecto transformarAProyecto(ProyectoDTO proyDTO);
    
    public ProyectoDTO transformarAProyectoDTO(Proyecto proy, LocalDate fechaIni, LocalDate fechaFin);
    
}
