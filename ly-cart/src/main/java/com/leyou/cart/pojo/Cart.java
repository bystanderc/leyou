package com.leyou.cart.pojo;

import lombok.Data;

/**
 * @author bystander
 * @date 2018/10/3
 */
@Data
public class Cart {

    //商品id
    private Long skuId;

    //商品标题
    private String title;

    //购买数量
    private Integer num;

    //商品图片
    private String image;

    //加入购物车时商品的价格
    private Long price;

    //商品的规格参数
    private String ownSpec;
}
