package com.hdd.openblog.controller;

import com.hdd.openblog.common.JsonResult;
import com.hdd.openblog.common.PageRequest;
import com.hdd.openblog.domain.request.AddBlogRequest;
import com.hdd.openblog.domain.request.GetBlogPageByTagsRequest;
import com.hdd.openblog.domain.request.UpdateBlogRequest;

public interface BlogController {
    /**
     * 首页默认检索页面
     *
     * @param request
     * @return
     */
    JsonResult findBlogWithPage(PageRequest request);

    /**
     * 根据标签检索博客
     *
     * @param request
     * @return
     */
    JsonResult findBlogByTagsWithPage(GetBlogPageByTagsRequest request);

    /**
     * 修改博客信息
     */
    JsonResult updateBlogByBlogId(UpdateBlogRequest request);

    /**
     * 新增博客
     */
    JsonResult addBlog(AddBlogRequest request);

    JsonResult deleteBlog(String blogId);
}
