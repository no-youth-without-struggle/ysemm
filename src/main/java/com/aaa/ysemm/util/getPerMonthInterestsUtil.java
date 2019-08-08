package com.aaa.ysemm.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class getPerMonthInterestsUtil {
    //按月付息到期還本

    /**
     * 按月付息，到期還本-計算獲取還款方式為按月付息，到期還本的每月償還利息
     * <p>
     * 公式：每月應還利息=總借款額*年利率÷還款月數
     *
     * @param invest     總借款額（貸款本金）
     * @param yearRate   年利率
     * @param totalMonth 還款總月數
     * @return 每月償還利息
     */
    public static double getPerMonthInterests(double invest, double yearRate, int totalMonth) {
        BigDecimal monthIncome = new BigDecimal(invest).multiply(new BigDecimal(yearRate)).divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_DOWN);
        return monthIncome.doubleValue();
    }

    /**
     * 按月付息，到期還本計算獲取還款方式為按月付息，到期還本的每月償還利息，最後一個月歸還利息+本金
     * <p>
     * 公式：每月償還利息=(總借款額*年利率÷還款月數)
     *
     * @param invest     總借款額（貸款本金）
     * @param yearRate   年利率
     * @param totalMonth 還款總月數
     * @return 每月償還利息, 不四捨五入，直接擷取小數點最後兩位
     */
    public static Map<Integer, Double> getPerMonthPrincipalInterests(double invest, double yearRate, int totalMonth) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        // 每月利息
        double monthPri = getPerMonthInterests(invest, yearRate, totalMonth);
        for (int i = 1; i <= totalMonth; i++) {
            if (i == totalMonth) {
                //最後一期 利息+ 本金
                monthPri = monthPri + invest;
            }
            map.put(i, monthPri);
        }
        return map;
    }

}
