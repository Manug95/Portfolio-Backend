
package com.portfolio.PortfolioBackend.security.jwt;

import com.portfolio.PortfolioBackend.utils.Mensaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Gutiérrez
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        
        Mensaje.error("Error en la clase JwtEntryPoint - metodo commence");
        System.out.println(authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no está autorizado");
        
    }
    
}
