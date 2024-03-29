package com.hdd.openblog.domain.pojo.mongo;

import lombok.Data;

import java.util.Date;

/**
 * @program: open-blog
 * @description: 博客评论表，与博客表一对多
 * @author: dedong.hao
 * @create: 2019-08-29 22:27
 */
@Data
public class BlogDiscuss {
    /**
     * 评论id
     */
    private String discussId;
    /**
     * 父级评论id或顶级对应博文id
     */
    private String parentId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 访客Id
     */
    private String visitorId;
    /**
     * 点赞数
     */
    private Long popularity;
    /**
     * 评论时间
     */
    private Date discussTime;
}