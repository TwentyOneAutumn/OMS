package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.Build;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.UserDetailVo;
import com.oms.domain.vo.UserListVo;
import com.oms.service.IOmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class OmsUserController extends Build {

    @Autowired
    private IOmsUserService userService;

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    @GetMapping("/loginCheck")
    public Row<String> toLoginCheck(@Valid LoginCheckDto dto, HttpServletResponse response){
        return userService.toLoginCheck(dto,response);
    }


    /**
     * 查询列表
     *
     * @return TableInfo
     */
    @GetMapping("/list")
    public TableInfo<UserListVo> toList(UserListDto dto){
        return userService.toList(dto);
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/detail")
    public Row<UserDetailVo> toDetail(@Valid UserDetailDto dto){
        return userService.toDetail(dto);
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @PostMapping("/add")
    public AjaxResult toAdd(@Valid @RequestBody UserAddDto dto){
        return userService.toAdd(dto);
    }

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @PutMapping("/edit")
    public AjaxResult toEdit(@Valid @RequestBody UserEditDto dto){
        return userService.toEdit(dto);
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @DeleteMapping("/delete")
    public AjaxResult toDelete(@Valid @RequestBody UserDeleteDto dto){
        return userService.toDelete(dto);
    }
}