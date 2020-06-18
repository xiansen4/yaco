package com.xians.yaco.model.enums;

/**
 * <pre>
 *     true or false enum
 * </pre>
 *
 * @author :ＸＩＡＮＳ
 */
public enum TrueFalseEnum {

    /**
     * 真
     */
    TRUE("true"),

    /**
     * 假
     */
    FALSE("false");

    private String desc;

    TrueFalseEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
