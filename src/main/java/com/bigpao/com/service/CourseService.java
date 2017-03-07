package com.bigpao.com.service;

import com.bigpao.com.dao.CourseDao;
import com.bigpao.com.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hzdmm on 2017/3/6.
=======
import com.bigpao.com.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chen wang on 2017/3/3.
>>>>>>> seu/hzdmm123
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    /**
     *
     * @return 返回所有的课程list
     */
    public List<Course> findCourseList(){
        return courseDao.seleceAllCourse();
    }

    public List<Course> findCourseListBySort(String courseSort){
        return courseDao.findCourseListBySort(courseSort);
    }


    /**
     * 分页查询课程
     * @param offset  偏移值
     * @return List<Course>
     */
    public List<HashMap> findLimitCourse(int offset){
        int limit=10;
        return courseDao.selectLimitCourse(offset*limit,limit);
    }

    /**
     * 查询课程的数量
     * @return int
     */
    public int findCourseNumber(){
        return courseDao.getCourseNumber();
    }


}
