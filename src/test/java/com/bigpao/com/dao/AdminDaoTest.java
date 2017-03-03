package com.bigpao.com.dao;

import com.bigpao.com.StudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen wang on 2017/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudyApplication.class)
public class AdminDaoTest {

    @Autowired
    AdminDao adminDao;

    /**
     * AdminDao.getAdminNumber()测试
     */
    @Test
    public void adminNumberTest(){
        adminDao.getAdminNumber();
    }


    /**
     * AdminDao.selectLimitAdmin测试
     */
    @Test
    public void selectLimitAdminTest(){
        adminDao.selectLimitAdmin(0,10);
    }

}
