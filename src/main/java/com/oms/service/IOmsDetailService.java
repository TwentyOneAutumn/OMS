package com.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsDetail;
import com.oms.domain.OmsUser;
import com.oms.domain.dto.DetailListDto;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.domain.dto.TokenCheckDto;
import com.oms.domain.vo.DetailListVo;

import java.util.List;

public interface IOmsDetailService extends IService<OmsDetail> {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    List<DetailListVo> toList(DetailListDto dto);
}
