package com.hdd.openblog.dao;

import com.alibaba.fastjson.JSON;
import com.hdd.openblog.OpenBlogApplicationTests;
import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bill.hao
 * Descripton :
 * Time :2019/11/26
 */
public class BlogMongoDaoTest extends OpenBlogApplicationTests {
    @Autowired
    private BlogMongoDao blogMongoDao;

    @Test
    public void findBlogByPage() {
    }

    @Test
    public void getBlogById() {
//        Blog blogById = blogMongoDao.getBlogById("5ddcd25a57ba5822549bc0b4");
//        System.out.println(JSON.toJSONString(blogById));

    }

    @Test
    public void getBlogByTags() {
        List<Blog> blogByTags = blogMongoDao.getBlogByTags(Collections.singletonList("33444"));
        System.out.println(JSON.toJSON(blogByTags));
    }

    @Test
    public void insertBlog() {
        Blog blog = new Blog();

        blog.setContent("test content");
        blog.setIsActive(true);
        blog.setSummary("test summanry");
        blog.setTitle("test title");
        blog.setTags(Arrays.asList("java", "spring"));
        String id = blogMongoDao.insertBlog(blog).toString();
        System.out.println(id);
    }

    @Test
    public void editBlog() {
        Blog blog = new Blog();
        blog.set_id(new ObjectId("5ddcd25a57ba5822549bc0b4"));
        blog.setTags(Arrays.asList("223", "33444"));
        blog.setTitle("test blog title1");
        blog.setSummary("test blog summary1");
        UpdateResult updateResult = blogMongoDao.editBlog(blog);
        String s = JSON.toJSONString(updateResult);
        System.out.println(s);
    }
}