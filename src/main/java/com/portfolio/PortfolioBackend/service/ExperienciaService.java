
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.model.Experiencia;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.TipoEmpleo;
import com.portfolio.PortfolioBackend.repository.ExperienciaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository expRepo;
    
    @Autowired
    private TipoEmpleoService tipoServ;

    @Override
    public List<ExperienciaDTO> traerExperienciasPersona(int idPersona) {
        
        List<ExperienciaDTO> experienciasDTO = new ArrayList<>();
        
        try {
            List<Experiencia> busqueda = this.expRepo.traerExperienciasPersonaQuery(idPersona);
            
            for (Experiencia e : busqueda) {
                ExperienciaDTO eDTO = this.transformarAExperienciaDTO(e);
                experienciasDTO.add(eDTO);
            }
            
        }
        catch (Exception e) {
            System.out.println("---------------------Error al traer el Experiencias Persona-----------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------------");
        }
        
        return experienciasDTO;
        
    }

    @Override
    public Experiencia guardarExperiencia(ExperienciaDTO expDTO, Persona p) {
        
        Experiencia exp;
        
        try {
            //System.out.println("idExperiencia: " + expDTO.getIdExperiencia());
//            exp = this.transformarAExperiencia(expDTO, p);
//            
//            exp = this.expRepo.save(exp);

            exp = this.crearExperienciaNueva(expDTO, p);
            
        }
        catch (Exception e) {
            System.out.println("---------------------Error al guardar la Experiencia-----------------------");
            System.out.println(e.getMessage());
            System.out.println("----------------------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------------------");
            exp = null;
        }
        
        return exp;
        
    }

    @Override
    public Experiencia editarExperiencia(ExperienciaDTO exp, Persona p) {
        
        if (exp.getIdExperiencia() != 0) {
            return this.guardarExperiencia(exp, p);
        } else {
            System.out.println("No se puede editar una Experiencia sin ID");
            return null;
        }
        
    }

    @Override
    public void eliminarExperiencia(ExperienciaDTO expDTO, Persona p) {
        
        Experiencia exp = this.transformarAExperiencia(expDTO, p);
        
        try {
            this.expRepo.delete(exp);
        }
        catch (Exception e) {
            System.out.println("---------------------Error al eliminar la Experiencias-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------");
        }
        
    }
    
    @Override
    public void eliminarExperiencia(int idExperiencia) {
        
        try {
            this.expRepo.deleteById(idExperiencia);
        }
        catch (Exception e) {
            System.out.println("---------------------Error al eliminar la Experiencias-----------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
    
    @Override
    public Experiencia transformarAExperiencia(ExperienciaDTO expDTO, Persona p) {
        Experiencia exp = null;
        
        if (expDTO != null) {
            exp = new Experiencia();
            
            exp.setIdExperiencia(expDTO.getIdExperiencia());
            exp.setNombre(expDTO.getNombreExperiencia());
            exp.setDescripcion(expDTO.getDescripcion());
            exp.setFechaInicio(expDTO.getFechaInicio());
            exp.setFechaFin(expDTO.getFechaFin());
            exp.setLogoImg(expDTO.getImgLogo());
            exp.setPersonaExp(p);
            
            TipoEmpleo te = this.tipoServ.traerTipoEmpleo(expDTO.getTipoExperiencia());
            
            exp.setTipoEmpleo(te);
        }
        
        return exp;
    }
    
    @Override
    public ExperienciaDTO transformarAExperienciaDTO(Experiencia exp) {
        ExperienciaDTO expDTO = null;
        
        if(exp != null) {
            expDTO = new ExperienciaDTO(
                    exp.getIdExperiencia(),
                    exp.getPersonaExp().getIdPersona(),
                    exp.getNombre(),
                    exp.getDescripcion(),
                    exp.getFechaInicio(),
                    exp.getFechaFin(),
                    exp.getLogoImg(),
                    exp.getTipoEmpleo().getTipo()
            );
        }
        
        return expDTO;
    }
    
    @Override
    public ArrayList<ExperienciaDTO> transformarAListaExperienciaDTO(List<Experiencia> exps) {
        
        ArrayList<ExperienciaDTO> listaExperiencias = new ArrayList<>();
        
        if (!exps.isEmpty()) {
            for (Experiencia e : exps) {
                ExperienciaDTO eDTO = this.transformarAExperienciaDTO(e);
                listaExperiencias.add(eDTO);
            }
        }
        
        return listaExperiencias;
        
    }
    
    private Experiencia crearExperienciaNueva(ExperienciaDTO expDTO, Persona p) throws Exception {
        
        Experiencia exp = null;
        
        if (expDTO != null) {
            exp = new Experiencia();
            
            exp.setIdExperiencia(expDTO.getIdExperiencia());
            exp.setNombre(expDTO.getNombreExperiencia());
            exp.setDescripcion(expDTO.getDescripcion());
            exp.setFechaInicio(expDTO.getFechaInicio());
            exp.setFechaFin(expDTO.getFechaFin());
            exp.setLogoImg(expDTO.getImgLogo());
            exp.setPersonaExp(p);
            
            exp = this.expRepo.save(exp);
            
            TipoEmpleo te = this.tipoServ.traerTipoEmpleo(expDTO.getTipoExperiencia());
            
//            if (te != null) {
                exp.setTipoEmpleo(te);
//            } else {
//                te = this.tipoServ.guardarTipoEmpleoNuevo(expDTO.getTipoExperiencia());
//                exp.setTipoEmpleo(te);
//            }
            
            this.expRepo.save(exp);
            
        }
        
        return exp;
        
    }
    
}
