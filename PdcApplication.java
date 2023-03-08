package com.dcg.pdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdcApplication.class, args);
    }

}
