package com.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jianjun1.wang
 */
@EnableSwagger2
@SpringBootApplication
public class BaseDebugApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseDebugApplication.class, args);
    }

}
