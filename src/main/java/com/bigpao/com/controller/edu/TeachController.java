package com.bigpao.com.controller.edu;

import com.bigpao.com.service.CourseService;
import com.bigpao.com.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chen wang on 2017/3/6.
 */
@Controller
public class TeachController {
    @Autowired
    TeachService teachService;

    @Autowired
    CourseService courseService;

    /**
     * 教师列表
     * @param model
     * @return 返回教师列表页面
     */
    @RequestMapping({"/teachlist"})
    public String getTeachList(Model model){
        //model.addAttribute("teachNum",teachService.findTeachNumber());
        model.addAttribute("teachList",teachService.findTeach());
        //model.addAttribute("offsetPage",offsetPage);
        return "teachList";
    }

    /**
     * 教师页面
     * @param teachId
     * @param model
     * @return  返回教师页面
     */
    @RequestMapping({"/teacher/{teachId}"})
    public String getTeach(@PathVariable("teachId") int teachId, Model model){
        model.addAttribute("teach",teachService.selectTeachById(teachId));
        model.addAttribute("courseList",courseService.findCourseByTeachId(teachId));
        return "teacher";
    }
}
