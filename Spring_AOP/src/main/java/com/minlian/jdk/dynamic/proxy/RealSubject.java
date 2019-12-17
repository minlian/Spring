package com.minlian.jdk.dynamic.proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }
}
