package com.hdd.openblog.service.impl;

import com.hdd.openblog.common.PageRequest;
import com.hdd.openblog.common.PageResponse;
import com.hdd.openblog.dao.BlogMongoDao;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.GetBlogPageByTagsRequest;
import com.hdd.openblog.service.BlogService;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
     */
    @Override
    public PageResponse<Blog> findBlogByPage(PageRequest request) {
        return blogMongoDao.findBlogByPage(request.getPageNo(), request.getPageSize(), null);
    }

    @Override
    public Boolean addBlog(Blog blog) {
        blogMongoDao.insertBlog(blog);
        return true;
    }

    @Override
    public Blog findBlogByObjectId(ObjectId id) {
        return blogMongoDao.getBlogById(id);
    }

    @Override
    public Boolean editBlog(Blog blog) {
        UpdateResult updateResult = blogMongoDao.editBlog(blog);
        return updateResult.getModifiedCount() > 0;
    }

    @Override
    public Boolean deleteBlog(String blogId) {
        return blogMongoDao.deleteBlog(blogId);
    }

    @Override
    public PageResponse<Blog> findBlogByTagsWithPage(GetBlogPageByTagsRequest request) {
        return blogMongoDao.findBlogByTagsWithPage(request.getPageNo(), request.getPageSize(), request.getTags());
    }
}