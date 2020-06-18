package com.xians.yaco.model.freemarker.method;


import com.xians.yaco.service.PostService;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : XIANS
 * @date : 2020/4/17
 */
@Component
public class RecentPostsMethod implements TemplateMethodModelEx {

    @Autowired
    private PostService postService;

    /**
     * 获取最近的文章
     *
     * @param arguments 参数
     * @return Object
     * @throws TemplateModelException TemplateModelException
     */
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        SimpleNumber argOne = (SimpleNumber) arguments.get(0);
        int limit = argOne.getAsNumber().intValue();
        return postService.getRecentPosts(limit);
    }
}
