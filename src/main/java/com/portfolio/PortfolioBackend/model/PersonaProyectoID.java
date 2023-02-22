

package com.portfolio.PortfolioBackend.model;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class PersonaProyectoID implements Serializable {

    private Persona personaProy;
    private Proyecto proyecto;

    public PersonaProyectoID() {
    }

    public PersonaProyectoID(Persona personaProy, Proyecto proyecto) {
        this.personaProy = personaProy;
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.personaProy);
        hash = 53 * hash + Objects.hashCode(this.proyecto);
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
        final PersonaProyectoID other = (PersonaProyectoID) obj;
        if (!Objects.equals(this.personaProy, other.personaProy)) {
            return false;
        }
        return Objects.equals(this.proyecto, other.proyecto);
    }
    
}
