package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(exclude = "productos")
@Entity
@Table(name="categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "orden")
    private Integer orden;

    @OneToMany(mappedBy  = "categoria")
    private List<ProductoEntity> productos;

}
