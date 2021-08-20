package com.huixiong.controller;

import com.huixiong.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-19 17:53
 */
@RestController
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return service.greet();
    }
}
