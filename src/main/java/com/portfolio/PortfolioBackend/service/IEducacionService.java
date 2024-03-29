
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Manuel
 */
public interface IEducacionService {
    
    public Educacion guardarEducacion(EducacionDTO eduDTO, Persona p/*, MultipartFile logo*/) throws Exception;
    
    public Educacion traerEducacion(int idEducacion);
    
    public List<EducacionDTO> traerListaDeEducacionesDeUnaPersona(int idPersona);
    
    public Educacion transformarAEducacion(EducacionDTO eduDTO);
    
    public EducacionDTO transformarAEducacionDTO(Educacion edu, LocalDate fechaIni, LocalDate fechaFin);
    
    public Educacion editarEducacion(EducacionDTO eduDTO, Persona p/*, MultipartFile logo*/) throws Exception;
    
}
