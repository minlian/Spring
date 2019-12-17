package com.minlian.aop.cglib;

import com.minlian.aop.monitor.MonitorSession;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance() {
        return instance;
    }

    // 通过CGLIB动态代理获取代理对象的过程
    private Enhancer enhancer = new Enhancer();

    //通过代理对象调用目标方法
    public  <T> T getProxy(Class<T> clazz) {
        // 设置enhancer对象的父类
        enhancer.setSuperclass(clazz);
        // 设置enhancer的回调对象
        enhancer.setCallback(this);
        // 创建代理对象
        return (T) enhancer.create();
}

    /**
     * arg0：cglib生成的代理对象
     * arg1：被代理对象方法
     * arg2：方法入参
     * arg3: 代理方法
     * */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2,
                            MethodProxy arg3) throws Throwable {
        MonitorSession.begin(arg1.getName());
        Object obj = arg3.invokeSuper(arg0, arg2);
        MonitorSession.end();
        return obj;
    }
}
