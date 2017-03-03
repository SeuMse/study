package com.bigpao.com.dao;

import com.bigpao.com.StudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chen wang on 2017/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudyApplication.class)
public class CourseDaoTest {
    @Autowired
    CourseDao courseDao;

    /**
     * CourseDao.getCourseNumber()测试
     */
    @Test
    public void CourseNumberTest(){
        courseDao.getCourseNumber();
    }


    /**
     * CourseDao.selectLimitCourse测试
     */
    @Test
    public void selectLimitCourseTest(){
        System.out.println(courseDao.selectLimitCourse(0,10));
    }
}
