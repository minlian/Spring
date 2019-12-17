package com.minlian.aop;

import com.minlian.aop.cglib.CGLibProxy;
import com.minlian.aop.jdkproxy.DynamicProxy;
import com.minlian.aop.service.Person;
import com.minlian.aop.service.PersonImpl;
import com.minlian.aop.service.Speakable;


public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy() {
        CGLibProxy cglibProxy = CGLibProxy.getInstance();
        Person proxy = cglibProxy.getProxy(Person.class);
        return proxy;
    }

}
