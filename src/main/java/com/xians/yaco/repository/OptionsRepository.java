package com.xians.yaco.repository;


import com.xians.yaco.model.domain.Options;
import com.xians.yaco.repository.base.BaseRepository;

/**
 * <pre>
 *     系统设置持久层
 * </pre>
 *
 * @author : XIANS
 * @date : 2020/4/16
 */
public interface OptionsRepository extends BaseRepository<Options, String> {

    /**
     * 根据key查询单个option
     *
     * @param key key
     * @return Options
     */
    Options findOptionsByOptionName(String key);
}
