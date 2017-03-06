package com.bigpao.com.service;

import com.bigpao.com.dao.AdminDao;
import com.bigpao.com.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chen wang on 2017/3/2.
 */
@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    /**
     * 分页查询管理员
     * @param offset  偏移值
     * @return List<Admin>
     */
    public List<Admin> findLimitAdmin(int offset){
        int limit=10;
        return adminDao.selectLimitAdmin(offset*limit,limit);
    }

    /**
     * 查询管理员的数量
     * @return int
     */
    public int findAdminNumber(){
        return adminDao.getAdminNumber();
    }


    public List<Admin> findAdminByadminIdAndadminPassword(String adminName, String adminPassword){
        // return adminDao.findAdminByadminNameAndadminPassword(adminName,adminPassword);
        return  adminDao.findAdminByadminNameAndadminPassword(adminName,adminPassword);
    }
}
