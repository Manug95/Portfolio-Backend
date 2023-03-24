
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.RedSocialDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.RedSocial;
import com.portfolio.PortfolioBackend.repository.RedSocialRepository;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Manuel Gutiérrez
 */
@Service
@Transactional
public class RedSocialService implements IRedSocialService {

    @Autowired
    private RedSocialRepository redRepo;

    @Override
    public RedSocial guardarRedSocial(RedSocial rs) {
        
        RedSocial redSocial = null;
        
        try {
            redSocial = this.saveRedSocial(rs);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error en guardarRedSocial - clase RedSocialService");
        }
        
        return redSocial;
        
    }

    @Override
    public List<RedSocialDTO> traerRedesSocialesDeUnaPersona(int idPersona) {
        
        ArrayList<RedSocialDTO> redesDTO = new ArrayList<>();
        
        try {
            List<RedSocial> redes = this.redRepo.traerRedesSocialesDeUnaPersonaQuery(idPersona);
            
            for (RedSocial rs : redes) {
                redesDTO.add(this.transformarARedSocialDTO(rs));
            }
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error traerRedesSocialesDeUnaPersona - clase RedSocialService");
        }
        
        return redesDTO;
        
    }

    @Override
    public RedSocial traerRedSocial(int idRedSocail) {
        RedSocial redSocial = null;
        
        try {
            redSocial = this.redRepo.findById(idRedSocail).orElse(null);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error traerRedSocial - clase RedSocialService");
        }
        
        return redSocial;
        
    }

    @Override
    public void editarRedSocial(RedSocialDTO rsDTO, Persona p) {
        
        RedSocial redSocial = new RedSocial(
                rsDTO.getIdRedSocial(),
                rsDTO.getResSocial(),
                p
        );
        
        this.saveRedSocial(redSocial);
        
    }

    @Override
    public void borrarRedSocial(int idRedSocial) {
        
        try {
            this.redRepo.deleteById(idRedSocial);
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Error borrarRedSocial - clase RedSocialService");
        }
        
    }
    
    private RedSocial saveRedSocial(RedSocial rs) {
        RedSocial redSocial = null;
        
        try {
            redSocial = this.redRepo.save(rs);
        }
        catch (Exception e ) {
            Mensaje.mensajeCatch(e, "Error saveReDSocial - clase RedSocialService");
        }
        
        return redSocial;
    }

    @Override
    public RedSocial transformarARedSocial(RedSocialDTO rsDTO) {
//        RedSocial redSocial = null;
//        
//        if (rsDTO != null) {
//            return new RedSocial(
//                    rsDTO.getIdRedSocial(),
//                    rsDTO.getResSocial(),
//            );
//        }
        return null;
    }

    @Override
    public RedSocialDTO transformarARedSocialDTO(RedSocial rs) {
        RedSocialDTO redDTO = null;
        
        if (rs != null) {
            return new RedSocialDTO(
                    rs.getIdRedSocial(),
                    rs.getpersonaRS().getIdPersona(),
                    rs.getRedSocial()
            );
        }
        
        return redDTO;
        
    }
    
}
