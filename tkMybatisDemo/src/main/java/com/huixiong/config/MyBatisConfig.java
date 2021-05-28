package com.huixiong.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author timothy
 * @data 2021年05月28日 10:46 上午
 */
@Configuration
@MapperScan("com.huixiong.mapper")
public class MyBatisConfig {
}
