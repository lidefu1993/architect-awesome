package com.ldf.architect.base.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author lidefu
 * @date 2019/9/25 7:46
 */
public class ProxyTest {

    public static void main(String[] args) {

        cglibProxy();

//        jdkProxy();
    }

    private static void jdkProxy(){
        UserHandler handler = new UserHandler(new UserServiceImpl());
        UserService userService = (UserService) handler.proxyInstance();
        System.out.println(userService instanceof Proxy);
        System.out.println(userService instanceof UserService);
        userService.getAge();
        userService.getName();
    }

    private static void cglibProxy(){
        UserInterceptor proxy = new UserInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(proxy);
        UserServiceImpl user = (UserServiceImpl) enhancer.create();
        user.getAge();
        System.out.println(1);
    }


}
