package com.huixiong.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-19 15:44
 */
@RestController
public class HomeController {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
}
