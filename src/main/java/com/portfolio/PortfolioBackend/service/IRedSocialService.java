
package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.RedSocialDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.model.RedSocial;
import java.util.List;

/**
 * @author Manuel
 */
public interface IRedSocialService {
    
    public RedSocial guardarRedSocial(RedSocial rs);
    
    public List<RedSocialDTO> traerRedesSocialesDeUnaPersona(int idPersona);
    
    public RedSocial traerRedSocial(int idRedSocail);
    
    public void editarRedSocial(RedSocialDTO rsDTO, Persona p);
    
    public void borrarRedSocial(int idRedSocial);
    
    public RedSocial transformarARedSocial(RedSocialDTO rsDTO);
    
    public RedSocialDTO transformarARedSocialDTO(RedSocial rs);
    
}
