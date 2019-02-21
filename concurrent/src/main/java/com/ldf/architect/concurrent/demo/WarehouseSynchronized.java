package com.ldf.architect.concurrent.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 仓库
 * @author lidefu
 * @date 2019/2/18 17:38
 */
public class WarehouseSynchronized {

    /**
     * 仓库：只有非空的时候允许取 未满的时候允许放
     * 多线程下的存放问题
     *
     */

    private static final List<String> WARE_HOUSE = new ArrayList<>(5);

    public static void take(){
        if (WARE_HOUSE.size() == 0){
            System.out.println("当前仓库为空");
            return;
        }
        synchronized (WARE_HOUSE){
            String result = WARE_HOUSE.get(0);
            WARE_HOUSE.remove(0);
            System.out.println("取出：" + result);
        }
        System.out.println("---------------------------------------------------");
    }

    public static void pull(){
        synchronized (WARE_HOUSE){
            if(WARE_HOUSE.size() == 5){
                System.out.println("添加失败，仓库已满");
            }else {
                WARE_HOUSE.add(String.valueOf(Math.random()));
                System.out.println("添加成功");
            }
            System.out.println("当前仓库数量：" + WARE_HOUSE.size() + "； " + WARE_HOUSE);
        }
        System.out.println("---------------------------------------------------");
    }



}
