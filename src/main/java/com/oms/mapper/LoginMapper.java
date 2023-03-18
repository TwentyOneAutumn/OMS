package com.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oms.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<SysUser> {
}
