package com.leyou.order.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_pay_log")
public class PayLog {
    @Id
    private Long orderId;
    private Long totalFee;
    private Long userId;
    private String transactionId;
    private Integer status;
    private Integer payType;
    private String bankType;
    private Date createTime;
    private Date payTime;
    private Date refundTime;
    private Date closedTime;
}