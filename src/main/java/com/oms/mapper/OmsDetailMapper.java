package com.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oms.domain.OmsDetail;
import com.oms.domain.OmsUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OmsDetailMapper extends BaseMapper<OmsDetail> {
}
