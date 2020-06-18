package com.xians.yaco.task;


import com.xians.yaco.model.domain.Post;
import com.xians.yaco.service.PostService;
import com.xians.yaco.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

import static com.xians.yaco.model.dto.HaloConst.POSTS_VIEWS;

/**
 * @author : XIANS
 * @date : 2020/04/15
 * @return : 同步后台数据
 */
@Slf4j
public class PostSyncTask {

    /**
     * 将缓存的图文浏览数写入数据库
     */
    public void postSync() {
        //将PostService注入spring容器中
        final PostService postService = SpringUtil.getBean(PostService.class);
        int count = 0;
        for (Long key : POSTS_VIEWS.keySet()) {
            Post post = postService.getByIdOfNullable(key);
            if (null != post) {
                post.setPostViews(post.getPostViews() + POSTS_VIEWS.get(key));
                postService.create(post);
                count++;

            }
        }
        log.info("The number of visits to {} posts has been updated", count);
        POSTS_VIEWS.clear();
    }
}
