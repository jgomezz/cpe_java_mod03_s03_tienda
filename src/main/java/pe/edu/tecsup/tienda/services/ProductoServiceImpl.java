package pe.edu.tecsup.tienda.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.ProductoEntity;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> findAll() {
        log.info("Iniciando búsqueda de productos");
        return this.productoRepository.findAll();
    }

    @Override
    public List<ProductoEntity> findByName(String nombre) {
        log.info("call findByName()");
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public ProductoEntity findById(Long id) {
        log.info("call findById()");

        Optional<ProductoEntity> prod = productoRepository.findById(id);

        if (prod.isPresent()) {
            return prod.get();
        } else {
            throw new RuntimeException("ProductoEntity no encontrado");
        }

    }

    @Override
    public void save(ProductoEntity producto) {
        log.info("call save()");
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        log.info("call deleteById()");
        productoRepository.deleteById(id);
    }

    @Override
    public void update(ProductoEntity producto) {
        log.info("call update()");
        productoRepository.save(producto);
    }

}
