package com.hdd.openblog.common;

import lombok.Data;

import java.util.Map;

/**
 * @program: open-blog
 * @description: 通用分页请求基类
 * @author: dedong.hao
 * @create: 2019-11-26 21:14
 */
@Data
public class PageRequest {
    /**
     * 第几页
     */
    protected int pageNo;
    protected int pageSize;
    /**
     * 排序方式
     */
    protected Map<String, String> sortMap;
}