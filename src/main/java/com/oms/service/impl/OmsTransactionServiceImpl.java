package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oms.domain.AjaxResult;
import com.oms.domain.OmsTransaction;
import com.oms.domain.Row;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.mapper.OmsTransactionMapper;
import com.oms.service.IOmsTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交易ServiceImpl
 */
@Service
public class OmsTransactionServiceImpl extends ServiceImpl<OmsTransactionMapper, OmsTransaction> implements IOmsTransactionService {

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public List<TransactionListVo> toList(TransactionListDto dto) {
//        LambdaQueryWrapper<OmsTransaction> wrapper = new LambdaQueryWrapper<OmsTransaction>()
//                .isNotNull(OmsTransaction::getVaccineId);
//        String variety = dto.getVariety();
//        String source = dto.getSource();
//        if(StrUtil.isNotEmpty(variety)){
//            wrapper.like(OmsTransaction::getVariety,variety);
//        }
//        if(StrUtil.isNotEmpty(source)){
//            wrapper.like(OmsTransaction::getVariety,source);
//        }
//        List<OmsTransaction> list = list(wrapper);
//        List<DetailListVo> voList = BeanUtil.copyToList(list, DetailListVo.class);
//        voList.forEach(vo -> {
//            // 处理购买价格
//            vo.setBuyingPrice(89);
//            // 处理疫苗状态
//            vo.setIsVaccine(true);
//            // 处理饲养状态
//            vo.setIsTransaction(true);
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
    public Row<TransactionDetailVo> toDetail(TransactionDetailDto dto) {
        OmsTransaction pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            throw new RuntimeException("数据不存在");
        }
        return Row.success(BeanUtil.toBean(pojo,TransactionDetailVo.class));
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toAdd(TransactionAddDto dto) {
        OmsTransaction pojo = BeanUtil.toBean(dto, OmsTransaction.class);
        return save(pojo) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @Override
    public AjaxResult toEdit(TransactionEditDto dto) {
        if(BeanUtil.isEmpty(getById(dto.getId()))){
            throw new RuntimeException("数据不存在");
        }
        OmsTransaction pojo = BeanUtil.toBean(dto, OmsTransaction.class);
        return updateById(pojo) ? AjaxResult.success() : AjaxResult.error();
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
            throw new RuntimeException("数据不存在");
        }
        return removeById(id) ? AjaxResult.success() : AjaxResult.error();
    }
}
