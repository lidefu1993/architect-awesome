package com.ldf.architect.base.init;

/**
 * @author lidefu
 * @date 2019/7/10 12:51
 */
public class Son extends Base{

    public int i = 2;

    public Son(){
        System.out.println(" son ");
        print();
    }

    @Override
    public void print(){
        System.out.println(" son i:" + i);
    }

    public static void main(String[] args) {
        new Son();
    }

}
