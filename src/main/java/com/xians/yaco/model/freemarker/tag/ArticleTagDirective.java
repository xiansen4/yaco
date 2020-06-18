package com.xians.yaco.model.freemarker.tag;

import com.xians.yaco.model.enums.PostStatusEnum;
import com.xians.yaco.model.enums.PostTypeEnum;
import com.xians.yaco.service.PostService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * <pre>
 *     FreeMarker自定义标签
 * </pre>
 *
 * @author : XIANS
 * @date : 2020/4/17
 */
@Component
public class ArticleTagDirective implements TemplateDirectiveModel {
    //定义默认的key
    private static final String METHOD_KEY = "method";

    @Autowired
    private PostService postService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        final DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
            String method = map.get(METHOD_KEY).toString();
            switch (method) {
                case "postsCount":
                    environment.setVariable("postsCount", builder.build().wrap(postService.findPostByStatus(PostStatusEnum.PUBLISHED.getCode(), PostTypeEnum.POST_TYPE_POST.getDesc()).size()));
                    break;
                case "archives":
                    environment.setVariable("archives", builder.build().wrap(postService.findPostGroupByYearAndMonth()));
                    break;
                case "archivesLess":
                    environment.setVariable("archivesLess", builder.build().wrap(postService.findPostGroupByYear()));
                    break;
                case "hotPosts":
                    environment.setVariable("hotPosts", builder.build().wrap(postService.hotPosts()));
                    break;
                default:
                    break;
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}
