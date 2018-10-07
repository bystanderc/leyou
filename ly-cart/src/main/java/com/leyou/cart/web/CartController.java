package com.leyou.cart.web;

import com.leyou.cart.pojo.Cart;
import com.leyou.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bystander
 * @date 2018/10/3
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加商品到购物车
     *
     * @param cart
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
        return ResponseEntity.ok().build();
    }


    /**
     * 从购物车中删除商品
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.ok().build();
    }


    /**
     * 更新购物车中商品的数量
     *
     * @param id  商品ID
     * @param num 修改后的商品数量
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateNum(@RequestParam("id") Long id, @RequestParam("num") Integer num) {
        cartService.updateNum(id, num);
        return ResponseEntity.ok().build();
    }


    /**
     * 查询购物车
     *
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Cart>> listCart() {
        return ResponseEntity.ok(cartService.listCart());
    }


}
