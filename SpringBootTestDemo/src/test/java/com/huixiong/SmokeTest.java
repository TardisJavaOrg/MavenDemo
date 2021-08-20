package com.huixiong;

import static org.assertj.core.api.Assertions.assertThat;
import com.huixiong.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 冒烟测试
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-19 15:51
 */
@SpringBootTest
public class SmokeTest {
//
    @Autowired
    private HomeController homeController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(homeController).isNotNull();
    }

}
