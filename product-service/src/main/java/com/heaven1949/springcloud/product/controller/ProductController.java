package com.heaven1949.springcloud.product.controller;

import com.heaven1949.springcloud.product.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理器
 *
 * @author zhangjian
 * @date 2021年06月01日 11:40:19
 */
@RestController("/product")
public class ProductController {

    @GetMapping("/list")
    public Object selectProductList() {
        List<ProductDTO> list = new ArrayList<>();
        list.add(ProductDTO.builder().id(1L).productName("陕西红富士苹果🍎1.5公斤").productType("苹果").productPrice(new BigDecimal("12.55")).build());
        list.add(ProductDTO.builder().id(2L).productName("海南香蕉🍌5.5公斤").productType("香蕉").productPrice(new BigDecimal("22.85")).build());
        return list;
    }

}