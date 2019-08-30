package com.hdd.openblog.domain.pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @program: open-blog
 * @description: 博文
 * @author: dedong.hao
 * @create: 2019-08-29 21:45
 */
@Document
@Data
public class Blog {
    private ObjectId id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 评论数量
     */
    private Long discussCount;
    /**
     * 浏览次数/点击量
     * TODO 想设计成存放到redis中
     */
    private Long viewCount;
    /**
     * 点赞数
     */
    private Long popularity;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 编辑时间
     */
    private Date modifiedTime;
    /**
     * 是否存活，未被删除
     */
    private Boolean isActive;

    private List<Tag> tags;

}