package com.hdd.openblog.controller;

import com.hdd.openblog.common.JsonResult;
import com.hdd.openblog.common.PageRequest;
import com.hdd.openblog.common.PageResponse;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.GetBlogsPageByTagsRequest;
import com.hdd.openblog.domain.request.UpdateBlogRequest;

public interface BlogController {
    /**
     * 首页默认检索页面
     *
     * @param request
     * @return
     */
    JsonResult<PageResponse<Blog>> findBlogsWithPage(PageRequest request);

    /**
     * 根据标签检索博客
     *
     * @param request
     * @return
     */
    JsonResult<PageResponse<Blog>> findBlogsByTagsWithPage(GetBlogsPageByTagsRequest request);

    /**
     * 修改博客信息
     *
     * @param request
     * @return
     */
    JsonResult updateBlogByBlogId(UpdateBlogRequest request);
}
