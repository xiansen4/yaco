package com.xians.yaco.repository;

import com.xians.yaco.model.domain.Category;
import com.xians.yaco.repository.base.BaseRepository;


/**
 * <pre>
 *     分类持久层
 * </pre>
 *
 * @author : XIANS
 * @date : 2020/04/16
 */
public interface CategoryRepository extends BaseRepository<Category, Long> {

    /**
     * 根据分类目录路径查询，用于验证是否已经存在该路径
     *
     * @param cateUrl cateUrl 文章url
     * @return 类型
     */
    Category findCategoryByCateUrl(String cateUrl);

    /**
     * 根据分类名称查询
     *
     * @param cateName 分类名称
     * @return 类型
     */
    Category findCategoryByCateName(String cateName);
}
