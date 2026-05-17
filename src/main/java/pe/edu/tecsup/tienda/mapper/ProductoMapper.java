package pe.edu.tecsup.tienda.mapper;

import pe.edu.tecsup.tienda.domain.Producto;
import pe.edu.tecsup.tienda.entities.ProductoEntity;

public class ProductoMapper {

    public static Producto toDomain(ProductoEntity entity) {

        return Producto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .stock(entity.getStock())
                .estado(entity.getEstado())
                .creado(entity.getCreado())
                .build();
    }

    public static ProductoEntity toEntity(Producto domain) {
        return ProductoEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .precio(domain.getPrecio())
                .stock(domain.getStock())
                .estado(domain.getEstado())
                .creado(domain.getCreado())
                .build();
    }
}
