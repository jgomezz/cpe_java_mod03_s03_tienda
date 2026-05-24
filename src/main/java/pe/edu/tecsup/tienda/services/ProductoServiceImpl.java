package pe.edu.tecsup.tienda.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.tienda.domain.Producto;
import pe.edu.tecsup.tienda.entities.ProductoEntity;
import pe.edu.tecsup.tienda.mapper.ProductoMapper;
import pe.edu.tecsup.tienda.repositories.ProductoRepository;

import java.util.Date;
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

        List<ProductoEntity> productosEntity = this.productoRepository.findAll();

        /*
        List<Producto> productos = new ArrayList<>();

        for (ProductoEntity entity : productosEntity) {
            Producto producto = ProductoMapper.toDomain(entity);
            productos.add(producto);
        }
        */

        List<Producto> productos = productosEntity.stream()
                .map(ProductoMapper::toDomain)
                .toList();

        return productos;
    }

    @Override
    public List<ProductoEntity> findByName(String nombre) {
        log.info("call findByName()");
        return productoRepository.findByNombre(nombre);
    }

    @Override
    public Producto findById(Long id) {
        log.info("call findById()");

        Optional<ProductoEntity> prod = productoRepository.findById(id);

        if (prod.isPresent()) {
            return ProductoMapper.toDomain(prod.get());
        } else {
            throw new RuntimeException("ProductoEntity no encontrado");
        }

    }

    @Override
    public void save(Producto producto) {
        log.info("call save()");

        // Defino valores por defecto
        producto.setCreado(new Date());
        producto.setEstado(1); // ACTIVO

        // Mapper
        ProductoEntity productoEntity = ProductoMapper.toEntity(producto);

        productoRepository.save(productoEntity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("call deleteById()");
        productoRepository.deleteById(id);
    }

    @Override
    public void update(Producto producto) {
        log.info("call update()");

        ProductoEntity productoEntity = ProductoMapper.toEntity(producto);

        productoRepository.save(productoEntity);
    }

}
