

package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.TipoHabilidadDTO;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.model.TipoHabilidad;
import com.portfolio.PortfolioBackend.repository.TipoHabilidadRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class TipoHabilidadService implements ITipoHabilidadService {
    
    @Autowired
    private TipoHabilidadRepository tipoHabRepo;

    @Override
    public List<TipoHabilidadDTO> traerTiposHabilidades() {
        
        List<TipoHabilidadDTO> listaTipoHab;
        
        try {
            List<TipoHabilidad> habTraidas = this.tipoHabRepo.findAll();
            
            listaTipoHab = this.transformarATipoHabilidadDTO(habTraidas);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la lista de TipoHabilidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------");
            listaTipoHab = null;
        }
        
        return listaTipoHab;
        
    }
    
    public ArrayList<TipoHabilidadDTO> transformarATipoHabilidadDTO(List<TipoHabilidad> listaHabilidades) {
        
        ArrayList<TipoHabilidadDTO> lista = new ArrayList<>();
        
        if (listaHabilidades != null) {
            for (TipoHabilidad th : listaHabilidades) {
                lista.add(new TipoHabilidadDTO(
                        th.getIdTipoHabilidad(),
                        th.getNombreTipoHabilidad()
                ));
            }
        }
        
        return lista;
    }

    @Override
    public TipoHabilidad traerTipoHabilidad(String nombreTipoHab) {
        
        TipoHabilidad hab = null;
        
        try {
            hab = this.tipoHabRepo.buscarHabilidad(nombreTipoHab);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la TipoHabilidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------------------");
            hab = null;
        }
        
        return hab;
        
    }
    
}
