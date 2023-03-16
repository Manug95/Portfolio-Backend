
package com.portfolio.PortfolioBackend.security.jwt;

import com.portfolio.PortfolioBackend.security.model.UsuarioPrincipal;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Gutiérrez
 */
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication auth) {
        
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) auth.getPrincipal();
        
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date( new Date().getTime() + this.expiration*1000 ))
                .signWith(SignatureAlgorithm.HS512, this.secret.getBytes())
                .compact();
    }
    
    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(this.secret.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    public boolean validarToken(String token) {
        
        try {
//            System.out.println("firmado: " + Jwts.parser().setSigningKey(this.secret.getBytes()).parsePlaintextJws(token) );
            Jwts.parser().setSigningKey(this.secret.getBytes()).parseClaimsJws(token);
            
            return true;
        }
        catch (ExpiredJwtException ee) {
            Mensaje.mensajeCatch(ee, "Token expirado");
        }
        catch (UnsupportedJwtException ue) {
            Mensaje.mensajeCatch(ue, "Token no soportado");
        }
        catch (MalformedJwtException me) {
            Mensaje.mensajeCatch(me, "Token mal formado");
        }
        catch (IllegalArgumentException iae) {
            Mensaje.mensajeCatch(iae, "Token vacío");
        }
        catch (SignatureException se) {
            Mensaje.mensajeCatch(se, "Fallo en la firma del Token");
        }
        
        return false;
        
    }
    
//    private Key getSecret(String secret) {
//        byte[] secretBytes = Decoders
//    }
    
}
