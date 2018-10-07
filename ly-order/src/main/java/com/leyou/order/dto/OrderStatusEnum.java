package com.leyou.order.dto;

/**
 * @author bystander
 * @date 2018/10/5
 */
public enum  OrderStatusEnum {

    INIT(1, "初始化，未付款"),
    PAY_UP(2, "已付款，未发货"),
    DELIVERED(3, "已发货，未确认"),
    CONFIRMED(4, "已确认,未评价"),
    CLOSED(5, "已关闭"),
    RATED(6, "已评价，交易结束")
    ;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer value(){
        return this.code;
    }

    public String msg(){
        return msg;
    }
}
