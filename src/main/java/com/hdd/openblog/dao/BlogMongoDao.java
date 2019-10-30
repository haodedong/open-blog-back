package com.hdd.openblog.dao;

import com.hdd.openblog.domain.pojo.mongo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: open-blog
 * @description:
 * @author: dedong.hao
 * @create: 2019-09-01 14:11
 */
@Repository
public class BlogMongoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 分页检索博客摘要列表
     *
     * @param pageRequest
     * @return
     */
    public Page<Blog> findBlogByPage(PageRequest pageRequest) {
        Query query = Query.query(new Criteria());
        query.skip(pageRequest.getOffset());
        query.limit(pageRequest.getPageSize());
        query.fields()
                .include("_id")
                .include("title")
                .include("summary")
                .include("discussCount")
                .include("popularity")
                .include("publishTime")
                .include("tags")
                .include("isActive");
        long count = mongoTemplate.count(query, Blog.class);
        if (count > 0) {
            List<Blog> blogList = mongoTemplate.find(query, Blog.class);
            return new PageImpl<>(blogList, pageRequest, count);
        } else {
            return Page.empty();
        }
    }
}