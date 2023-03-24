
package com.portfolio.PortfolioBackend.security.jwt;

import com.portfolio.PortfolioBackend.security.service.UserDetailsServiceImpl;
import com.portfolio.PortfolioBackend.utils.Mensaje;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Manuel Gutiérrez
 */
public class JwtTokenFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtProvider jwtProvider;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        try {
            String token = this.getToken(request);
            
            if (token != null && this.jwtProvider.validarToken(token)) {//System.out.println("token valido");
                String nombreUsuario = this.jwtProvider.getNombreUsuarioFromToken(token);//System.out.println("nombreUsuario: " + nombreUsuario);
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = 
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //System.out.println("isAuthenticated: " + auth.isAuthenticated());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            
        }
        catch (Exception e) {
            Mensaje.mensajeCatch(e, "Fallo el metodo doFilter");
        }
        
        filterChain.doFilter(request, response);
        
    }
    
    private String getToken(HttpServletRequest request) {
        
        String header = request.getHeader("Authorization");
        
        if (header != null && header.startsWith("Bearer")) {
            header = header.replace("Bearer ", "");
            return header;
        } else {
            return null;
        }
        
    }
    
}
