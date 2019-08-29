package com.hdd.openblog.domain.pojo;

import lombok.Data;

/**
 * @program: open-blog
 * @description: 博客评论表，与博客表一对一
 * @author: dedong.hao
 * @create: 2019-08-29 22:27
 */
@Data
public class BlogDiscuss {
    /**
     * 博客id
     */
    private String blogId;



//    /**
//     * 评论内容
//     */
//    private String content;
//    /**
//     * 楼层
//     */
//    private Integer floor;
}