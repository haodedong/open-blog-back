package com.hdd.openblog.service.impl;

import com.hdd.openblog.dao.BlogMongoDao;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.GetBlogPageByTagsRequest;
import com.hdd.openblog.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    @Override
    public Page<Blog> findBlogByPage(PageRequest pageRequest) {
        return blogMongoDao.findBlogByPage(pageRequest);
    }

    @Override
    public ObjectId addBlog(Blog blog) {
        return blogMongoDao.insertBlog(blog);
    }

    @Override
    public Blog findBlogByObjectId(ObjectId id) {
        return blogMongoDao.getBlogById(id);
    }

    public Page<Blog> findBlogsByTagsWithPage(GetBlogPageByTagsRequest request) {
        blogMongoDao.findBlogsByTagsWithPage(request);
    }
}