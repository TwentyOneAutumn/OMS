package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsFeeding;
import com.oms.domain.Row;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.mapper.OmsFeedingMapper;
import com.oms.service.IOmsFeedingService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 饲养ServiceImpl
 */
@Service
public class OmsFeedingServiceImpl extends ServiceImpl<OmsFeedingMapper, OmsFeeding> implements IOmsFeedingService {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public List<FeedingListVo> toList(FeedingListDto dto) {
//        LambdaQueryWrapper<OmsFeeding> wrapper = new LambdaQueryWrapper<OmsFeeding>()
//                .isNotNull(OmsFeeding::getVaccineId);
//        String variety = dto.getVariety();
//        String source = dto.getSource();
//        if(StrUtil.isNotEmpty(variety)){
//            wrapper.like(OmsFeeding::getVariety,variety);
//        }
//        if(StrUtil.isNotEmpty(source)){
//            wrapper.like(OmsFeeding::getVariety,source);
//        }
//        List<OmsFeeding> list = list(wrapper);
//        List<DetailListVo> voList = BeanUtil.copyToList(list, DetailListVo.class);
//        voList.forEach(vo -> {
//            // 处理购买价格
//            vo.setBuyingPrice(89);
//            // 处理疫苗状态
//            vo.setIsVaccine(true);
//            // 处理饲养状态
//            vo.setIsFeeding(true);
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
    public Row<FeedingDetailVo> toDetail(FeedingDetailDto dto) {
        OmsFeeding pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            throw new RuntimeException("数据不存在");
        }
        return Row.success(BeanUtil.toBean(pojo,FeedingDetailVo.class));
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toAdd(FeedingAddDto dto) {
        OmsFeeding pojo = BeanUtil.toBean(dto, OmsFeeding.class);
        return save(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toEdit(FeedingEditDto dto) {
        if(BeanUtil.isEmpty(getById(dto.getId()))){
            throw new RuntimeException("数据不存在");
        }
        OmsFeeding pojo = BeanUtil.toBean(dto, OmsFeeding.class);
        return updateById(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toDelete(FeedingDeleteDto dto) {
        String id = dto.getId();
        if(BeanUtil.isEmpty(getById(id))){
            throw new RuntimeException("数据不存在");
        }
        return removeById(id) ? AjaxResult.success() : AjaxResult.error();
    }
}
