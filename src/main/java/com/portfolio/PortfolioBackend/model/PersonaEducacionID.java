

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
//@Embeddable
@Getter
@Setter
public class PersonaEducacionID implements Serializable {

    //@Column(name = "id_educacion")
    private Educacion educacion;
    
    //@Column(name = "id_persona")
    private Persona estudiante;
    
    //---------------------------------------------------------------CONSTRUCTORES----------------------------------------------------------

    public PersonaEducacionID() {
    }

    public PersonaEducacionID(Educacion educacion, Persona estudiante) {
        this.educacion = educacion;
        this.estudiante = estudiante;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.educacion);
        hash = 29 * hash + Objects.hashCode(this.estudiante);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonaEducacionID other = (PersonaEducacionID) obj;
        if (!Objects.equals(this.educacion, other.educacion)) {
            return false;
        }
        return Objects.equals(this.estudiante, other.estudiante);
    }

    
    
}
