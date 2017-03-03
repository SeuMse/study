package com.bigpao.com.controller.admin;

import com.bigpao.com.service.AdminService;
import com.bigpao.com.service.TeachService;
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
}
