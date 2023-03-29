package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.AjaxResult;
import com.oms.domain.Build;
import com.oms.domain.OmsUser;
import com.oms.domain.Row;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.domain.dto.TokenCheckDto;
import com.oms.mapper.OmsUserMapper;
import com.oms.service.IOmsUserService;
import com.oms.utils.JwtUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class OmsUserServiceImpl extends ServiceImpl<OmsUserMapper, OmsUser> implements IOmsUserService {

    /**
     * 验证登录
     *
     * @param dto 数据对象
     * @return 状态
     */
    @Override
    public Row<String> toLoginCheck(LoginCheckDto dto, HttpServletResponse response) {
        int count = count(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, dto.getAccount())
                .eq(OmsUser::getPassword, dto.getPassword())
        );
        response.setHeader("token",JwtUtil.getToken(dto.getAccount(),dto.getPassword()));
        response.setHeader("account",dto.getAccount());
        return count == 1 ? Build.buildRow(JwtUtil.getToken(dto.getAccount(),dto.getPassword())) : Build.buildRow(false);
    }

    /**
     * 验证Token
     *
     * @param request 请求对象
     * @param response 响应对象
     * @return 状态
     */
    @Override
    public boolean toTokenCheck(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        String account = request.getHeader("account");
        OmsUser user = getOne(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, account)
        );
        if(BeanUtil.isNotEmpty(user)){
            response.setHeader("token",token);
            response.setHeader("account",account);
            return JwtUtil.verifyToken(token,user.getUserAccount(),user.getPassword());
        }
        return false;
    }
}
