package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.tienda.entities.CategoriaEntity;

import java.util.List;

public interface CategoriaRepository
        extends JpaRepository<CategoriaEntity, Long> {

    List<CategoriaEntity> findAll();

}
