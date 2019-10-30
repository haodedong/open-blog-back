package com.hdd.openblog.service;

import com.hdd.openblog.domain.pojo.mongo.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public interface BlogService {
    Page<Blog> findBlogByPage(PageRequest pageRequest);

    ObjectId addBlog(Blog blog);

    Blog findBlogByObjectId(ObjectId id);
}
