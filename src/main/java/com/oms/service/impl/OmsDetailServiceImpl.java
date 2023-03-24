package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsDetail;
import com.oms.domain.OmsUser;
import com.oms.domain.dto.DetailListDto;
import com.oms.domain.dto.LoginCheckDto;
import com.oms.domain.dto.TokenCheckDto;
import com.oms.domain.vo.DetailListVo;
import com.oms.mapper.OmsDetailMapper;
import com.oms.mapper.OmsUserMapper;
import com.oms.service.IOmsDetailService;
import com.oms.service.IOmsUserService;
import com.oms.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsDetailServiceImpl extends ServiceImpl<OmsDetailMapper, OmsDetail> implements IOmsDetailService {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public List<DetailListVo> toList(DetailListDto dto) {
        LambdaQueryWrapper<OmsDetail> wrapper = new LambdaQueryWrapper<OmsDetail>()
                .isNotNull(OmsDetail::getVaccineId);
        String variety = dto.getVariety();
        String source = dto.getSource();
        if(StrUtil.isNotEmpty(variety)){
            wrapper.like(OmsDetail::getVariety,variety);
        }
        if(StrUtil.isNotEmpty(source)){
            wrapper.like(OmsDetail::getVariety,source);
        }
        List<OmsDetail> list = list(wrapper);
        List<DetailListVo> voList = BeanUtil.copyToList(list, DetailListVo.class);
        voList.forEach(vo -> {
            // 处理购买价格
            vo.setBuyingPrice(89);
            // 处理疫苗状态
            vo.setIsVaccine(true);
            // 处理饲养状态
            vo.setIsFeeding(true);
        });
        return voList;
    }
}
