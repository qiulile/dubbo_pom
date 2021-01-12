package cn.com.demo.test;

import cn.com.demo.dubbo.helloconsumer.controller.DemoController;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMain {
    public static void main(String[] args) throws Exception {
        String str = "{userName:'张三',age:'20'}";
        // User类的对象中 userName age
        String clsName = "cn.com.demo.dubbo.helloconsumer.controller.DemoController";
        // 获取指定类的Class
        Class cls = Class.forName(clsName);

        Constructor[] constructors = cls.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }

        Constructor defaultConstructor = cls.getConstructor(null);
        System.out.println(defaultConstructor);
        Object instance = defaultConstructor.newInstance(null);
        DemoController c = (DemoController) instance;
        System.out.println(c.hello);

        Field field = cls.getField("hello");
        Object value = field.get(c);
        System.out.println(value);

        Constructor c2 = cls.getConstructor(String.class);
        Object instance1 = c2.newInstance("王五");
        value = field.get(instance1);
        System.out.println(value);

        Constructor constructor = cls.getConstructor(String.class, int.class);
        Object zhaoliu = constructor.newInstance("zhaoliu", 20);
        value = field.get(zhaoliu);
        System.out.println(value);

        cls.newInstance();// 调用类的缺省构造器

        Method method = cls.getMethod("getHello", null);
        Object result = method.invoke(zhaoliu, null);
        System.out.println(result);
    }

    public static void testField() throws Exception {
        String clsName = "cn.com.demo.dubbo.helloconsumer.controller.DemoController";
        // 获取指定类的Class
        Class cls = Class.forName(clsName);
        // 获取Class中的信息
        // 成员变量
        Field[] fields = cls.getFields();
        fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
            //f.getInt(null);
        }

        // 测试获取hello成员的值(某个对象)
        DemoController controller = new DemoController();
        Field helloField = cls.getField("hello");
        Object obj = helloField.get(controller);
        System.out.println(obj);
        helloField.set(controller, "lisi");
        System.out.println(controller.getHello());
    }
}
