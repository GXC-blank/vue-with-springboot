package net.evecom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@MapperScan(basePackages = {"net.evecom.mapper"})
@SpringBootApplication
public class DarknessApplication {

    public static void main(String[] args) {
        SpringApplication.run(DarknessApplication.class, args);
    }

}
