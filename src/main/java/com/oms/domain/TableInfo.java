package com.oms.domain;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

/**
 * 表单数据封装
 * @param <T> 集合数据类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo<T> implements Serializable {
    /**
     * 记录数
     */
    private int Total;

    /**
     * 状态码
     */
    private int Code;

    /**
     * 信息
     */
    private String Msg;

    /**
     * 数据
     */
    private Collection<T> Collection;

    public TableInfo(Collection<T> collection){
        this.Total = CollUtil.isNotEmpty(collection) ? collection.size() : 0;
        this.Code = HttpStatus.SUCCESS;
        this.Msg = "操作成功";
        this.Collection = collection;
    }

    public TableInfo(int total,Collection<T> collection){
        this.Total = total;
        this.Code = HttpStatus.SUCCESS;
        this.Msg = "操作成功";
        this.Collection = collection;
    }
}
