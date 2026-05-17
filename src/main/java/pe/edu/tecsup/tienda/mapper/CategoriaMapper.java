package pe.edu.tecsup.tienda.mapper;

import pe.edu.tecsup.tienda.domain.Categoria;
import pe.edu.tecsup.tienda.entities.CategoriaEntity;

public class CategoriaMapper {

    public static Categoria toDomain(CategoriaEntity entity) {

        return Categoria.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .orden(entity.getOrden())
                .build();
    }

    public static CategoriaEntity toEntity(Categoria domain) {
        return CategoriaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .orden(domain.getOrden())
                .build();
    }
}
