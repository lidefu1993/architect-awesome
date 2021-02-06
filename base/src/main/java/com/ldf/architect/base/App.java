package com.ldf.architect.base;


/**
 * @author lidefu
 * @date 2018/12/25 8:55
 */
public class App {

    public static void main(String[] args) {
        Demo demo = new Demo();
    }

    public static class Demo{
        private int a;

        @Override
        public int hashCode(){
            System.out.println("hashcode");
            return 1;
        }
    }

    private static void max(){
        int a = Integer.MAX_VALUE;
        int b = a+1;
        System.out.println(b>a);
        System.out.println(b-a>0);
        System.out.println("a:" + a + ";b:" + b + ";b-a:" + (b-a));
    }

    private static void min(){
        int a = Integer.MIN_VALUE;
        int b = 10;
        System.out.println(a<b);
        System.out.println(a-b<0);
        System.out.println("a:" + a + ";b:" + b + ";a-b:" + (a-b));
    }


}
