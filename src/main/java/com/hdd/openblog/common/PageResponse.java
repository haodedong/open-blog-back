package com.hdd.openblog.common;

import com.hdd.openblog.domain.pojo.mongo.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @program: open-blog
 * @description: 通用分页相应基类
 * @author: dedong.hao
 * @create: 2019-11-26 21:21
 */
@Data
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> items;
    private long total;

    public static PageResponse<Blog> empty() {
        return new PageResponse<>(Collections.emptyList(), 0L);
    }
}