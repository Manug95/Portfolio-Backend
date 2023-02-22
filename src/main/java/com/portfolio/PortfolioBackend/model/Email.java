

package com.portfolio.PortfolioBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Manuel Gutiérrez
 */
@Entity
@Table(name = "emails")
@IdClass(EmailID.class)
@Getter
@Setter
public class Email {
    
    @Id
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona personaEmail;

    public Email() {
    }
    
    public Email(String email, Persona personaEmail) {
        this.email = email;
        this.personaEmail = personaEmail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.email);
        hash = 79 * hash + Objects.hashCode(this.personaEmail);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.personaEmail, other.personaEmail);
    }
    
}
