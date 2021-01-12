package cn.com.demo.dubbo.helloconsumer.controller;

import cn.com.demo.dubbo.hello.service.IHello;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
public class DemoController extends ParentController {
    public String hello = "张三";
    public int age;
    @Reference
    private IHello helloService;

    public DemoController() {
    }

    public DemoController(String hello) {
        this.hello = hello;
    }

    public DemoController(String hello, int age) {
        this.hello = hello;
        this.age = age;
    }

    public String getHello() {
        return hello;
    }

    @GetMapping("/say")
    public String say(String name) {
        return this.helloService.hello(name);
    }
}
