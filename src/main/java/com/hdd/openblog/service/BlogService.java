package com.hdd.openblog.service;

import com.hdd.openblog.common.PageRequest;
import com.hdd.openblog.common.PageResponse;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.GetBlogPageByTagsRequest;
import org.bson.types.ObjectId;


public interface BlogService {
    PageResponse<Blog> findBlogByPage(PageRequest request);

    Boolean addBlog(Blog blog);

    Blog findBlogByObjectId(ObjectId id);

    Boolean editBlog(Blog blog);

    Boolean deleteBlog(String blogId);

    PageResponse<Blog> findBlogByTagsWithPage(GetBlogPageByTagsRequest request);


}
