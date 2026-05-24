package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name="roles")
public class Rol  implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Metodos de GrantedAuthority

    @Override
    public String getAuthority() {
        return this.nombre;
    }


}
