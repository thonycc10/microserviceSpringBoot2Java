package com.thony.spring.boot.servicio.item.springbootservicioitem.models.service;

import com.thony.spring.boot.servicio.item.springbootservicioitem.clientes.ProductoClienteRest;
import com.thony.spring.boot.servicio.item.springbootservicioitem.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("ItemServiceFeign") // se le añade nombre para identifcar con qualifier
@Primary // identifica que es lo primero servicio que se usara si tienes dos similares
public class ItemServiceFeign implements ITemService{

    @Autowired
    private ProductoClienteRest clientefeign;

    @Override
    public List<Item> findAll() {
        return clientefeign.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clientefeign.findById(id), cantidad);
    }
}
