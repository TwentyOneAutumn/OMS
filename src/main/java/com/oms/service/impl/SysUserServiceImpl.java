package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsUser;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.domain.dto.TokenCheckDto;
import com.oms.mapper.LoginMapper;
import com.oms.service.ISysUserService;
import com.oms.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<LoginMapper, OmsUser> implements ISysUserService {

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    @Override
    public AjaxResult toLoginCheck(LoginCheckDto dto) {
        int count = count(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, dto.getAccount())
                .eq(OmsUser::getPassword, dto.getPassword())
        );
        return count == 1 ? AjaxResult.success(JwtUtil.getToken(dto.getAccount(),dto.getPassword())) : AjaxResult.error();
    }

    /**
     * 验证Token
     *
     * @param dto 数据对象
     * @return 状态
     */
    @Override
    public boolean toTokenCheck(TokenCheckDto dto) {
        OmsUser user = getOne(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, dto.getAccount())
        );
        if(BeanUtil.isNotEmpty(user)){
            return JwtUtil.verifyToken(dto.getToken(),user.getUserAccount(),user.getPassword());
        }
        return false;
    }
}
