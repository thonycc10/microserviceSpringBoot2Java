package com.thony.spring.boot.servicio.item.springbootservicioitem.models.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thony.spring.boot.servicio.item.springbootservicioitem.models.Item;
import com.thony.spring.boot.servicio.item.springbootservicioitem.models.Producto;
import com.thony.spring.boot.servicio.item.springbootservicioitem.models.service.ITemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("ItemServiceFeign")
    private ITemService iTemService;

    @GetMapping("/items")
    public List<Item> list() {

        return iTemService.findAll();
    }

   // @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item findById(@PathVariable Long id, @PathVariable Integer cantidad) {
        return iTemService.findById(id, cantidad);
    }

    public Item metodoAlternativo(Long id, Integer cantidad) {
        Item item = new Item();
        Producto producto = new Producto();
        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(600.00);
        item.setProducto(producto);
        return item;
    }

}
