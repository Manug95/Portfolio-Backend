

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
@Table(name = "telefonos")
@Getter
@Setter
@IdClass(TelefonoID.class)
public class Telefono {

    @Id
    @Column(name = "telefono", nullable = false)
    private long telefono;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona personaTel;

    public Telefono() {
    }
    
    public Telefono(long telefono, Persona personaTel) {
        this.telefono = telefono;
        this.personaTel = personaTel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.telefono ^ (this.telefono >>> 32));
        hash = 53 * hash + Objects.hashCode(this.personaTel);
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
        final Telefono other = (Telefono) obj;
        if (this.telefono != other.telefono) {
            return false;
        }
        return Objects.equals(this.personaTel, other.personaTel);
    }
    
}
