package com.oms.controller;

import com.oms.domain.dto.TokenCheckDto;
import com.oms.service.IOmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 页面跳转
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    IOmsUserService userService;

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
    public String toIndex(@Valid TokenCheckDto dto){
        return userService.toTokenCheck(dto) ? "index" : "login";
    }

    /**
     * 用户界面
     * @return user.html
     */
    @GetMapping("/user")
    public String toUser(@Valid TokenCheckDto dto){
        return userService.toTokenCheck(dto) ? "user" : "login";
    }

    /**
     * 饲养界面
     * @return feeding.html
     */
    @GetMapping("/feeding")
    public String toFeeding(@Valid TokenCheckDto dto){
        return userService.toTokenCheck(dto) ? "feeding" : "login";
    }

    /**
     * 收支界面
     * @return transaction.html
     */
    @GetMapping("/transaction")
    public String toTransaction(@Valid TokenCheckDto dto){
        return userService.toTokenCheck(dto) ? "transaction" : "login";
    }

    /**
     * 疫苗界面
     * @return vaccine.html
     */
    @GetMapping("/vaccine")
    public String toVaccine(@Valid TokenCheckDto dto){
        return userService.toTokenCheck(dto) ? "vaccine" : "login";
    }
}
