package pe.edu.tecsup.tienda.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        log.info("Iniciando búsqueda de productos");
        return this.productoRepository.findAll();
    }

    @Override
    public List<Producto> findByName(String nombre) {
        log.info("call findByName()");
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public Producto findById(Long id) {
        log.info("call findById()");

        Optional<Producto> prod = productoRepository.findById(id);

        if (prod.isPresent()) {
            return prod.get();
        } else {
            throw new RuntimeException("Producto no encontrado");
        }

    }

    @Override
    public void save(Producto producto) {
        log.info("call save()");
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        log.info("call deleteById()");
        productoRepository.deleteById(id);
    }

    @Override
    public void update(Producto producto) {
        log.info("call update()");
        productoRepository.save(producto);
    }

}
