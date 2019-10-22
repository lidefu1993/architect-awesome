package com.ldf.architect.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lidefu
 * @date 2019/9/25 7:41
 */
public class UserHandler implements InvocationHandler {

    private Object instance;

    public UserHandler(Object instance){
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk before---");
        Object object = method.invoke(instance, args);
        System.out.println("jdk after---");
        return object;
    }

    public Object proxyInstance(){
        return Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), this);
    }

}
