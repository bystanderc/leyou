package com.leyou.service.web;

import com.leyou.item.pojo.Category;
import com.leyou.service.service.BrandService;
import com.leyou.service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/15
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid) {
        List<Category> categoryList = categoryService.queryCategoryByPid(pid);
        return ResponseEntity.ok(categoryList);
    }

    /**
     * 根据品牌ID查询商品分类
     *
     * @param bid
     * @return
     */
    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> queryBrandByBid(@PathVariable("bid") Long bid) {
        return ResponseEntity.ok(brandService.queryBrandByBid(bid));
    }
}
