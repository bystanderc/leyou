package com.leyou.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bystander
 * @date 2018/10/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long skuId;  //商品skuId

    private Integer num;  //购买数量
}
