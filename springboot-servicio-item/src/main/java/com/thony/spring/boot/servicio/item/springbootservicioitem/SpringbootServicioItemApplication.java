package com.thony.spring.boot.servicio.item.springbootservicioitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


// @RibbonClient(name = "servicio-producto") // colocar el nombre del serivicio se conecta con feign y hacen valanceo carga
@EnableCircuitBreaker // de hystryx ayuda al monitore de errores
@EnableEurekaClient // ribbon ya esta integrado en eureka
@EnableFeignClients // netflix habilitar los clientes feigns y inyecta a estos controldores y spring
@SpringBootApplication
public class SpringbootServicioItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioItemApplication.class, args);
    }

}
