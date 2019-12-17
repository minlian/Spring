package com.minlian.aop;

import com.minlian.aop.cglib.CGLibProxy;
import com.minlian.aop.jdkproxy.DynamicProxy;
import com.minlian.aop.service.Person;
import com.minlian.aop.service.PersonImpl;
import com.minlian.aop.service.Speakable;


public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        //获取被代理接口实例对象
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy() {
        CGLibProxy cglibProxy = CGLibProxy.getInstance();
        // 通过代理对象调用目标方法
        Person proxy = cglibProxy.getProxy(Person.class);
        return proxy;
    }

}
