package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname FilmeController
 * @Description TODO
 * @Date 2019-3-5 13:45
 * @Created by CrazyStone
 */
@Controller
public class FilmeController {
    //  影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type")String type, @PathVariable("path")String path) {
        return "detail/"+type+"/"+path;
    }

    // 向用户登录页面跳转
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }
}

