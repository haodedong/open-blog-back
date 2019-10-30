package com.hdd.openblog.domain.pojo.mongo;

import lombok.Data;

/**
 * @program: open-blog
 * @description: 标签
 * @author: dedong.hao
 * @create: 2019-08-29 22:15
 */
@Data
public class Tag {

    private String id;
    /**
     * 标签名称
     */
    private String tagName;


}