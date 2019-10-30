package com.hdd.openblog.domain.pojo.mongo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private ObjectId _id;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 评论数量
     */
    @Field("discuss_count")
    private Long discussCount;
//    /**
//     * 浏览次数/点击量
//     * TODO 想设计成存放到redis中
//     */
//    private Long viewCount;
    /**
     * 点赞数
     */
    private Long popularity;
    /**
     * 发布时间
     */
    @Field("publish_time")
    private Date publishTime;
    /**
     * 编辑时间
     */
    @Field("modified_time")
    private Date modifiedTime;
    /**
     * 是否存活，未被删除
     */
    @Field("is_active")
    private Boolean isActive;
    /**
     * 标签
     */
    private List<String> tags;

}