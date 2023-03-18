package com.oms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * 相应状态类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult implements Serializable {
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
    private Object rows;

    public static AjaxResult success() {
        return new AjaxResult(HttpStatus.SUCCESS, "操作成功", null);
    }

    public static AjaxResult success(String msg) {
        return new AjaxResult(HttpStatus.SUCCESS, msg, null);
    }

    public static AjaxResult success(Object rows) {
        return new AjaxResult(HttpStatus.SUCCESS, "操作成功", rows);
    }

    public static AjaxResult success(String msg, Object rows) {
        return new AjaxResult(HttpStatus.SUCCESS, msg, rows);
    }

    public static AjaxResult error() {
        return new AjaxResult(HttpStatus.ERROR, "操作失败", null);
    }

    public static AjaxResult error(String msg) {
        return new AjaxResult(HttpStatus.ERROR, msg, null);
    }
}
