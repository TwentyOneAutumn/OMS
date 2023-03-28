package com.oms.controller;

import com.oms.domain.Build;
import com.oms.domain.Row;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.service.IOmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class OmsUserController extends Build {

    @Autowired
    private IOmsUserService loginService;

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    @GetMapping("/loginCheck")
    public Row<String> toLoginCheck(@Valid LoginCheckDto dto){
        return loginService.toLoginCheck(dto);
    }
}