package com.bigpao.com.controller.edu;

import com.bigpao.com.model.Course;
import com.bigpao.com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hzdmm on 2017/3/6.
 */
@Controller
public class CourseController {


    @Autowired
    public CourseService courseService;
    /**
     * 课程列表
     *
     * @param
     * @param
     * @return 返回课程列表页面
     */
    @RequestMapping({"/courselist/{courseSort}"})
    public String getCourseList(@PathVariable("courseSort") String courseSort, Model model){
        List<Course> courseList;
        if (courseSort.isEmpty()){
           courseList = courseService.findCourseList();
        }else {
             courseList = courseService.findCourseListBySort(courseSort);
        }
        model.addAttribute("courseList",courseList);
        return "admin/lesson";
    }
    @RequestMapping({"/courselist"})
    public String getCourseList( Model model){
        List<Course> courseList;

        courseList = courseService.findCourseList();

        model.addAttribute("courseList",courseList);
        return "admin/lesson";
    }

}
