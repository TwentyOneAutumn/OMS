package com.oms.controller;

import com.oms.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 验证登录
     * @return 状态
     */
    @GetMapping("/check")
    public AjaxResult toCheck(){
        return AjaxResult.success();
    }
}
