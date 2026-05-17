package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.tienda.entities.Producto;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

    List<Producto> findByNombre(String name);


    /*
    List<Producto> findAll();

    List<Producto> findByName(String name);


    void save(Producto producto);

    void update(Producto producto);

    void deleteById(Long id);
*/
}


