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

    BRAND_CREATE_FAILED(500, "新增品牌失败"),
    CATEGORY_NOT_FOUND(204, "分类未查询到"),
    BRAND_NOT_FOUND(404, "品牌查询失败"),
    SPU_NOT_FOUND(201, "SPU未查询到"),
    SKU_NOT_FOUND(201, "SKU未查询到"),
    SPEC_GROUP_NOT_FOUND(204, "规格组查询失败"),
    SPEC_PARAM_NOT_FOUND(204, "规格参数查询失败"),
    UPDATE_BRAND_FAILED(500, "品牌更新失败"),
    DELETE_BRAND_EXCEPTION(500, "删除品牌失败"),
    INVALID_FILE_FORMAT(400, "文件格式错误"),
    UPLOAD_IMAGE_EXCEPTION(500, "文件上传异常"),
    INVALID_PARAM(400, "参数错误"),

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
