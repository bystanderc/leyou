package com.leyou.order.mapper;

import com.leyou.order.pojo.OrderDetail;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author bystander
 * @date 2018/10/4
 */
public interface OrderDetailMapper extends Mapper<OrderDetail>, InsertListMapper<OrderDetail> {
}
