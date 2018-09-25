package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/22
 */
public interface BrandApi {

    @GetMapping("brand/{id}")
    Brand queryById(@PathVariable("id") Long id);

    @GetMapping("brand/list")
    List<Brand> queryBrandsByIds(@RequestParam("ids") List<Long> ids);
}
