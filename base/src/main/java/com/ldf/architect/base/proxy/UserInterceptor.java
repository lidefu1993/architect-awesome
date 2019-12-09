//package com.ldf.architect.base.proxy;
//
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * @author lidefu
// * @date 2019/9/25 9:10
// */
//public class UserInterceptor implements MethodInterceptor {
//    @Override
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        System.out.println("cglib 代理");
//        return proxy.invokeSuper(obj, args);
//    }
//}
