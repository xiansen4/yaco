package com.xians.yaco.utils;


import com.xians.yaco.logging.Logger;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * service工具类.
 *
 * @author johnniang
 */
public class ServiceUtils {

    private final static Logger LOGGER = Logger.getLogger(ServiceUtils.class);

    private ServiceUtils() {
    }

    /**
     * 获取ID进行设置。
     *
     * @param datas           data collection
     * @param mappingFunction calculate the id in data list
     * @param <ID>            id type
     * @param <T>             data type
     * @return a set of id
     */
    public static <ID, T> Set<ID> fetchProperty(final Collection<T> datas, Function<T, ID> mappingFunction) {
        return CollectionUtils.isEmpty(datas) ?
                Collections.emptySet() :
                datas.stream().map(mappingFunction).collect(Collectors.toSet());
    }

    /**
     * 将列表转换为列表列表，其中列表包含ID中的ID。
     *
     * @param ids             id collection
     * @param list            data list
     * @param mappingFunction calculate the id in data list
     * @param <ID>            id type
     * @param <D>             data type
     * @return a map which key is in ids and value containing in list
     */
    public static <ID, D> Map<ID, List<D>> convertToListMap(Collection<ID> ids, Collection<D> list, Function<D, ID> mappingFunction) {
        Assert.notNull(mappingFunction, "mapping function must not be null");

        if (CollectionUtils.isEmpty(ids) || CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }

        Map<ID, List<D>> resultMap = new HashMap<>();

        list.forEach(data -> resultMap.computeIfAbsent(mappingFunction.apply(data), id -> new LinkedList<>()).add(data));

        ids.forEach(id -> resultMap.putIfAbsent(id, Collections.emptyList()));

        return resultMap;
    }

    /**
     * 转换为Map（列表数据中的键）
     *
     * @param list            data list
     * @param mappingFunction calclulate the id from list data
     * @param <ID>            id type
     * @param <D>             data type
     * @return a map which key from list data and value is data
     */
    public static <ID, D> Map<ID, D> convertToMap(Collection<D> list, Function<D, ID> mappingFunction) {
        Assert.notNull(mappingFunction, "mapping function must not be null");

        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }

        Map<ID, D> resultMap = new HashMap<>();

        list.forEach(data -> resultMap.putIfAbsent(mappingFunction.apply(data), data));

        return resultMap;
    }

    /**
     * Converts to map (key from the list data)
     *
     * @param list          data list
     * @param keyFunction   key mapping function
     * @param valueFunction value mapping function
     * @param <ID>          id type
     * @param <D>           data type
     * @param <V>           value type
     * @return a map which key from list data and value is data
     */
    public static <ID, D, V> Map<ID, V> convertToMap(Collection<D> list, Function<D, ID> keyFunction, Function<D, V> valueFunction) {
        Assert.notNull(keyFunction, "mapping function must not be null");

        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }

        Map<ID, V> resultMap = new HashMap<>();

        list.forEach(data -> resultMap.putIfAbsent(keyFunction.apply(data), valueFunction.apply(data)));

        return resultMap;
    }
}
