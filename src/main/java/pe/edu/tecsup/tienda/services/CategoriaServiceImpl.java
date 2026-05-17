package pe.edu.tecsup.tienda.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.CategoriaEntity;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> findAll() {

        log.info("Iniciando búsqueda de categorias");

        return this.categoriaRepository.findAll();

    }
}
