package com.thony.springboot.app.productos.springbootservicioproductos.models.controller;

import com.thony.springboot.app.productos.springbootservicioproductos.models.entity.Producto;
import com.thony.springboot.app.productos.springbootservicioproductos.models.servicio.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private Environment environment;

    @Value("${server.port}") // conecta con el aplicationproporties
    private Integer port;

    @Autowired
    private IProductosService iProductosService;

    @GetMapping("/productos")
    public List<Producto> list()  {
        return iProductosService.findAll().stream().map(producto -> {
          // producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/productos/{id}")
    public Producto findById(@PathVariable Long id) {
        Producto producto = iProductosService.findById(id);
       // producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
       // Testa hystrix boolean ok = false;
       // if (ok == false) {
       //     throw new Exception("Oh NO!");
       // }
        producto.setPort(port);
       // try {
       //     Thread.sleep(2000L);
       // } catch (InterruptedException e) {
       //     e.printStackTrace();
       // }
        return producto;
    }

}
