package com.huixiong.controller;

import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-19 14:11
 */
@RestController
@EnableAspectJAutoProxy
public class AopController {

    @GetMapping
    public String helloWorld(){
        return "hello World";
    }
}
