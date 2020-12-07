package com.ldf.architect.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldf
 * @date 2020/12/6 14:17
 **/
public class MockListDataService {

    public List<Integer> test(int begin, int end){
        List<Integer> list = new ArrayList<>();
        for(int i=begin; i<=end; i++){
            System.out.println("sssssssssssssss:" + i);
            if(i>begin+1){
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(i);
        }
        return list;
    }

}
