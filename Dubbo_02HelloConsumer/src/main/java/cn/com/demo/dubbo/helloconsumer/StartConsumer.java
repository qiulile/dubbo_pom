package cn.com.demo.dubbo.helloconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"cn.com.demo.dubbo.helloconsumer.controller"})
public class StartConsumer {
    public static void main(String[] args) {
        SpringApplication.run(StartConsumer.class, args);
    }
}
