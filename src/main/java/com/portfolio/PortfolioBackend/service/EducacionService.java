
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaEducacion;
import com.portfolio.PortfolioBackend.repository.EducacionRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Gutiérrez
 */
@Service
public class EducacionService implements IEducacionService {

    @Autowired
    private EducacionRepository eduRepo;
    
    @Autowired
    private PersonaEducacionService persoEduServ;

    @Override
    public Educacion guardarEducacion(EducacionDTO eduDTO, Persona p) {
        
        Educacion edu = null;
        
        try {
            
            edu = this.eduRepo.buscarEducacionPorNombreYTituloQuery(eduDTO.getNombreInstitucion(), eduDTO.getTituloDeEstudios());
            
            if (edu == null) {
                
                edu = this.transformarAEducacion(eduDTO);
            
                edu = this.SaveEducacion(edu);
                
            }
            
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la Educacion Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        
        return edu;
        
    }

    @Override
    public Educacion traerEducacion(int idEducacion) {
        
        Educacion educacion = null;
        
        try {
            educacion = this.eduRepo.findById(idEducacion).orElse(null);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer la Educacion Entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("---------------------------------------------------------------------------------");
        }
        
        return educacion;
        
    }

    @Override
    public List<EducacionDTO> traerListaDeEducacionesDeUnaPersona(int idPersona) {
        
        ArrayList<EducacionDTO> listaEducaciones = new ArrayList<>();
        
        try {
            List<PersonaEducacion> listaPersoEdu = this.persoEduServ.traerListaDeEducacionesDeUnaPersona(idPersona);
            
            for (PersonaEducacion pe : listaPersoEdu) {
                EducacionDTO eDTO = this.transformarAEducacionDTO(pe.getEducacion(), pe.getFechaInicio(), pe.getFechaFin());
                listaEducaciones.add(eDTO);
            }
        }
        catch (Exception e) {
            System.out.println("----------------------Error al traer las Educaiones de una Persona------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        
        return listaEducaciones;
        
    }
    
    @Override
    public EducacionDTO transformarAEducacionDTO(Educacion edu, LocalDate fechaIni, LocalDate fechaFin) {
        
        EducacionDTO eduDTO = null;
        
        if(edu != null) {
            eduDTO = new EducacionDTO(
                    edu.getIdEducacion(),
                    edu.getNombreInstitucion(),
                    edu.getTituloEstudios(),
                    edu.getLogoInstitucion(),
                    fechaIni,
                    fechaFin
            );
        }
        
        return eduDTO;
        
    }
    
    @Override
    public Educacion transformarAEducacion(EducacionDTO eduDTO) {
        
        Educacion educacion = null;
        
        if (eduDTO != null) {            
            educacion = new Educacion(
                    eduDTO.getIdEducacion(),
                    eduDTO.getNombreInstitucion(),
                    eduDTO.getTituloDeEstudios(),
                    eduDTO.getLogoInstitucion()
            );
        }
        
        return educacion;
    }
    
    private Educacion SaveEducacion(Educacion edu) {
        Educacion educacion = null;
        
        try {
            educacion = this.eduRepo.save(edu);
        }
        catch (Exception e) {
            System.out.println("----------------------Error al guardar la Educacion entidad------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        return educacion;
    }
    
}
