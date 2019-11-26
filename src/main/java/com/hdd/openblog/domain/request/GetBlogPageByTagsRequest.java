package com.hdd.openblog.domain.request;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by bill.hao
 * Descripton :
 * Time :2019/11/26
 */
public class GetBlogPageByTagsRequest extends PageImpl<GetBlogPageByTagsRequest> {
    private List<String> tags;

    public GetBlogPageByTagsRequest(List<GetBlogPageByTagsRequest> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public GetBlogPageByTagsRequest(List<GetBlogPageByTagsRequest> content) {
        super(content);
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
