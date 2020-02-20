package com.thony.spring.boot.servicio.item.springbootservicioitem.clientes;

import com.thony.spring.boot.servicio.item.springbootservicioitem.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @FeignClient(name = "servicio-items", url = "localhost:8080")
// usando ribben se quita el localhost y se añade en aplication propertis
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
// esto es otra opcion mas rapida en ves de usar RestTemplate
    @GetMapping("/api/productos")
    public List<Producto> findAll();

    @GetMapping("/api/productos/{id}")
    public Producto findById(@PathVariable Long id);
}
