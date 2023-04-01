package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oms.domain.*;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.mapper.OmsVaccineMapper;
import com.oms.service.IOmsDetailService;
import com.oms.service.IOmsUserService;
import com.oms.service.IOmsVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 疫苗ServiceImpl
 */
@Service
public class OmsVaccineServiceImpl extends ServiceImpl<OmsVaccineMapper, OmsVaccine> implements IOmsVaccineService {

    @Autowired
    IOmsDetailService detailService;

    @Autowired
    IOmsUserService userService;

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public TableInfo<VaccineListVo> toList(VaccineListDto dto) {
        Page<Object> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<VaccineListVo> voList = BeanUtil.copyToList(list(), VaccineListVo.class);
        voList.forEach(vo -> {
            OmsDetail detail = detailService.getById(vo.getDetailId());
            if(BeanUtil.isNotEmpty(detail)){
                vo.setBatchNum(detail.getBatchNum());
                vo.setVariety(detail.getVariety());
                vo.setSource(detail.getSource());
            }
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
    public Row<VaccineDetailVo> toDetail(VaccineDetailDto dto) {
        OmsVaccine pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            return Build.buildRow(false,"数据不存在");
        }
        VaccineDetailVo vo = BeanUtil.toBean(pojo, VaccineDetailVo.class);
        OmsDetail detail = detailService.getById(pojo.getDetailId());
        vo.setBatchNum(detail.getBatchNum());
        vo.setVariety(detail.getVariety());
        vo.setSource(detail.getSource());
        return Row.success(vo);
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toAdd(VaccineAddDto dto) {
        OmsUser user = userService.getOne(new LambdaQueryWrapper<OmsUser>()
                .eq(OmsUser::getUserName, dto.getResponsiblePersonName())
        );
        if(BeanUtil.isEmpty(user)){
            return AjaxResult.error("该用户不存在");
        }
        OmsDetail detail = detailService.getOne(new LambdaQueryWrapper<OmsDetail>()
                .eq(OmsDetail::getBatchNum, dto.getBatchNum())
        );
        if(BeanUtil.isEmpty(detail)){
            return AjaxResult.error("该批次不存在");
        }
        OmsVaccine pojo = BeanUtil.toBean(dto, OmsVaccine.class);
        pojo.setDetailId(detail.getId());
        pojo.setResponsiblePersonId(user.getUserId());
        pojo.setResponsiblePersonName(user.getUserName());
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
