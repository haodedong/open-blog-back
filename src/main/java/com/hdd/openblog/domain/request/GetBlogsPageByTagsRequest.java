package com.hdd.openblog.domain.request;


import com.hdd.openblog.common.PageRequest;
import lombok.Data;

import java.util.List;

/**
 * Created by bill.hao
 * Descripton :
 * Time :2019/11/26
 */
@Data
public class GetBlogsPageByTagsRequest extends PageRequest {
    private List<String> tags;
}
