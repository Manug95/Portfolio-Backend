
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaHabilidad;
import com.portfolio.PortfolioBackend.model.TipoHabilidad;
import com.portfolio.PortfolioBackend.repository.HabilidadRepository;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class HabilidadService implements IHabilidadService {
    
    @Autowired
    private ITipoHabilidadService tipoHabServ;
    
    @Autowired
    private HabilidadRepository habRepo;
    
    @Autowired
    private PersonaHabilidadService persoHabServ;

    @Override
    public Habilidad guardarHabilidad(HabilidadDTO habDTO, Persona p) {
        
        Habilidad hab = null;
        
        try {
            
            hab = this.transformarAHabilidad(habDTO);
            
            hab = this.SaveHabilidad(hab);
            
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la habilidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------");
        }
        
        return hab;
        
    }
    
    @Override
    public Habilidad traerHabilidad(int idHabilidad) {
        
        Habilidad habilidad = null;
        
        try {
            habilidad = this.habRepo.findById(idHabilidad).orElse(null);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la habilidad Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
        }
        
        return habilidad;
        
    }
    
    @Override
    public List<HabilidadDTO> traerListaDeHabilidadesDeUnaPersona(int idPersona) {
        
        ArrayList<HabilidadDTO> listaHabilidades = new ArrayList<>();
        
        try {
            List<PersonaHabilidad> listaPersoHab = this.persoHabServ.traerListaDeHabilidadesDeUnaPersona(idPersona);
            
            for (PersonaHabilidad ph : listaPersoHab) {
                HabilidadDTO hDTO = this.transformarAHabilidadDTO(ph.getHabilidad(), ph.getProgreso());
                listaHabilidades.add(hDTO);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer las habilidades de una Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        
        return listaHabilidades;
        
    }
    
    public HabilidadDTO transformarAHabilidadDTO(Habilidad hab, short progreso) {
        
        HabilidadDTO habDTO = null;
        
        if(hab != null) {
            habDTO = new HabilidadDTO(
                    hab.getIdHabilidad(),
                    hab.getNombre(),
                    hab.getTipoHabilidad().getNombreTipoHabilidad(),
                    progreso
            );
        }
        
        return habDTO;
        
    }

    public Habilidad transformarAHabilidad(HabilidadDTO habDTO) {
        Habilidad habilidad = null;
        
        if (habDTO != null) {
            TipoHabilidad tipo = this.tipoHabServ.traerTipoHabilidad(habDTO.getTipoHabilidad());
            
            habilidad = new Habilidad(
                    habDTO.getIdHabilidad(),
                    habDTO.getNombreHabilidad(),
                    tipo
            );
        }
        
        return habilidad;
    }
    
    private Habilidad SaveHabilidad(Habilidad h) {
        Habilidad hab = null;
        
        try {
            hab = this.habRepo.save(h);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la habilidad entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        return hab;
    }

    @Override
    public Habilidad editarHabilidad(HabilidadDTO habDTO) {
        
        Habilidad hab;
        
        try {
            hab = this.transformarAHabilidad(habDTO);
            
            hab = this.SaveHabilidad(hab);
            
            return hab;
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al editarHabilidad en HabilidadService");
            return null;
        }
        
    }
    
}
