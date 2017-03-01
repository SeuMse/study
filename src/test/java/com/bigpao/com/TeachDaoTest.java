package com.bigpao.com;

import com.bigpao.com.dao.TeachDao;
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

    @Test
    public void insertTest(){
        Teach teach=new Teach();
        teach.setTeachEmail("1323432432");
        teach.setTeachHeadurl("adasdasdas");
        teach.setTeachIntroduce("adffsdasd");
        teach.setTeachName("asfasds");
        teachDao.insertTeach(teach);
    }

    @Test
    public void selectTest(){
        teachDao.selectTeachs();
    }

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

    @Test
    public void delete(){
        Teach teach=new Teach();
        teach.setTeachId(1);
        teachDao.deleteTeach(teach);
    }
}
