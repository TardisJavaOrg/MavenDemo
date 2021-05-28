package com.huixiong;

import com.huixiong.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

/**
 * @author timothy
 * @data 2021年05月28日 10:39 上午
 */
@SpringBootApplication
@RestController
public class TkMybatisMain {
    public static void main(String[] args) {
        SpringApplication.run(TkMybatisMain.class);
    }


    @GetMapping
    public void test() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", 1);

    }
}
