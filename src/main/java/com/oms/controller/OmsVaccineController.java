package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.Row;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.*;
import com.oms.domain.vo.*;
import com.oms.service.IOmsVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 疫苗Controller
 */
@RestController
@RequestMapping("/vaccine")
public class OmsVaccineController {

    @Autowired
    private IOmsVaccineService vaccineService;

    /**
     * 根据条件查询列表
     *
     * @param dto 数据对象
     * @return TableInfo
     */
    @GetMapping("/list")
    public TableInfo<VaccineListVo> toList(@Valid VaccineListDto dto){
        return vaccineService.toList(dto);
    }

    /**
     * 明细
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @GetMapping("/detail")
    public Row<VaccineDetailVo> toDetail(@Valid VaccineDetailDto dto){
        return vaccineService.toDetail(dto);
    }

    /**
     * 新增
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @PostMapping("/add")
    public AjaxResult toAdd(@Valid @RequestBody VaccineAddDto dto){
        return vaccineService.toAdd(dto);
    }

    /**
     * 修改
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @PutMapping("/edit")
    public AjaxResult toEdit(@Valid @RequestBody VaccineEditDto dto){
        return vaccineService.toEdit(dto);
    }

    /**
     * 删除
     *
     * @param dto 数据对象
     * @return AjaxResult
     */
    @DeleteMapping("/delete")
    public AjaxResult toDelete(@Valid @RequestBody VaccineDeleteDto dto){
        return vaccineService.toDelete(dto);
    }
}
