package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.customer.entity.Loans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FkMapper {

    List<Map> queryFK();
    List<Map> queryZj();

    Map getLoan(Integer id);

    void updateMoney(BigDecimal money);

    void updateComMoney(Map map);

    void insertNodes(Map map);

    void updateLoans(Integer cid);

    void insertRepayment(Map map);
}
