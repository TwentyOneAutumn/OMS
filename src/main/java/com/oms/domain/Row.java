package com.oms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 数据封装
 * @param <T> 集合数据类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Row<T> implements Serializable {

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
    private T row;

    public Row(T row){
        this.code = HttpStatus.SUCCESS;
        this.msg = "操作成功";
        this.row = row;
    }

    public static  <T> Row<T> success(T row){
        return new Row<T>(HttpStatus.ERROR, "操作成功", row);
    }
}
