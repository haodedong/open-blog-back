package com.hdd.openblog.domain.request;

import lombok.Data;

/**
 * @program: open-blog
 * @description:
 * @author: dedong.hao
 * @create: 2019-11-26 21:52
 */
@Data
public class UpdateBlogRequest extends AddBlogRequest {
    String blogId;
}