package com.ldf.arithmetic.other;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 最大在线人数 及其区间
 */
public class MaxOnlineNum {

    /**
     * 提供给你一天内   每个人的登录时间和退出时间。  写个程序算出来同时在线人数最多的时间段
     * 时间段最小粒度秒
     */

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateInit = dateFormat.parse("2021-01-29 00:00:00");
        Date date = dateFormat.parse("2021-01-29 01:00:03");

        System.out.println(5400/3600);

        long secondInit = dateInit.getSeconds();
        long second = date.getSeconds();
        System.out.println(second-secondInit);
        List<UserOnlineTime> list = case1();
        max(list);

    }

    public static void max(List<UserOnlineTime> userOnlineTimes){
        //初始化数组 每秒对应数组的一个元素
        int length = 3600*24;
        int[] seconds = new int[length];
        //遍历用户的登入登出时间，登入时间对应的索引位+1， 登出时间对应的索引位-1
        for(UserOnlineTime time : userOnlineTimes){
            int loginInSecond = time.loginInSecond;
            seconds[loginInSecond] = seconds[loginInSecond]+1;
            int logoutSecond = time.logoutSecond;
            seconds[logoutSecond] = seconds[logoutSecond]-1;
        }
        //定义最大连续子数组的移动指针
        int begin=0;
        int max = 0, temp=0;
        //定义最大连续子数组对应的指针
        int maxBegin=0, maxEnd=0;
        //转化为求最大连续子数组
        for(int i=0; i<seconds.length; i++){
            if((temp = temp+seconds[i]) <= seconds[i]){
                //若当前连续子数组最大值f(n-1)+当前值 < 当前值 说明f(n-1)为负数 起到反作用 初始指针赋值为当前索引
                begin=i;
                temp = seconds[i];
            }
            //判断当前连续子数组的最大值是否超过了之前已记录的最大值
            if(max<temp){
                max = temp;
                maxBegin = begin;
                maxEnd = i;
            }
        }
        System.out.println("最大在线人数："+max + "; 开始时间：" + secondRevert(maxBegin) + ",结束时间：" + secondRevert(maxEnd));

    }


    public static class UserOnlineTime{
        private String loginTime;
        private String logoutTime;

        private int loginInSecond;
        private int logoutSecond;

        public UserOnlineTime(String loginTime, String logoutTime){
            this.loginTime = logoutTime;
            this.logoutTime = logoutTime;
            this.loginInSecond = seconds(dateFormat(loginTime));
            this.logoutSecond = seconds(dateFormat(logoutTime));
        }
    }


    public static int seconds(Date date){
        return date.getHours()*3600 + date.getMinutes()*60 + date.getSeconds();
    }

    public static String secondRevert(int seconds){
        int hour = seconds/3600;
        seconds = seconds-hour*3600;
        int minute = seconds/60;
        seconds = seconds-minute*60;
        return hour+":"+minute+":"+seconds;
    }


    public static Date dateFormat(String dateStr){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<UserOnlineTime> case1(){
        List<UserOnlineTime> list = new ArrayList<>();
        list.add(new UserOnlineTime("2021-01-29 01:01:22", "2021-01-29 01:05:22"));
        list.add(new UserOnlineTime("2021-01-29 01:11:22", "2021-01-29 02:01:12"));
        list.add(new UserOnlineTime("2021-01-29 02:01:22", "2021-01-29 09:01:22"));
        list.add(new UserOnlineTime("2021-01-29 03:01:22", "2021-01-29 09:01:22"));
        return list;
    }

}
