

package com.portfolio.PortfolioBackend.security.jwt;

import static com.portfolio.PortfolioBackend.security.enums.RolNombre.ROLE_USER;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Gutiérrez
 */
@Component
public class JwtToken {

    //@Value("${jwt.secret}")
    private String secretKey = "portfoliorabioso";
    //@Value("${jwt.expiration}")
    private int expiration = 86400;
    
    public String getJWTToken(String username) {
        
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        
//                        .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                       .builder()
                       .setSubject(username)
                       .setIssuedAt(new Date(System.currentTimeMillis()))
                       .setExpiration(new Date(System.currentTimeMillis() + this.expiration * 1000))
                       .signWith(SignatureAlgorithm.HS512, this.secretKey.getBytes()).compact();

        return /*"Bearer " + */token;
    }
    
}
