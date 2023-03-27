package com.oms.domain;

import java.util.Collection;

public class Build {

    /**
     * 构建TableInfo
     * @param collection 集合
     * @return TableInfo
     */
    public static  <T> TableInfo<T> buildTable(Collection<T> collection){
        return new TableInfo<T>(collection);
    }


    /**
     * 构建TableInfo
     * @param collection 集合
     * @return TableInfo
     */
    public static  <T> TableInfo<T> buildTable(int total, Collection<T> collection){
        return new TableInfo<T>(total,collection);
    }
}
