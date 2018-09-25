package com.leyou.search.pojo;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;

import java.util.List;
import java.util.Map;

/**
 * @author bystander
 * @date 2018/9/23
 */

public class SearchResult<Goods> extends PageResult<Goods> {

    private List<Brand> brands;
    private List<Category> categories;
    //规格参数过滤条件
    private List<Map<String, Object>> specs;

    public SearchResult(Long total,
                        Integer totalPage,
                        List<Goods> items,
                        List<Category> categories,
                        List<Brand> brands,
                        List<Map<String, Object>> specs) {
        super(total, totalPage, items);
        this.categories = categories;
        this.brands = brands;
        this.specs = specs;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Map<String, Object>> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Map<String, Object>> specs) {
        this.specs = specs;
    }
}
