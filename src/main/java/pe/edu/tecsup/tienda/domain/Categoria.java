package pe.edu.tecsup.tienda.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Categoria {

    private Long id;
    private String nombre;
    private Integer orden;
//    private List<ProductoEntity> productos;
}
