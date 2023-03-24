package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsUser;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.domain.dto.TokenCheckDto;

public interface IOmsUserService extends IService<OmsUser> {

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    AjaxResult toLoginCheck(LoginCheckDto dto);

    /**
     * 验证Token
     *
     * @param dto 数据对象
     * @return 状态
     */
    boolean toTokenCheck(TokenCheckDto dto);
}
