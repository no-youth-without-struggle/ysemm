package com.aaa.ysemm.manage.service;

import java.util.List;
import java.util.Map;

public interface FkService {

    List<Map> queryFK();

    List<Map> queryZj();

    Map loanMoney(Integer cid);
}
