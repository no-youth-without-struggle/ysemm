package com.aaa.ysemm.manage.controller;

import java.math.BigDecimal;

/**
 * fileName:TestDemo
 * description:
 * author:yangjunling
 * createTime:2019/8/10 16:12
 * version:1.0.0
 */
public class TestDemo {
    public static void main(String[] args) {
        BigDecimal decimal=new BigDecimal(5);
        BigDecimal decimal2=new BigDecimal(5);
        BigDecimal subtract = decimal.subtract(decimal2);
        System.out.println(subtract);
    }
}
