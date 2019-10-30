package com.hdd.openblog.service.impl;

import com.hdd.openblog.dao.BlogMongoDao;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: open-blog
 * @description:
 * @author: dedong.hao
 * @create: 2019-08-31 22:57
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMongoDao blogMongoDao;

    /**
     * 分页检索博客摘要列表
     *
     * @param pageRequest
     * @return
     */
    public Page<Blog> findBlogByPage(PageRequest pageRequest) {
        Page<Blog> blogs = blogMongoDao.findBlogByPage(pageRequest);
    }

    /**
     * 新增一篇博客
     *
     * @param blog
     * @return
     */
    public ObjectId addBlog(Blog blog) {
        return mongoTemplate.insert(blog).get_id();
    }

    /**
     * 根据id查询博客
     *
     * @param id
     * @return
     */
    public Blog findBlogByObjectId(ObjectId id) {
        Criteria
        return mongoTemplate.findOne()
    }
}