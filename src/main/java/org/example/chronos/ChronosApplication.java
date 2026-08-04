package org.example.chronos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChronosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChronosApplication.class, args);
    }

    //GET /api/v1/health
    @GetMapping("/api/v1/health")
    public String health(){
        return "OK";
    }

}
