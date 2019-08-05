package com.aaa.ysemm.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String year="year";
    public static String Month="Month";
    public static String week="week";
    public static String day="day";
    public static String hours="hours";
    public static String minute="minute";
    public static String seconds="seconds";
    public static String milliseconds="milliseconds";



    //当前时间
    private static Date now =new Date();
   private static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 计算年份
     */
    public static String addDate(String type,int num){
        String time=null;

        //计算年
        if ("year".equals(type)){
            //当前时间
           time = sd.format(DateUtils.addYears(now, num));
        }
        //计算月
        if ("Month".equals(type)){
            time = sd.format(DateUtils.addMonths(now, num));
        }
        //计算周
        if ("week".equals(type)){
            time = sd.format(DateUtils.addWeeks(now, num));
        }
        //计算天
        if ("day".equals(type)){
            time = sd.format(DateUtils.addDays(now, num));
        }
        //计算小时
        if ("hours".equals(type)){
            time = sd.format(DateUtils.addHours(now, num));
        }
        //计算分钟
        if ("minute".equals(type)){
            time = sd.format(DateUtils.addMinutes(now, num));
        }
        //计算秒
        if ("seconds".equals(type)){
            time = sd.format(DateUtils.addSeconds(now, num));
        }
         //计算毫秒
        if ("milliseconds".equals(type)){
            time = sd.format(DateUtils.addMilliseconds(now, num));
        }
        return time;
    }
    /**
     * 日期格式的运算
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("脚本之家测试结果：");
        Date now = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("------当前时间--------：" + sd.format(now));
        //年: 加、减操作
        System.out.println("1年之后："+sd.format(DateUtils.addYears(now, 1)));
        System.out.println("1年之前："+sd.format(DateUtils.addYears(now, -1)));
        //月: 加、减操作
        System.out.println("1个月之后："+sd.format(DateUtils.addMonths(now, 1)));
        System.out.println("1个月之前："+sd.format(DateUtils.addMonths(now, -1)));
        //周: 加、减操作
        System.out.println("1周之后："+sd.format(DateUtils.addWeeks(now, 1)));
        System.out.println("1周之前："+sd.format(DateUtils.addWeeks(now, -1)));
        //天: 加、减操作
        System.out.println("昨天的这个时候：" + sd.format(DateUtils.addDays(now, -1)));
        System.out.println("明天的这个时候：" + sd.format(DateUtils.addDays(now, 1)));
        //小时: 加、减操作
        System.out.println("1小时后：" + sd.format(DateUtils.addHours(now, 1)));
        System.out.println("1小时前：" + sd.format(DateUtils.addHours(now, -1)));
        //分钟: 加、减操作
        System.out.println("1分钟之后："+sd.format(DateUtils.addMinutes(now, 1)));
        System.out.println("1分钟之前："+sd.format(DateUtils.addMinutes(now, -1)));
        //秒: 加、减操作
        System.out.println("10秒之后："+sd.format(DateUtils.addSeconds(now, 10)));
        System.out.println("10秒之前："+sd.format(DateUtils.addSeconds(now, -10)));
        //毫秒: 加、减操作
        System.out.println("1000毫秒之后："+sd.format(DateUtils.addMilliseconds(now, 1000)));
        System.out.println("1000毫秒之前："+sd.format(DateUtils.addMilliseconds(now, -1000)));
    }
}
