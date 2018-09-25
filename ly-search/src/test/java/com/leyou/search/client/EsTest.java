package com.leyou.search.client;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Spu;
import com.leyou.search.pojo.Goods;
import com.leyou.search.repository.GoodsRepository;
import com.leyou.search.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bystander
 * @date 2018/9/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private GoodsRepository repository;

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private SearchService searchService;

    @Test
    public void testCreateIndex() {
        template.createIndex(Goods.class);
        template.putMapping(Goods.class);
    }

    @Test
    public void loadData() {
        int page = 1;
        int size = 0;
        int rows = 100;
        do {
            PageResult<Spu> result = goodsClient.querySpuByPage(page, rows, true, null);
            ArrayList<Goods> goodList = new ArrayList<>();
            List<Spu> spus = result.getItems();
            size = spus.size();
            for (Spu spu : spus) {
                try {
                    Goods g = searchService.buildGoods(spu);
                    goodList.add(g);

                } catch (Exception e) {
                    break;
                }
            }
            this.repository.saveAll(goodList);
            page++;
        } while (size == 100);
    }
}
