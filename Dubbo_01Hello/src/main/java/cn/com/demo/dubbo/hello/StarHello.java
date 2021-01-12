package cn.com.demo.dubbo.hello;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"cn.com.demo.dubbo.hello.service.impl"})
@PropertySource("classpath:/dubbo.properties")
public class StarHello {
    public static void main(String[] args) {
        SpringApplication.run(StarHello.class, args);
    }
}
