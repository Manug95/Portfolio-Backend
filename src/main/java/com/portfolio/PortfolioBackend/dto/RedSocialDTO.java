
package com.portfolio.PortfolioBackend.dto;

/**
 * @author Manuel Gutiérrez
 */
public class RedSocialDTO {

    private int idRedSocial;
    private int idPersona;
    private String resSocial;
    
    //---------------------------------------------------------------CONSTRUCTORES--------------------------------------------------------------

    public RedSocialDTO() {
    }

    public RedSocialDTO(int idRedSocial, int idPersona, String resSocial) {
        this.idRedSocial = idRedSocial;
        this.idPersona = idPersona;
        this.resSocial = resSocial;
    }
    
    //---------------------------------------------------------------GETTERS & SETTERS----------------------------------------------------------

    public int getIdRedSocial() {
        return idRedSocial;
    }

    public void setIdRedSocial(int idRedSocial) {
        this.idRedSocial = idRedSocial;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getResSocial() {
        return resSocial;
    }

    public void setResSocial(String resSocial) {
        this.resSocial = resSocial;
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idRedSocial;
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
        final RedSocialDTO other = (RedSocialDTO) obj;
        return this.idRedSocial == other.idRedSocial;
    }
    
    
    
}
