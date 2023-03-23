package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.domain.dto.TokenCheckDto;
import com.oms.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService loginService;

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    @GetMapping("/loginCheck")
    public AjaxResult toLoginCheck(@Valid LoginCheckDto dto){
        return loginService.toLoginCheck(dto);
    }
}