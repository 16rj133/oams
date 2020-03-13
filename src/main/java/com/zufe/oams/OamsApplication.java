package com.zufe.oams;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zufe.oams.mapper")
public class OamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OamsApplication.class, args);
    }

}