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
    private int Code;

    /**
     * 信息
     */
    private String Msg;

    public static AjaxResult success() {
        return new AjaxResult(HttpStatus.SUCCESS, "操作成功");
    }

    public static AjaxResult success(String msg) {
        return new AjaxResult(HttpStatus.SUCCESS, msg);
    }

    public static AjaxResult error() {
        return new AjaxResult(HttpStatus.ERROR, "操作失败");
    }

    public static AjaxResult error(String msg) {
        return new AjaxResult(HttpStatus.ERROR, msg);
    }
}
