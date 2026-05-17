package pe.edu.tecsup.tienda.services;

import pe.edu.tecsup.tienda.entities.ProductoEntity;

import java.util.List;

public interface ProductoService {

    List<ProductoEntity> findAll();

    List<ProductoEntity> findByName(String nombre);

    ProductoEntity findById(Long id);

    void save(ProductoEntity producto);

    void deleteById(Long id);

    void update(ProductoEntity producto);
}
