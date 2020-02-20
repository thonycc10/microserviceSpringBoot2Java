package com.thony.springboot.app.productos.springbootservicioproductos.models.servicio;

import com.thony.springboot.app.productos.springbootservicioproductos.models.entity.Producto;

import java.util.List;

public interface IProductosService {

    public List<Producto> findAll();

    public Producto findById(Long id);
}
