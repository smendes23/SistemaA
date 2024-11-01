package br.com.ambev.sistemaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SistemaAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaAApplication.class, args);
    }

}
