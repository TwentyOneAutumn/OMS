package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsUser;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.UserDetailVo;
import com.oms.domain.vo.UserListVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IOmsUserService extends IService<OmsUser> {

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    Row<String> toLoginCheck(LoginCheckDto dto, HttpServletResponse response);

    /**
     * 验证Token
     *
     * @param request 请求对象
     * @return 状态
     */
    boolean toTokenCheck(HttpServletRequest request, HttpServletResponse response);

    TableInfo<UserListVo> toList(UserListDto dto);

    Row<UserDetailVo> toDetail(UserDetailDto dto);

    AjaxResult toAdd(UserAddDto dto);

    AjaxResult toEdit(UserEditDto dto);

    AjaxResult toDelete(UserDeleteDto dto);
}
