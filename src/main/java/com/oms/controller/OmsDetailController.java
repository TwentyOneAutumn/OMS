package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.BaseController;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.service.IOmsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * 养殖明细Controller
 */
@RestController
@RequestMapping("/detail")
public class OmsDetailController extends BaseController {

    @Autowired
    private IOmsDetailService detailService;

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @GetMapping("/list")
    public TableInfo toList(@Valid DetailListDto dto){
        return build(detailService.toList(dto));
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/detail")
    public Row<DetailDetailVo> toDetail(@Valid @RequestBody DetailDetailDto dto){
        return detailService.toDetail(dto);
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/add")
    public AjaxResult toAdd(@Valid @RequestBody DetailAddDto dto){
        return detailService.toAdd(dto);
    }


    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/edit")
    public AjaxResult toEdit(@Valid @RequestBody DetailEditDto dto){
        return detailService.toEdit(dto);
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @DeleteMapping("/delete")
    public AjaxResult toDelete(@Valid @RequestBody DetailDeleteDto dto){
        return detailService.toDelete(dto);
    }
}