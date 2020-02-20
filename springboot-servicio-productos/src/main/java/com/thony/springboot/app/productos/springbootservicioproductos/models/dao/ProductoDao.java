package com.thony.springboot.app.productos.springbootservicioproductos.models.dao;

import com.thony.springboot.app.productos.springbootservicioproductos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
