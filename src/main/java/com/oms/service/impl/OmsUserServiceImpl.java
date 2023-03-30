package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
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
import com.oms.utils.CookieUtils;
import com.oms.utils.JwtUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;

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
        if(count == 1){
            String token = JwtUtil.getToken(dto.getAccount(), dto.getPassword());
            response.setHeader("token",token);
            response.setHeader("account",dto.getAccount());
            return Build.buildRow(token);
        }else {
            return Build.buildRow(false);
        }
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
        String token = CookieUtils.get(request, "token");
        String account = CookieUtils.get(request, "account");
        if(StrUtil.isEmpty(token) || StrUtil.isEmpty(account)){
            return false;
        }
        OmsUser user = getOne(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, account)
        );
        if(BeanUtil.isNotEmpty(user)){
            boolean verifyToken = JwtUtil.verifyToken(token, user.getUserAccount(), user.getPassword());
            if(verifyToken){
                HashMap<String, String> map = new HashMap<>();
                map.put("token",token);
                map.put("account",account);
                CookieUtils.set(response,map);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
