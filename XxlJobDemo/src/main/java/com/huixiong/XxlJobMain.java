package com.huixiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-07-29 11:07
 */
@SpringBootApplication
@RestController
public class XxlJobMain {
    public static void main(String[] args) {
        SpringApplication.run(XxlJobMain.class);
    }
    @GetMapping
    public String hello(){
        return "hello";
    }
}
