package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2019-4-10 11:29
 * @Created by CrazyStone
 */
@Controller
public class LoginController {
    /**
     * 获取并封装当前年份跳转到登录页login.html
     * @param model
     * @return
     */
    @GetMapping("/toLoginPage")
    public String toLoginPage(Model model){
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
