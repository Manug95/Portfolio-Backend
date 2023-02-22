

package com.portfolio.PortfolioBackend.model;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Getter
@Setter
public class EmailID {

    private String email;
    private Persona personaEmail;

    public EmailID() {
    }

    public EmailID(String email, Persona personaEmail) {
        this.email = email;
        this.personaEmail = personaEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.personaEmail);
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
        final EmailID other = (EmailID) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.personaEmail, other.personaEmail);
    }
    
}
