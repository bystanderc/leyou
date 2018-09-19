package com.leyou.item.bo;

import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author bystander
 * @date 2018/9/19
 */
public class SpuBo extends Spu {

    //商品分类名
    @Transient
    private String cname;

    //商品品牌名
    @Transient
    private String bname;

    //spu详情
    @Transient
    private SpuDetail spuDetail;

    //sku集合
    @Transient
    private List<Sku> skuList;

}
