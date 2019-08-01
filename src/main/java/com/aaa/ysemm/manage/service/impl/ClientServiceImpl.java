package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.manage.dao.ClientDao;
import com.aaa.ysemm.manage.entity.Company;
import com.aaa.ysemm.manage.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;
    @Override
    public List<Map> queryClinet(Map map) {
        return clientDao.queryClinet(map);
    }

    @Override
    public int queryPage(Map map) {
        return clientDao.queryPage(map);
    }

    @Override
    public int update(Map  map) {
        return clientDao.update(map);
    }
}
