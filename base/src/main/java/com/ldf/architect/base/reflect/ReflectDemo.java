package com.ldf.architect.base.reflect;

import java.lang.reflect.Method;

/**
 * @author ldf
 * @date 2019/9/24 19:45
 **/
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(InnerClass.class.getName());
        Method[] methods = aClass.getMethods();
        Method method = methods[0];
        Object instance = aClass.newInstance();
        System.out.println(methods.length);
    }

    static class InnerClass{
        public void test1(){
            System.out.println("test1");
        }

        protected void test2(){
            System.out.println("test2");
        }

        private void test3(){
            System.out.println("test3");
        }

        public static void test4(){
            System.out.println("test4");
        }
    }

}
