package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.Build;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.service.IOmsFeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

/**
 * 饲养Controller
 */
public class OmsFeedingController {

    @Autowired
    private IOmsFeedingService feedingService;

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @GetMapping("/list")
    public TableInfo<FeedingListVo> toList(@Valid FeedingListDto dto){
        return Build.buildTable(feedingService.toList(dto));
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/detail")
    public Row<FeedingDetailVo> toDetail(@Valid @RequestBody FeedingDetailDto dto){
        return feedingService.toDetail(dto);
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/add")
    public AjaxResult toAdd(@Valid @RequestBody FeedingAddDto dto){
        return feedingService.toAdd(dto);
    }


    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/edit")
    public AjaxResult toEdit(@Valid @RequestBody FeedingEditDto dto){
        return feedingService.toEdit(dto);
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @DeleteMapping("/delete")
    public AjaxResult toDelete(@Valid @RequestBody FeedingDeleteDto dto){
        return feedingService.toDelete(dto);
    }

}
