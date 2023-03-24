
package com.portfolio.PortfolioBackend.control;

import com.portfolio.PortfolioBackend.dto.RedSocialDTO;
import com.portfolio.PortfolioBackend.model.Persona;
import com.portfolio.PortfolioBackend.service.PersonaService;
import com.portfolio.PortfolioBackend.service.RedSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manuel Gutiérrez
 */
@CrossOrigin(origins = "http://localhost:4200/", exposedHeaders = {"Access-Control-Allow-Origin"})
@RestController
@RequestMapping(path = "/redesSociales")
public class RedSocialController {

    @Autowired
    private RedSocialService redServ;
    
    @Autowired
    private PersonaService persoRepo;
    
    @PutMapping("/editar")
    public ResponseEntity<?> editarRedSocial(@RequestBody RedSocialDTO rsDTO) {
        Persona p = this.persoRepo.traerPersona(rsDTO.getIdPersona());
        this.redServ.editarRedSocial(rsDTO, p);
        return new ResponseEntity("red social editada", HttpStatus.OK);
    }
    
    public ResponseEntity<?> borrarRedSocial(@RequestParam int id) {
        this.redServ.borrarRedSocial(id);
        return new ResponseEntity("red social borrada", HttpStatus.OK);
    }
    
}
