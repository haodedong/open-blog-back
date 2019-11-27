package com.hdd.openblog.controller;

import com.hdd.openblog.common.BlogUrlConstants;
import com.hdd.openblog.common.JsonResult;
import com.hdd.openblog.common.PageRequest;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.AddBlogRequest;
import com.hdd.openblog.domain.request.GetBlogPageByTagsRequest;
import com.hdd.openblog.domain.request.UpdateBlogRequest;
import com.hdd.openblog.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @program: open-blog
 * @description: 博客控制器
 * @author: dedong.hao
 * @create: 2019-11-26 21:36
 */
@RestController
public class BlogControllerImpl implements BlogController {
    @Autowired
    private BlogService blogService;

    @Override
    @GetMapping(BlogUrlConstants.BlogUrl.BLOG_PAGE)
    public JsonResult findBlogWithPage(PageRequest request) {
        return new JsonResult(blogService.findBlogByPage(request));
    }

    @Override
    @GetMapping(BlogUrlConstants.BlogUrl.BLOG_TAG_PAGE)
    public JsonResult findBlogByTagsWithPage(GetBlogPageByTagsRequest request) {
        return new JsonResult(blogService.findBlogByTagsWithPage(request));
    }

    @Override
    @PostMapping(BlogUrlConstants.BlogUrl.BLOG)
    public JsonResult updateBlogByBlogId(UpdateBlogRequest request) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(request, blog);
        blog.set_id(new ObjectId(request.getBlogId()));
        return new JsonResult(blogService.editBlog(blog));
    }


    @Override
    @PutMapping(BlogUrlConstants.BlogUrl.BLOG)
    public JsonResult addBlog(AddBlogRequest request) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(request, blog);
        blog.setIsActive(true);
        Date date = new Date();
        blog.setModifiedTime(date);
        blog.setPublishTime(date);
        return new JsonResult(blogService.addBlog(blog));
    }

    @Override
    @DeleteMapping(BlogUrlConstants.BlogUrl.BLOG)
    public JsonResult deleteBlog(String blogId) {
        return new JsonResult(blogService.deleteBlog(blogId));
    }

//    public static void main(String[] args) {
//        LocalDate d = LocalDate.now(); // 当前日期
//        LocalTime t = LocalTime.now(); // 当前时间
//        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
//        System.out.println(d); // 严格按照ISO 8601格式打印
//        System.out.println(t); // 严格按照ISO 8601格式打印
//        System.out.println(dt); // 严格按照ISO 8601格式打印
//    }
}