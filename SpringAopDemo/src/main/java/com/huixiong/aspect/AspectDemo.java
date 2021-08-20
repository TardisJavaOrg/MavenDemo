package com.huixiong.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-19 14:42
 */
@Aspect
@Component
public class AspectDemo {

    @Before("execution(public * com.huixiong.controller.AopController.*(..))")
    public void before(){
        System.out.println("before");
    }
    @After("execution(public * com.huixiong.controller.AopController.*(..))")
    public void after(){
        System.out.println("after");
    }

}
