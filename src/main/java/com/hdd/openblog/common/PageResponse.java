package com.hdd.openblog.common;

import lombok.Data;

import java.util.List;

/**
 * @program: open-blog
 * @description: 通用分页相应基类
 * @author: dedong.hao
 * @create: 2019-11-26 21:21
 */
@Data
public class PageResponse<T> {
    private List<T> items;
    private int total;

}