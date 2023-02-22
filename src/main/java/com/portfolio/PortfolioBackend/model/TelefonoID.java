
package com.portfolio.PortfolioBackend.model;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class TelefonoID {

    private long telefono;
    private Persona personaTel;

    public TelefonoID() {
    }

    public TelefonoID(long telefono, Persona personaTel) {
        this.telefono = telefono;
        this.personaTel = personaTel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.telefono ^ (this.telefono >>> 32));
        hash = 97 * hash + Objects.hashCode(this.personaTel);
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
        final TelefonoID other = (TelefonoID) obj;
        if (this.telefono != other.telefono) {
            return false;
        }
        return Objects.equals(this.personaTel, other.personaTel);
    }
    
}
