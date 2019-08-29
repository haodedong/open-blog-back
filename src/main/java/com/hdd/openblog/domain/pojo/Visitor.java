package com.hdd.openblog.domain.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @program: open-blog
 * @description: 访客
 * @author: dedong.hao
 * @create: 2019-08-29 22:24
 */
@Document
@Data
public class Visitor {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    private String ip;



}