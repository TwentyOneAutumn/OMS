package com.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oms.domain.OmsTransaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OmsTransactionMapper extends BaseMapper<OmsTransaction> {
}
