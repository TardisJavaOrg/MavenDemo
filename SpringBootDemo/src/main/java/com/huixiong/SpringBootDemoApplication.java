package com.huixiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-06-30 16:33
 */
@SpringBootApplication
@RestController
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class);
    }

    @GetMapping
    public String hello(){
        return "hello";
    }
}
