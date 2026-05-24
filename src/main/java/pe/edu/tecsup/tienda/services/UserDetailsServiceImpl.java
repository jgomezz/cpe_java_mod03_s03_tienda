package pe.edu.tecsup.tienda.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.repositories.UsuarioRepository;


@AllArgsConstructor
@Service
public class UserDetailsServiceImpl  implements UserDetailsService  {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserDetails userDetails
                = this.usuarioRepository.loadUserByUsername(username);
        if(userDetails == null)
            throw new UsernameNotFoundException("Usuario no encontrado");

        return userDetails;

    }

}
