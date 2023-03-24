
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.PersonaEducacion;
import com.portfolio.PortfolioBackend.repository.EducacionRepository;
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
public class EducacionService implements IEducacionService {

    @Autowired
    private EducacionRepository eduRepo;
    
    @Autowired
    private PersonaEducacionService persoEduServ;

    @Override
    public Educacion guardarEducacion(EducacionDTO eduDTO, Persona p) throws Exception {
        
        Educacion edu = null;
        
        try {
            
            edu = this.eduRepo.buscarEducacionPorNombreYTituloQuery(eduDTO.getNombreInstitucion(), eduDTO.getTituloDeEstudios());
            
            if (edu == null) {
                
                edu = this.transformarAEducacion(eduDTO);
            
                edu = this.SaveEducacion(edu);
                
            }
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Educacion Entidad");
            
            throw new Exception("exception en guardarEducacion");
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
            Mensaje.mensajeCatch(e, "Error al traer la Educacion Entidad");
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
            Mensaje.mensajeCatch(e, "Error al traer las Educaiones de una Persona");
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
    
    private Educacion SaveEducacion(Educacion edu) throws Exception {
        Educacion educacion = null;
        
        try {
            educacion = this.eduRepo.save(edu);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al guardar la Educacion entidad");
            throw new Exception("exception en saveEducation");
        }
        return educacion;
    }

    @Override
    public Educacion editarEducacion(EducacionDTO eduDTO, Persona p) throws Exception {
        
        Educacion edu = null;
        
        try {
            
            edu = this.eduRepo.buscarEducacionPorNombreYTituloQuery(eduDTO.getNombreInstitucion(), eduDTO.getTituloDeEstudios());
            
            if (edu == null) {
                
                edu = this.transformarAEducacion(eduDTO);
                
                edu.setIdEducacion(0);
            
                edu = this.SaveEducacion(edu);
                
            }
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error al editar la Educacion Entidad");
            
            throw new Exception("exception en editarEducacion");
        }
        
        return edu;
        
    }
    
}
