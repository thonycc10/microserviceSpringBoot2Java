package com.thony.spring.boot.servicio.item.springbootservicioitem.models.service;

import com.thony.spring.boot.servicio.item.springbootservicioitem.models.Item;

import java.util.List;

public interface ITemService {

    public List<Item> findAll();

    public Item findById(Long id, Integer cantidad);
}
