package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.CompanyCertificationDao;
import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.service.CompanyCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class CompanyCertificationServiceImpl implements CompanyCertificationService {

    @Autowired
    private CompanyCertificationDao dao;

    @Override
    public void adduser(Map map) {
        dao.adduser(map);
    }

    @Override
    public void uploadanouther(String s,Integer uid) {
        dao.uploadanouther(s,uid);
    }

    @Override
    public void businesslicense(String s, Integer uid) {
        dao.businesslicense(s,uid);
    }

    @Override
    public void upload(Map map1) {
        dao.upload(map1);
    }
}
