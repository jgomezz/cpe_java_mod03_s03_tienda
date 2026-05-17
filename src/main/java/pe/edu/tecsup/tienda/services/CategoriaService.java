package pe.edu.tecsup.tienda.services;

import pe.edu.tecsup.tienda.entities.CategoriaEntity;

import java.util.List;

public interface CategoriaService {

    List<CategoriaEntity> findAll();
}
