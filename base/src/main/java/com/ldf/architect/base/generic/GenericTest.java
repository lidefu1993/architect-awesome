package com.ldf.architect.base.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lidefu
 * @date 2019/10/16 8:39
 */
public class GenericTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Method[] methods = list.getClass().getMethods();
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list, "test");
        Object a1 = list.get(1);
        Integer b2 = list.get(1);
    }



}
