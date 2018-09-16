package com.leyou.service.service;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/15
 */
public interface BrandService {

    PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key);

    void saveBrand(Brand brand, List<Long> cids);
}
