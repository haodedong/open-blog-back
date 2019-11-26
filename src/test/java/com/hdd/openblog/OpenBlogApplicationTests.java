package com.hdd.openblog;

import com.hdd.openblog.domain.pojo.mongo.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)

//@EnableAutoConfiguration
@SpringBootTest
public class OpenBlogApplicationTests {

    //	@Autowired
//	private BlogService blogService;
    @Test
    public void contextLoads() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 30; i++) {
            Date date = new Date();
            Blog blog = new Blog();
            blog.setTitle("title");
            blog.setContent("content");
            blog.setModifiedTime(date);
            blog.setDiscussCount(0L);
            blog.setIsActive(true);
            blog.setPublishTime(date);
            blog.setPopularity(0L);
            blog.setSummary("摘要");
            blog.setTags(Arrays.asList("tag1", "tag2"));
//			blogService.addBlog(blog);
            System.out.println(blog.get_id());
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds() + "秒");
    }

    @Test
    public void testselectTest() {

//		Page<Blog> blogByPage = blogService.findBlogByPage(PageRequest.of(0, 10));
//		System.out.println(JSONObject.toJSONString(blogByPage.getContent()));
//		System.out.println(blogByPage.getTotalElements());
    }

}
