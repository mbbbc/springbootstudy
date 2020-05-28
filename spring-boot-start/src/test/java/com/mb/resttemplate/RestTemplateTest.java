package com.mb.resttemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author mobingchao
 * @time 2020/5/28 11:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetForEntity() {
        String url = "https://api.apiopen.top/getImages?page=0&count=5";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        System.out.println("body = " + body);
    }


}
