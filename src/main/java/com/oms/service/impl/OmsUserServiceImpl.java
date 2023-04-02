package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oms.domain.*;
import com.oms.domain.dto.*;
import com.oms.domain.vo.FeedingDetailVo;
import com.oms.domain.vo.UserDetailVo;
import com.oms.domain.vo.UserListVo;
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
import java.util.List;

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
        OmsUser user = getOne(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, dto.getAccount())
                .eq(OmsUser::getPassword, dto.getPassword())
        );
        if(BeanUtil.isNotEmpty(user)){
            String token = JwtUtil.getToken(dto.getAccount(), dto.getPassword());
            response.setHeader("token",token);
            response.setHeader("account",dto.getAccount());
            response.setHeader("isAdmin",String.valueOf("admin".equals(user.getUserName())));
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
                map.put("isAdmin",String.valueOf("admin".equals(user.getUserName())));
                CookieUtils.set(response,map);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public TableInfo<UserListVo> toList(UserListDto dto) {
        if(BeanUtil.isEmpty(dto.getPageSize())){
            return Build.buildTable("pageSize参数不能为空");
        }
        if(BeanUtil.isEmpty(dto.getPageNum())){
            return Build.buildTable("pageNum参数不能为空");
        }
        Page<Object> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<OmsUser> list = list(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getRole, false)
        );
        return Build.buildTable(page.getPages(),BeanUtil.copyToList(list,UserListVo.class));
    }

    @Override
    public Row<UserDetailVo> toDetail(UserDetailDto dto) {
        if(StrUtil.isEmpty(dto.getId())){
            return Build.buildRow(false,"id参数不能为空");
        }
        OmsUser pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            return Build.buildRow(false,"数据不存在");
        }
        UserDetailVo vo = BeanUtil.copyProperties(pojo, UserDetailVo.class);
        return Row.success(vo);
    }

    @Override
    public AjaxResult toAdd(UserAddDto dto) {
        if(StrUtil.isEmpty(dto.getUserName())){
            return AjaxResult.error("用户名不能为空");
        }
        if(StrUtil.isEmpty(dto.getUserAccount())){
            return AjaxResult.error("账号不能为空");
        }
        if(StrUtil.isEmpty(dto.getPassword())){
            return AjaxResult.error("密码不能为空");
        }
        OmsUser pojo = BeanUtil.toBean(dto, OmsUser.class);
        int count = count(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserAccount, dto.getUserAccount())
                .or()
                .eq(OmsUser::getUserName, dto.getUserName())
        );
        if(count > 0){
            return AjaxResult.error("用户名或账号已存在");
        }
        pojo.setRole(false);
        return save(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    @Override
    public AjaxResult toEdit(UserEditDto dto) {
        if(StrUtil.isEmpty(dto.getId())){
            return AjaxResult.error("id参数不能为空");
        }
        if(StrUtil.isEmpty(dto.getPassword())){
            return AjaxResult.error("密码不能为空");
        }
        if(BeanUtil.isEmpty(getById(dto.getId()))){
            return AjaxResult.error("数据不存在");
        }
        OmsUser pojo = BeanUtil.toBean(dto, OmsUser.class);
        return updateById(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    @Override
    public AjaxResult toDelete(UserDeleteDto dto) {
        if(StrUtil.isEmpty(dto.getId())){
            return AjaxResult.error("id参数不能为空");
        }
        String id = dto.getId();
        if(BeanUtil.isEmpty(getById(id))){
            return AjaxResult.error("数据不存在");
        }
        return removeById(id) ? AjaxResult.success() : AjaxResult.error();
    }
}
