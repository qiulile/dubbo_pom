package cn.com.demo.dubbo.hello.service.impl;

import cn.com.demo.dubbo.hello.service.IHello;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloImpl implements IHello {

    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }


}
