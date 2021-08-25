package com.huixiong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-24 18:59
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    public String hello(){
        return "hello admin";
    }
}
