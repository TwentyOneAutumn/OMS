package com.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.SysUser;
import com.oms.mapper.LoginMapper;
import com.oms.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, SysUser> implements ILoginService {
}
