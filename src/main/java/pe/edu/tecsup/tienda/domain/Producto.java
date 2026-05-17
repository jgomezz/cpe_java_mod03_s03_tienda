package pe.edu.tecsup.tienda.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Producto {

    private Long id;
//    private CategoriaEntity categoria;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen_nombre;
    private String imagen_tipo;
    private Long imagen_tamanio;
    private Integer estado;
    private Date creado;
}
