package com.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oms.domain.OmsDetail;
import com.oms.domain.OmsFeeding;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OmsFeedingMapper extends BaseMapper<OmsFeeding> {
}
