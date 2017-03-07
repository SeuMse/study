package com.bigpao.com.dao;

import com.bigpao.com.StudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hzdmm on 2017/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudyApplication.class)
public class courseDaoTest {
    @Autowired
    public CourseDao courseDao;
    @Test
    public void insertTest(){
        System.out.println(courseDao.seleceAllCourse().size());
        //courseDao.seleceAllCourse();
    }
}
