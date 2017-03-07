package com.bigpao.com.service;

import com.bigpao.com.dao.CourseDao;
import com.bigpao.com.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hzdmm on 2017/3/6.
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
}
