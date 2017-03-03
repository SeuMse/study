package com.bigpao.com.service.admin;

import com.bigpao.com.dao.AdminDao;
import com.bigpao.com.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzdmm on 2017/3/2.
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public List<Admin> findAdminByadminIdAndadminPassword(String adminName, String adminPassword){
       // return adminDao.findAdminByadminNameAndadminPassword(adminName,adminPassword);
        return  adminDao.findAdminByadminNameAndadminPassword(adminName,adminPassword);
    }

}
