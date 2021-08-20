package com.huixiong;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-19 17:10
 */
@SpringBootTest
public class HttpRequestTest {

    @Value("${server.port}")
    private String port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        this.restTemplate.getForObject("http://localhost:" + port + "/",String.class);
        Assertions.assertThat(restTemplate).isNotNull();
    }
}
