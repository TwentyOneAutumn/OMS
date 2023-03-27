package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsVaccine;
import com.oms.domain.Row;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.mapper.OmsVaccineMapper;
import com.oms.service.IOmsVaccineService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 疫苗ServiceImpl
 */
@Service
public class OmsVaccineServiceImpl extends ServiceImpl<OmsVaccineMapper, OmsVaccine> implements IOmsVaccineService {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public List<VaccineListVo> toList(VaccineListDto dto) {
//        LambdaQueryWrapper<OmsVaccine> wrapper = new LambdaQueryWrapper<OmsVaccine>()
//                .isNotNull(OmsVaccine::getVaccineId);
//        String variety = dto.getVariety();
//        String source = dto.getSource();
//        if(StrUtil.isNotEmpty(variety)){
//            wrapper.like(OmsVaccine::getVariety,variety);
//        }
//        if(StrUtil.isNotEmpty(source)){
//            wrapper.like(OmsVaccine::getVariety,source);
//        }
//        List<OmsVaccine> list = list(wrapper);
//        List<DetailListVo> voList = BeanUtil.copyToList(list, DetailListVo.class);
//        voList.forEach(vo -> {
//            // 处理购买价格
//            vo.setBuyingPrice(89);
//            // 处理疫苗状态
//            vo.setIsVaccine(true);
//            // 处理饲养状态
//            vo.setIsVaccine(true);
//        });
//        return voList;
        return null;
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public Row<VaccineDetailVo> toDetail(VaccineDetailDto dto) {
        OmsVaccine pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            throw new RuntimeException("数据不存在");
        }
        return Row.success(BeanUtil.toBean(pojo,VaccineDetailVo.class));
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toAdd(VaccineAddDto dto) {
        OmsVaccine pojo = BeanUtil.toBean(dto, OmsVaccine.class);
        return save(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toEdit(VaccineEditDto dto) {
        if(BeanUtil.isEmpty(getById(dto.getId()))){
            throw new RuntimeException("数据不存在");
        }
        OmsVaccine pojo = BeanUtil.toBean(dto, OmsVaccine.class);
        return updateById(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toDelete(VaccineDeleteDto dto) {
        String id = dto.getId();
        if(BeanUtil.isEmpty(getById(id))){
            throw new RuntimeException("数据不存在");
        }
        return removeById(id) ? AjaxResult.success() : AjaxResult.error();
    }
}
