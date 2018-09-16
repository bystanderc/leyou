package com.leyou.service.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author bystander
 * @date 2018/9/15
 */
@RestController
@RequestMapping("brand")
public class BrandController {


    @Autowired
    private BrandService brandService;


    /**
     * 分页查询品牌信息
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @RequestMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy",required = false)String sortBy,
            @RequestParam(value = "desc",defaultValue = "false")Boolean desc,
            @RequestParam(value = "key",required = false)String key
    ) {
        return ResponseEntity.ok(brandService.queryBrandByPageAndSort(page, rows, sortBy, desc, key));

    }


    /**
     * 新增品牌
     * @param brand
     * @param cids  品牌所在的分类ID（多个分类）
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        brandService.saveBrand(brand, cids);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
