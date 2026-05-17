package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(exclude = "categoria")
@Entity
@Table(name="productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long categorias_id;
    @ManyToOne
    @JoinColumn(name="categorias_id")
    private CategoriaEntity categoria;

    // findBy

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen_nombre;
    private String imagen_tipo;
    private Long imagen_tamanio;
    private Integer estado;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creado;

}