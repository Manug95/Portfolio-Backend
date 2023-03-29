
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.ProyectoDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaProyecto;
import com.portfolio.PortfolioBackend.model.Proyecto;
import com.portfolio.PortfolioBackend.repository.ProyectoRepository;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyRepo;
    
    @Autowired
    private PersonaProyectoService persoProyServ;

    @Override
    public Proyecto guardarProyecto(ProyectoDTO proyDTO, Persona p) {
        
        Proyecto proy = null;
        
        try {
            
            proy = this.proyRepo.buscarProyectoPorNombreYUrlQuery(proyDTO.getNombreProyecto(), proyDTO.getUrlRepositorio());
            
            if (proy == null) {
                
                proy = this.transformarAProyecto(proyDTO);
            
                proy = this.SaveProyecto(proy);
                
            }
            
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la Proyecto Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        
        return proy;
        
    }

    @Override
    public Proyecto traerProyecto(int idEducacion) {
        
        Proyecto proyecto = null;
        
        try {
            proyecto = this.proyRepo.findById(idEducacion).orElse(null);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la Proyecto Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
        }
        
        return proyecto;
        
    }

    @Override
    public List<ProyectoDTO> traerListaDeProyectosDeUnaPersona(int idPersona) {
        
        ArrayList<ProyectoDTO> listaProyectos = new ArrayList<>();
        
        try {
            List<PersonaProyecto> listaPersoProy = this.persoProyServ.traerListaDeProyectosDeUnaPersona(idPersona);
            
            for (PersonaProyecto pp : listaPersoProy) {
                ProyectoDTO proyDTO = this.transformarAProyectoDTO(pp.getProyecto(), pp.getFechaInicio(), pp.getFechaFin());
                listaProyectos.add(proyDTO);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer las Proyectos de una Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        
        return listaProyectos;
        
    }

    @Override
    public Proyecto transformarAProyecto(ProyectoDTO proyDTO) {
        
        Proyecto proyecto = null;
        
        if (proyDTO != null) {            
            proyecto = new Proyecto(
                    proyDTO.getIdProyecto(),
                    proyDTO.getNombreProyecto(),
                    proyDTO.getDescripcion(),
                    proyDTO.getUrlRepositorio()
            );
        }
        
        return proyecto;
        
    }

    @Override
    public ProyectoDTO transformarAProyectoDTO(Proyecto proy, LocalDate fechaIni, LocalDate fechaFin) {
        
        ProyectoDTO proyDTO = null;
        
        if(proy != null) {
            proyDTO = new ProyectoDTO(
                    proy.getIdProyecto(),
                    proy.getNombre(),
                    proy.getDescripcion(),
                    proy.getUrlRepositorio(),
                    fechaIni,
                    fechaFin
            );
        }
        
        return proyDTO;
        
    }
    
    private Proyecto SaveProyecto(Proyecto proy) {
        Proyecto proyecto = null;
        
        try {
            proyecto = this.proyRepo.save(proy);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Proyecto entidad");
        }
        return proyecto;
    }

    @Override
    public Proyecto editarProyecto(ProyectoDTO proyDTO) {
        
        Proyecto proy;
        
        try {
            proy = this.transformarAProyecto(proyDTO);
        
            proy = this.SaveProyecto(proy);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al Editar Proyecto en ProyetoService");
            proy = null;
        }
        
        return proy;
        
    }
    
}
