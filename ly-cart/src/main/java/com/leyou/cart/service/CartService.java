package com.leyou.cart.service;

import com.leyou.auth.entity.UserInfo;
import com.leyou.cart.filter.LoginInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bystander
 * @date 2018/10/3
 */
@Service
@Slf4j
public class CartService {

    private static final String KEY_PREFIX = "ly:cart:uid:";
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 添加购物车到Redis中
     *
     * @param cart
     */
    public void addCart(Cart cart) {
        //获取用户信息
        UserInfo loginUser = LoginInterceptor.getLoginUser();

        String key = KEY_PREFIX + loginUser.getId();

        //获取商品ID
        String hashKey = cart.getSkuId().toString();

        //获取数量
        Integer num = cart.getNum();

        //获取hash操作的对象
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(key);

        if (hashOps.hasKey(hashKey)) {
            //Redis中有该商品，修改数量
            cart = JsonUtils.toBean(hashOps.get(hashKey).toString(), Cart.class);
            cart.setNum(num + cart.getNum());

        }

        //存入Redis中
        hashOps.put(hashKey, JsonUtils.toString(cart));


    }

    public List<Cart> listCart() {

        //获取登录用户
        UserInfo loginUser = LoginInterceptor.getLoginUser();

        //获取该用户Redis中的key
        String key = KEY_PREFIX + loginUser.getId();

        if (!redisTemplate.hasKey(key)) {
            //Redis中没有给用户信息
            return null;
        }
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(key);

        List<Object> carts = hashOps.values();

        if (CollectionUtils.isEmpty(carts)) {
            //购物车中无数据
            return null;
        }

        return carts.stream().map(s -> JsonUtils.toBean(s.toString(), Cart.class)).collect(Collectors.toList());
    }

    public void updateNum(Long id, Integer num) {
        //获取登录的用户
        UserInfo loginUser = LoginInterceptor.getLoginUser();
        String key = KEY_PREFIX + loginUser.getId();

        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(key);

        if (!hashOps.hasKey(id.toString())) {
            //该商品不存在
            throw new RuntimeException("购物车商品不存在, 用户：" + loginUser.getId() + ", 商品：" + id);
        }
        //查询购物车商品
        Cart cart = JsonUtils.toBean(hashOps.get(id.toString()).toString(), Cart.class);

        //修改数量
        cart.setNum(num);

        //写回Redis
        hashOps.put(id.toString(), JsonUtils.toString(cart));
    }

    public void deleteCart(Long id) {
        //获取登录的用户
        UserInfo loginUser = LoginInterceptor.getLoginUser();
        String key = KEY_PREFIX + loginUser.getId();

        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(key);

        if (!hashOps.hasKey(id.toString())) {
            //该商品不存在
            throw new RuntimeException("购物车商品不存在, 用户：" + loginUser.getId() + ", 商品：" + id);
        }

        //删除商品
        hashOps.delete(id.toString());
    }

    @Transactional
    public void deleteCarts(List<Object> ids, Integer userId) {
        String key = KEY_PREFIX + userId;
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(key);


        for (Object id : ids) {
            hashOps.delete(id.toString());
        }
    }
}
