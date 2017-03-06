package com.bigpao.com.controller.admin;

import com.bigpao.com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Modifier;

/**
 * Created by chen wang on 2017/3/2.
 */
@Controller
public class HomeController {

    @Autowired
    AdminService adminService;

    @Autowired
    TeachService teachService;

    @Autowired
    StuService stuService;

    @Autowired
    CourseService courseService;

    @Autowired
    CommentService commentService;


    /**
     * 管理员首页
     */
    @RequestMapping({"/admin/","/admin/index"})
    public String index(Model model){
        return "admin/index";
    }

    /**
     * 管理员列表
     * @param offsetPage
     * @param model
     * @return 返回管理员列表页面
     */
    @RequestMapping({"/admin/userlist/{offsetPage}"})
    public String getUserList(@PathVariable("offsetPage") int offsetPage,
                              Model model){
        model.addAttribute("adminNum",adminService.findAdminNumber());
        model.addAttribute("adminList",adminService.findLimitAdmin(offsetPage));
        model.addAttribute("offsetPage",offsetPage);
        return "admin/userlist";
    }

    /**
     * 教师列表
     * @param offsetPage
     * @param model
     * @return 返回教师列表页面
     */
    @RequestMapping({"/admin/teachlist/{offsetPage}"})
    public String getTeachList(@PathVariable("offsetPage") int offsetPage,
                              Model model){
        model.addAttribute("teachNum",teachService.findTeachNumber());
        model.addAttribute("teachList",teachService.findLimitTeach(offsetPage));
        model.addAttribute("offsetPage",offsetPage);
        return "admin/teachlist";
    }

    /**
     * 学生列表
     * @param offsetPage
     * @param model
     * @return 返回学生列表页面
     */
    @RequestMapping({"/admin/stulist/{offsetPage}"})
    public String getStuList(@PathVariable("offsetPage") int offsetPage,
                               Model model){
        model.addAttribute("stuNum",stuService.findStuNumber());
        model.addAttribute("stuList",stuService.findLimitStu(offsetPage));
        model.addAttribute("offsetPage",offsetPage);
        return "admin/stulist";
    }


    /**
     * 课程列表
     * @param offsetPage
     * @param model
     * @return 返回课程列表页面
     */
    @RequestMapping({"/admin/courselist/{offsetPage}"})
    public String getCourseList(@PathVariable("offsetPage") int offsetPage,
                             Model model){
        model.addAttribute("mapNum",courseService.findCourseNumber());
        model.addAttribute("mapList",courseService.findLimitCourse(offsetPage));
        model.addAttribute("offsetPage",offsetPage);
        return "admin/courselist";
    }


    /**
     * 评论列表
     * @param offsetPage
     * @param model
     * @return 返回评论列表页面
     */
    @RequestMapping({"/admin/commentlist/{offsetPage}"})
    public String getCommentList(@PathVariable("offsetPage") int offsetPage,
                                Model model){
        model.addAttribute("mapNum",commentService.findCommentNumber());
        model.addAttribute("mapList", commentService.findLimitComment(offsetPage));
        model.addAttribute("offsetPage",offsetPage);
        return "admin/commentlist";
    }

    @RequestMapping({"admin/deleteStu/{stuId}"})
    public String deleteStu(@PathVariable("stuId") int stuId){
        int result=stuService.deleteStuById(stuId);
        if(result>=0)
            return "redirect:/admin/stulist/0";
        else {
            //TODO
            return "";
        }
    }


}
