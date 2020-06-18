package com.xians.yaco.config;


import com.xians.yaco.model.freemarker.method.RandomMethod;
import com.xians.yaco.model.freemarker.method.RecentCommentsMethod;
import com.xians.yaco.model.freemarker.method.RecentPostsMethod;
import com.xians.yaco.model.freemarker.tag.ArticleTagDirective;
import com.xians.yaco.model.freemarker.tag.CommonTagDirective;
import com.xians.yaco.service.OptionsService;
import com.xians.yaco.service.UserService;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * <pre>
 *     FreeMarker配置
 * </pre>
 *
 * @author : XIANS
 * @date : 2020/4/20
 */
@Slf4j
@Configuration
public class FreeMarkerAutoConfiguration {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommonTagDirective commonTagDirective;

    @Autowired
    private ArticleTagDirective articleTagDirective;

    @Autowired
    private RandomMethod randomMethod;

    @Autowired
    private RecentPostsMethod recentPostsMethod;

    @Autowired
    private RecentCommentsMethod recentCommentsMethod;

    @PostConstruct
    public void setSharedVariable() {
        try {
            //自定义标签
            configuration.setSharedVariable("commonTag", commonTagDirective);
            configuration.setSharedVariable("articleTag", articleTagDirective);
            configuration.setSharedVariable("options", optionsService.findAllOptions());
            configuration.setSharedVariable("user", userService.findUser());
            configuration.setSharedVariable("randomMethod", randomMethod);
            configuration.setSharedVariable("recentPostsMethod", recentPostsMethod);
            configuration.setSharedVariable("recentCommentsMethod", recentCommentsMethod);
        } catch (TemplateModelException e) {
            //打印日志信息
            log.error("Custom tags failed to load：{}", e.getMessage());
        }
    }

}
