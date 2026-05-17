package pe.edu.tecsup.tienda.services;

import pe.edu.tecsup.tienda.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    List<Producto> findByName(String nombre);

    Producto findById(Long id);

    void save(Producto producto);

    void deleteById(Long id);

    void update(Producto producto);
}
