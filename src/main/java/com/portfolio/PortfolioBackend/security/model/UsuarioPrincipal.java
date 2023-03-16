
package com.portfolio.PortfolioBackend.security.model;

import com.portfolio.PortfolioBackend.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Manuel Gutiérrez
 */
public class UsuarioPrincipal implements UserDetails {

    private String nombreUsuario;
    private String contrasenia;
    private Collection<? extends GrantedAuthority> authorities;
    
    //-----------------------------------------------------------------CONSTRUCTORES------------------------------------------------------------
    
    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(String nombreUsuario, String contrasenia, Collection<? extends GrantedAuthority> authorities) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.authorities = authorities;
    }
    
    public static UsuarioPrincipal build(Usuario usuario) {
        
//        List<GrantedAuthority> authorities = usuario.getRoles()
//                .stream()
//                .map( rol -> new SimpleGrantedAuthority(
//                        rol
//                        .getRolNombre()
//                ))
//                .collect(Collectors.toList());

        ArrayList<Rol> list = new ArrayList<>();
        
        for (Rol r : usuario.getRoles()) {
            list.add(r);
        }

        List<GrantedAuthority> authorities = list.stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre())).collect(Collectors.toList());
        
        return new UsuarioPrincipal(usuario.getNombreUsuario(), usuario.getContrasena(), authorities);
    }
    
    private static List<Rol> setToList(Set<Rol> set) {
        ArrayList<Rol> list = new ArrayList<>();
        
        for (Rol r : set) {
            list.add(r);
        }
        
        return list;
        
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.contrasenia;
    }

    @Override
    public String getUsername() {
        return this.nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
