package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.tienda.entities.ProductoEntity;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity> findByNombre(String name);


    /*
    List<ProductoEntity> findAll();

    List<ProductoEntity> findByName(String name);


    void save(ProductoEntity producto);

    void update(ProductoEntity producto);

    void deleteById(Long id);
*/
}


