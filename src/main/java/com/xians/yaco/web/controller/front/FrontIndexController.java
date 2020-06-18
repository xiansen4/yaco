package com.xians.yaco.web.controller.front;


import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.xians.yaco.model.domain.Post;
import com.xians.yaco.model.enums.BlogPropertiesEnum;
import com.xians.yaco.service.PostService;
import com.xians.yaco.web.controller.core.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.xians.yaco.model.dto.HaloConst.OPTIONS;
import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * <pre>
 *     前台首页控制器
 *
 *
 *    看明白
 * </pre>
 *
 * @author : XIANS
 * @date : 2020/04/16
 */
@Slf4j
@Controller
@RequestMapping(value = {"/", "index"})
public class FrontIndexController extends BaseController {

    @Autowired
    private PostService postService;


    /**
     * 请求首页
     *
     * @param model model
     * @return 模板路径
     */
    @GetMapping
    public String index(Model model) {
        //将得到的数据传递,并请求首页
        return this.index(model, 1, Sort.by(DESC, "postDate"));
    }

    /**
     * 首页分页
     *
     * @param model model
     * @param page  当前页码
     * @return 模板路径/themes/{theme}/index
     */
    @GetMapping(value = "page/{page}")
    public String index(Model model,
                        @PathVariable(value = "page") Integer page,
                        @SortDefault(sort = "postDate", direction = DESC) Sort sort) {
        //默认显示10条
        int size = 10;
        if (StrUtil.isNotBlank(OPTIONS.get(BlogPropertiesEnum.INDEX_POSTS.getProp()))) {
            size = Integer.parseInt(OPTIONS.get(BlogPropertiesEnum.INDEX_POSTS.getProp()));
        }
        //所有文章数据，分页
        final Pageable pageable = PageRequest.of(page - 1, size, sort);
        final Page<Post> posts = postService.findPostByStatus(pageable);
       //如果posts为空,则重定向到404页面
        if (null == posts) {
            return this.renderNotFound();
        }
        final int[] rainbow = PageUtil.rainbow(page, posts.getTotalPages(), 3);
        //将数据传往前端页面
        model.addAttribute("is_index", true);
        model.addAttribute("posts", posts);
        model.addAttribute("rainbow", rainbow);
        //将页面名字传递给BaseController的render()方法
        return this.render("index");
    }
}
