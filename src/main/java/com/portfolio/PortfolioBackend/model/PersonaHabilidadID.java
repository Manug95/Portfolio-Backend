

package com.portfolio.PortfolioBackend.model;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class PersonaHabilidadID {

    private Persona personaHab;
    private Habilidad habilidad;

    public PersonaHabilidadID() {
    }

    public PersonaHabilidadID(Persona personaHab, Habilidad habilidad) {
        this.personaHab = personaHab;
        this.habilidad = habilidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.personaHab);
        hash = 29 * hash + Objects.hashCode(this.habilidad);
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
        final PersonaHabilidadID other = (PersonaHabilidadID) obj;
        if (!Objects.equals(this.personaHab, other.personaHab)) {
            return false;
        }
        return Objects.equals(this.habilidad, other.habilidad);
    }
    
}
