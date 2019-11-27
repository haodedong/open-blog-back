package com.hdd.openblog.domain.request;

import com.mongodb.Tag;
import lombok.Data;

import java.util.List;

/**
 * Created by bill.hao
 * Descripton :
 * Time :2019/11/27
 */
@Data
public class AddBlogRequest {
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
     * 标签
     */
    private List<Tag> tags;
}
