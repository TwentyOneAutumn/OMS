package com.oms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 */
@Controller
@RequestMapping("/page")
public class PageCotroller {

    /**
     * 登录界面
     * @return login.html
     */
    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    /**
     * 首页
     * @return index.html
     */
    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }


    /**
     * 登录界面
     * @return login.html
     */
    @GetMapping("/table")
    public String toTable(){
        return "table";
    }

    /**
     * 登录界面
     * @return login.html
     */
    @GetMapping("/blog")
    public String toBlogx(){
        return "blog";
    }

    /**
     * 登录界面
     * @return login.html
     */
    @GetMapping("/docs")
    public String toDocs(){
        return "docs";
    }

    /**
     * 登录界面
     * @return login.html
     */
    @GetMapping("/landing")
    public String toLanding(){
        return "landing";
    }

    /**
     * 登录界面
     * @return login.html
     */
    @GetMapping("/starter-template")
    public String toStarterTemplate(){
        return "starter-template";
    }
}
