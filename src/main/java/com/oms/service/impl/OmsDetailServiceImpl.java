package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oms.domain.*;
import com.oms.domain.Row;
import com.oms.domain.dto.*;
import com.oms.domain.vo.DetailDetailVo;
import com.oms.domain.vo.DetailListVo;
import com.oms.mapper.OmsDetailMapper;
import com.oms.mapper.OmsUserMapper;
import com.oms.service.IOmsDetailService;
import com.oms.service.IOmsUserService;
import com.oms.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 养殖明细ServiceImpl
 */
@Service
public class OmsDetailServiceImpl extends ServiceImpl<OmsDetailMapper, OmsDetail> implements IOmsDetailService {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public TableInfo<DetailListVo> toList(DetailListDto dto) {
        Page<Object> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
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
        return Build.buildTable(page.getPages(),voList);
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public Row<DetailDetailVo> toDetail(DetailDetailDto dto) {
        OmsDetail pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            throw new RuntimeException("数据不存在");
        }
        return Row.success(BeanUtil.toBean(pojo,DetailDetailVo.class));
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toAdd(DetailAddDto dto) {
        OmsDetail pojo = BeanUtil.toBean(dto, OmsDetail.class);
        return save(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toEdit(DetailEditDto dto) {
        if(BeanUtil.isEmpty(getById(dto.getId()))){
            throw new RuntimeException("数据不存在");
        }
        OmsDetail pojo = BeanUtil.toBean(dto, OmsDetail.class);
        return updateById(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toDelete(DetailDeleteDto dto) {
        String id = dto.getId();
        if(BeanUtil.isEmpty(getById(id))){
            throw new RuntimeException("数据不存在");
        }
        return removeById(id) ? AjaxResult.success() : AjaxResult.error();
    }
}
