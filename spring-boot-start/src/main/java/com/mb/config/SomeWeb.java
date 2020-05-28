package com.mb.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author mobingchao
 * @time 2020/5/28 11:11
 */
@Component
public class SomeWeb {

    private final RestTemplateBuilder restTemplateBuilder;

    /**
     * 只要你的项目使用了 Spring MVC 就已经集成了RestTemplate。
     * 但是通常情况下该类不会自动被注入 Spring IoC容器，因为很多 Rest API 都具有特殊性，
     * 为了更加灵活的进行定制，其构建类 RestTemplateBuilder被自动注入了 Spring IoC 容器。
     */
    public SomeWeb(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    /**
     * 最佳实践：针对每一个第三方服务尽量定制对应的 RestTemplate，尽量不公用，除非这些第三方的流程完全一致。
     */
    @Bean
    public RestTemplate restTemplate() {
        // 通过 builder 定制
        /**
         * 默认情况下，RestTemplate 使用 java.net.HttpURLConnection 作为实现，一但使用它时有异常响应状态（比如 401），就会引发异常，因此我们一般不使用它。
         * 我们可以切换到 Netty 、Apache HttpComponents、okHttp 默认实现的客户端库。
         * 参考 下面的 requestFactory(ClientHttpRequestFactory factory) 接入方法，
         * 也可以自行实现 ClientHttpRequestFactory 对接其它第三方库进行接入。这里我使用 okHttp。
         * 你可以定制这些第三方库提供的特性丰富你的 RestTemplate，比如设置请求超时。
         */
        return restTemplateBuilder.requestFactory(OkHttp3ClientHttpRequestFactory::new).
                build();
    }
}
