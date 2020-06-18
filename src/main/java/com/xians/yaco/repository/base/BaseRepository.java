package com.xians.yaco.repository.base;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * 基本存储库界面包含一些常用方法
 *
 * @param <DOMAIN> 域 类型
 * @param <ID>     id 类型
 * @author XAINS
 */
@NoRepositoryBean
public interface BaseRepository<DOMAIN, ID> extends JpaRepository<DOMAIN, ID> {

    /**
     * 按ID列表和指定的排序查找所有域
     *
     * @param ids  域的ID列表不能为null
     * @param sort 指定的排序不得为null
     * @return a list of domains
     */
    @NonNull
    List<DOMAIN> findAllByIdIn(@NonNull Iterable<ID> ids, @NonNull Sort sort);

    /**
     * 根据id删除列表信息
     *
     * @param ids 域的ID列表不能为null
     */
    void deleteByIdIn(@NonNull Iterable<ID> ids);
}
