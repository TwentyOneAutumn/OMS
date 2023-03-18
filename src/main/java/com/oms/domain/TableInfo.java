package com.oms.domain;

import cn.hutool.core.collection.CollUtil;
import java.util.Collection;

/**
 * 表单数据封装
 * @param <T> 集合数据类型
 */
public class TableInfo<T>{
    /**
     * 记录数
     */
    private int num;

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private Collection<T> collection;

    public TableInfo(Collection<T> collection){
        this.num = CollUtil.isNotEmpty(collection) ? collection.size() : 0;
        this.code = HttpStatus.SUCCESS;
        this.msg = "操作成功";
        this.collection = collection;
    }
}
