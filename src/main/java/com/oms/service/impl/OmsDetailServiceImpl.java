package com.oms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
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
import com.oms.service.*;
import com.oms.utils.JwtUtil;
import com.oms.utils.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * 养殖明细ServiceImpl
 */
@Service
public class OmsDetailServiceImpl extends ServiceImpl<OmsDetailMapper, OmsDetail> implements IOmsDetailService {

    @Autowired
    private IOmsFeedingService feedingService;

    @Autowired
    private IOmsTransactionService transactionService;

    @Autowired
    private IOmsVaccineService vaccineService;

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @Override
    public TableInfo<DetailListVo> toList(DetailListDto dto) {
        if(BeanUtil.isEmpty(dto.getIsVaccine())){
            return Build.buildTable("是否接种疫苗不能为空");
        }
        if(BeanUtil.isEmpty(dto.getPageSize())){
            return Build.buildTable("pageSize参数不能为空");
        }
        if(BeanUtil.isEmpty(dto.getPageNum())){
            return Build.buildTable("pageNum参数不能为空");
        }
        Page<Object> page = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        LambdaQueryWrapper<OmsDetail> wrapper = new LambdaQueryWrapper<>();
        String variety = dto.getVariety();
        String source = dto.getSource();
        if(StrUtil.isNotEmpty(variety)){
            wrapper.like(OmsDetail::getVariety,variety);
        }
        if(StrUtil.isNotEmpty(source)){
            wrapper.like(OmsDetail::getSource,source);
        }
        List<OmsDetail> list = list(wrapper);
        if(dto.getIsVaccine()){
            list = StreamUtils.filterToList(list,detail -> vaccineService.count(new LambdaQueryWrapper<OmsVaccine>().eq(OmsVaccine::getDetailId,detail.getId())) > 0);
        }else {
            list = StreamUtils.filterToList(list,detail -> vaccineService.count(new LambdaQueryWrapper<OmsVaccine>().eq(OmsVaccine::getDetailId,detail.getId())) == 0);
        }
        List<DetailListVo> voList = BeanUtil.copyToList(list, DetailListVo.class);
        voList.forEach(vo -> {
            // 处理购买价格
            OmsTransaction transaction = transactionService.getOne(new LambdaQueryWrapper<OmsTransaction>().eq(OmsTransaction::getDetailId, vo.getId()));
            vo.setBuyingPrice(BeanUtil.isEmpty(transaction) ? 0 : transaction.getTransactionPrice());
            // 处理疫苗状态
            vo.setIsVaccine(vaccineService.count(new LambdaQueryWrapper<OmsVaccine>().eq(OmsVaccine::getDetailId,vo.getId())) > 0);
            // 处理饲养状态
            vo.setIsFeeding(feedingService.count(new LambdaQueryWrapper<OmsFeeding>().eq(OmsFeeding::getDetailId,vo.getId())) > 0);
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
        if(StrUtil.isEmpty(dto.getId())){
            return Build.buildRow(false,"id参数不能为空");
        }
        OmsDetail pojo = getById(dto.getId());
        if(BeanUtil.isEmpty(pojo)){
            return Build.buildRow(false,"数据不存在");
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
        if(StrUtil.isEmpty(dto.getVariety())){
            return AjaxResult.error("品种不能为空");
        }
        if(StrUtil.isEmpty(dto.getSource())){
            return AjaxResult.error("来源不能为空");
        }
        OmsDetail pojo = BeanUtil.toBean(dto, OmsDetail.class);
        pojo.setStartTime(LocalDate.now());
        List<OmsDetail> list = list();
        if(CollUtil.isNotEmpty(list)){
            Integer batchNum = StreamUtils.max(list, Comparator.comparing(OmsDetail::getBatchNum)).getBatchNum();
            pojo.setBatchNum(BeanUtil.isNotEmpty(batchNum) ? batchNum + 1 : 1);
        }else {
            pojo.setBatchNum(1);
        }
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
        if(StrUtil.isEmpty(dto.getId())){
            return AjaxResult.error("id参数不能为空");
        }
        if(StrUtil.isEmpty(dto.getVariety())){
            return AjaxResult.error("品种不能为空");
        }
        if(StrUtil.isEmpty(dto.getSource())){
            return AjaxResult.error("来源不能为空");
        }
        if(BeanUtil.isEmpty(getById(dto.getId()))){
            return AjaxResult.error("数据不存在");
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
        if(StrUtil.isEmpty(dto.getId())){
            return AjaxResult.error("id参数不能为空");
        }
        String id = dto.getId();
        if(BeanUtil.isEmpty(getById(id))){
            return AjaxResult.error("数据不存在");
        }
        if(removeById(id)){
            feedingService.remove(new LambdaQueryWrapper<OmsFeeding>()
                    .eq(OmsFeeding::getDetailId,id)
            );
            transactionService.remove(new LambdaQueryWrapper<OmsTransaction>()
                    .eq(OmsTransaction::getDetailId,id)
            );
            vaccineService.remove(new LambdaQueryWrapper<OmsVaccine>()
                    .eq(OmsVaccine::getDetailId,id)
            );
            return AjaxResult.success();
        }else {
            return AjaxResult.error();
        }
    }
}
