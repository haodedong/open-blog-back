package com.hdd.openblog.controller;

import com.hdd.openblog.common.JsonResult;
import com.hdd.openblog.common.PageRequest;
import com.hdd.openblog.common.PageResponse;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.GetBlogsPageByTagsRequest;
import com.hdd.openblog.domain.request.UpdateBlogRequest;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: open-blog
 * @description: 博客控制器
 * @author: dedong.hao
 * @create: 2019-11-26 21:36
 */
@RestController
public class BlogControllerImpl implements BlogController {
    public JsonResult<PageResponse<Blog>> findBlogsWithPage(PageRequest request) {

    }

    @Override
    public JsonResult<PageResponse<Blog>> findBlogsByTagsWithPage(GetBlogsPageByTagsRequest request) {
        return null;
    }

    @Override
    public JsonResult updateBlogByBlogId(UpdateBlogRequest request) {
        return null;
    }
}