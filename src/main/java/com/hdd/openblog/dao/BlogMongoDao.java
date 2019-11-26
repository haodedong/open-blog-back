package com.hdd.openblog.dao;

import com.hdd.openblog.domain.pojo.mongo.Blog;
import com.hdd.openblog.domain.request.GetBlogsPageByTagsRequest;
import com.mongodb.client.result.UpdateResult;
import org.apache.commons.collections4.CollectionUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * @program: open-blog
 * @description:
 * @author: dedong.hao
 * @create: 2019-09-01 14:11
 */
@Repository
public class BlogMongoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 分页检索博客摘要列表
     *
     * @param pageRequest
     * @return
     */
    public Page<Blog> findBlogByPage(PageRequest pageRequest) {
        Query query = Query.query(new Criteria());
        query.skip(pageRequest.getOffset());
        query.limit(pageRequest.getPageSize());
        query.fields()
                .include("_id")
                .include("title")
                .include("summary")
                .include("discussCount")
                .include("popularity")
                .include("publishTime")
                .include("tags")
                .include("isActive");
        long count = mongoTemplate.count(query, Blog.class);
        if (count > 0) {
            List<Blog> blogList = mongoTemplate.find(query, Blog.class);
            return new PageImpl<>(blogList, pageRequest, count);
        } else {
            return Page.empty();
        }
    }

    /**
     * 根据博客id检索博客信息
     *
     * @param id
     * @return
     */
    public Blog getBlogById(ObjectId id) {
        return this.mongoTemplate.findById(id, Blog.class);
    }

    /**
     * 根据标签检索博客信息
     *
     * @param tags
     * @return
     */
    public List<Blog> getBlogsByTags(List<String> tags) {
        if (CollectionUtils.isEmpty(tags)) {
            return Collections.emptyList();
        } else {
            Criteria criteria = Criteria.where("tags").in(tags);
            Query query = new Query(criteria);
            query.with(new Sort(Sort.Direction.DESC, "publish_time"));
            return this.mongoTemplate.find(query, Blog.class);
        }
    }

    public ObjectId insertBlog(Blog blog) {
        return this.mongoTemplate.insert(blog).get_id();
    }

    /**
     * 根据博客id更新博客信息
     *
     * @param blog
     * @return
     */
    public UpdateResult editBlog(Blog blog) {
        Query query = new Query(new Criteria("_id").is(blog.get_id()));
        Update update = packageBeanField(blog, blog.getClass());
        return this.mongoTemplate.updateFirst(query, update, Blog.class);
    }

    /**
     * 包装mongoTemplate的 Update 对象
     *
     * @param object
     * @param beanClass
     */
    private Update packageBeanField(Object object, Class<?> beanClass) {
        Update update = new Update();
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                Object value = field.get(object);
                if (value != null && !field.getName().equals("_id")) {
                    update.set(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return update;
    }

    public void findBlogsByTagsWithPage(GetBlogsPageByTagsRequest request) {

    }

    public findBlogsByTagsWithPage()
}