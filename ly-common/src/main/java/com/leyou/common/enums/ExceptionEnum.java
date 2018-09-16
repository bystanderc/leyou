package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author bystander
 * @date 2018/9/15
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_NOT_NULL(400, "价格不能为空！"),
    CATEGORY_NOT_FOUND(404, "分类未查询到"),
    BRAND_NOT_FOUND(404, "品牌查询失败"),
    ;
    int value;
    String message;

    public int value() {
        return this.value;
    }

    public String message() {
        return this.message;
    }


}
