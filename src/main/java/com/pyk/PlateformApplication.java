package com.pyk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pyk.mapper")
public class PlateformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlateformApplication.class, args);
    }

}
