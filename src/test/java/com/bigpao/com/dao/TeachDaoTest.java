package com.bigpao.com.dao;

import com.bigpao.com.StudyApplication;
import com.bigpao.com.model.Teach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen wang on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudyApplication.class)
public class TeachDaoTest {
    @Autowired
    TeachDao teachDao;

    /**
     * TeachDao.insertTeach(Teach teach)测试
     */
    @Test
    public void insertTest(){
        Teach teach=new Teach();
        teach.setTeachEmail("1323432432");
        teach.setTeachHeadurl("adasdasdas");
        teach.setTeachIntroduce("adffsdasd");
        teach.setTeachName("asfasds");
        teachDao.insertTeach(teach);
    }

    /**
     * TeachDao.selectTeachs()测试
     */
    @Test
    public void selectTest(){
        teachDao.selectTeachs();
    }



    /**
     * TeachDao.updateTeach(Teach teach)测试
     */
    @Test
    public void updateTest(){
        Teach teach=new Teach();
        teach.setTeachId(1);
        teach.setTeachEmail("1323432432");
        teach.setTeachHeadurl("ada");
        teach.setTeachIntroduce("adfasd");
        teach.setTeachName("asds");
        teachDao.updateTeach(teach);
    }


    /**
     * TeachDao.deleteTeach(Teach teach)测试
     */
    @Test
    public void delete(){
        Teach teach=new Teach();
        teach.setTeachId(1);
        teachDao.deleteTeach(teach);
    }

    /**
     * TeachDao.getTeachNumber()测试
     */
    @Test
    public void getTeachNumberTest(){
        teachDao.getTeachNumber();
    }


    /**
     * TeachDao.selectLimitTeach(int offset,int limit)测试
     */
    @Test
    public void selectLimitTeachTest(){
        teachDao.selectLimitTeach(0,10);
    }


    /**
     * TeachDao.selectTeachById(int teachId)测试
     */
    @Test
    public void selectTeachById(){
        teachDao.selectTeachById(1);
    }
}
