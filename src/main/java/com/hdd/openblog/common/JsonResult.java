package com.hdd.openblog.common;

import lombok.Data;

/**
 * @program: open-blog
 * @description: 通用返回类
 * @author: dedong.hao
 * @create: 2019-11-26 21:09
 */
@Data
public class JsonResult<T> {
    private T data;
    /**
     * 默认0 正常返回
     */
    private int code = 0;
}