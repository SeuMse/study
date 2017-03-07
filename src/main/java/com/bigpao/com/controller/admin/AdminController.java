package com.bigpao.com.controller.admin;

import com.bigpao.com.model.Admin;
import com.bigpao.com.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hzdmm on 2017/3/2.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService AdminService;

    @RequestMapping(path="/admin/login")
    public String  login(){
        return "login";
    }


   @RequestMapping(path={"/admin/CheckLogin"})
   @ResponseBody
    public String adminLogincheck(
            @RequestParam(value = "adminName",required = false) String adminName,
            @RequestParam(value = "password",required = false) String password)
   {
        if (StringUtils.isNotBlank(adminName)&&StringUtils.isNotBlank(password)){
            List<Admin> list = AdminService.findAdminByadminIdAndadminPassword(adminName,password);
            if (list!=null && list.size()>0){//To跳转页面
                return "loginToUI";
            }
        }
        return "loginFailed";
    }

    @ExceptionHandler
    @ResponseBody
    public String error(Exception e){
                return "代码问题请联系裴佳祥管理员";
    }

}
