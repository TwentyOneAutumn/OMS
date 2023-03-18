package com.oms.domain;

import cn.hutool.core.collection.CollUtil;

import java.util.Collection;

public class BaseController {
    /**
     * 构建TableInfo
     * @param collection 集合
     * @return TableInfo
     */
    public <T> TableInfo<T> build(Collection<T> collection){
        return new TableInfo<>(collection);
    }
}
