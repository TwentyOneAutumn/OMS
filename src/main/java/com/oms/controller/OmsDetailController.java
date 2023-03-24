package com.oms.controller;

import com.oms.domain.AjaxResult;
import com.oms.domain.BaseController;
import com.oms.domain.TableInfo;
import com.oms.domain.dto.DetailListDto;
import com.oms.domain.vo.DetailListVo;
import com.oms.service.IOmsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

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
    @ResponseBody
    public TableInfo toList(@Valid DetailListDto dto){
        return build(detailService.toList(dto));
    }
}