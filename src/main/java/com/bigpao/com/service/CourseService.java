package com.bigpao.com.service;

import com.bigpao.com.dao.CourseDao;
import com.bigpao.com.model.Course;
import com.bigpao.com.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chen wang on 2017/3/3.
 */
@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;

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
