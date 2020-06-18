package com.xians.yaco.model.dto;

import lombok.Data;

/**
 * <pre>
 *     七牛上传自定义凭证回调解析
 * </pre>
 *
 * @author : XIANS
 */
@Data
public class QiNiuPutSet {

    /**
     * 图片大小
     */
    private Long size;

    /**
     * 长
     */
    private Integer w;

    /**
     * 宽
     */
    private Integer h;
}
