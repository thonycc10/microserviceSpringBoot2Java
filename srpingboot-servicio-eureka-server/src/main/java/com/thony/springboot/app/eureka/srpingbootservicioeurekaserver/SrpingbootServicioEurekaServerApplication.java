package com.thony.springboot.app.eureka.srpingbootservicioeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SrpingbootServicioEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrpingbootServicioEurekaServerApplication.class, args);
    }

}
