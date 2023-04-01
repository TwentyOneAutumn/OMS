package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oms.domain.*;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.mapper.OmsTransactionMapper;
import com.oms.service.IOmsDetailService;
import com.oms.service.IOmsTransactionService;
import com.oms.service.IOmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交易ServiceImpl
 */
@Service
public class OmsTransactionServiceImpl extends ServiceImpl<OmsTransactionMapper, OmsTransaction> implements IOmsTransactionService {

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
    public TableInfo<TransactionListVo> toList(TransactionListDto dto) {
        Page<Object> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<TransactionListVo> voList = BeanUtil.copyToList(list(), TransactionListVo.class);
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
    public Row<TransactionDetailVo> toDetail(TransactionDetailDto dto) {
        OmsTransaction pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            return Build.buildRow(false,"数据不存在");
        }
        TransactionDetailVo vo = BeanUtil.toBean(pojo, TransactionDetailVo.class);
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
    public AjaxResult toAdd(TransactionAddDto dto) {
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
        OmsTransaction pojo = BeanUtil.toBean(dto, OmsTransaction.class);
        pojo.setDetailId(detail.getId());
        pojo.setResponsiblePersonId(user.getUserId());
        pojo.setResponsiblePersonName(user.getUserName());
        return save(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toDelete(TransactionDeleteDto dto) {
        String id = dto.getId();
        if(BeanUtil.isEmpty(getById(id))){
            return AjaxResult.error("数据不存在");
        }
        return removeById(id) ? AjaxResult.success() : AjaxResult.error();
    }
}
