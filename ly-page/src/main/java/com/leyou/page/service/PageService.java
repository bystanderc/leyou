package com.leyou.page.service;

import com.leyou.item.pojo.*;
import com.leyou.page.client.BrandClient;
import com.leyou.page.client.CategoryClient;
import com.leyou.page.client.GoodsClient;
import com.leyou.page.client.SpecClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bystander
 * @date 2018/9/26
 */
@Slf4j
@Service
public class PageService {

    @Autowired
    private BrandClient brandClient;

    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private SpecClient specClient;

    @Autowired
    private TemplateEngine templateEngine;

    public Map<String, Object> loadModel(Long spuId) {
        Map<String, Object> model = new HashMap<>();
        Spu spu = goodsClient.querySpuBySpuId(spuId);
        SpuDetail detail = spu.getSpuDetail();
        List<Sku> skus = spu.getSkus();
        Brand brand = brandClient.queryById(spu.getBrandId());
        //查询三级分类
        List<Category> categories = categoryClient.queryByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));

        List<SpecGroup> specs = specClient.querySpecsByCid(spu.getCid3());

        model.put("brand", brand);
        model.put("categories", categories);
        model.put("spu", spu);
        model.put("skus", skus);
        model.put("detail", detail);
        model.put("specs", specs);
        return model;
    }

    public  void createHtml(Long spuId) {
        Context context = new Context();
        Map<String, Object> map = loadModel(spuId);
        context.setVariables(map);

        try (PrintWriter writer = new PrintWriter(new File("/Users/bystander/upload", spuId + ".html"))) {
            templateEngine.process("item", context, writer);
        } catch (Exception e) {
            log.error("【静态页服务】生成静态页面异常", e);
        }
    }
}
