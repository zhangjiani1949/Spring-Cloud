package com.heaven1949.springcloud.product.service.impl;

import cn.hutool.core.lang.Assert;
import com.heaven1949.springcloud.product.dto.ProductDTO;
import com.heaven1949.springcloud.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProductServiceImpl
 *
 * @author zhangjian
 * @date 2021年06月01日 14:57:41
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Long, ProductDTO> PRODUCT_MAP = new HashMap<>();

    // 模拟数据库商品数据
    static {
        ProductDTO p1 = new ProductDTO(1L, "苹果X", new BigDecimal("9999"), 10);
        ProductDTO p2 = new ProductDTO(2L, "冰箱", new BigDecimal("5342"), 19);
        ProductDTO p3 = new ProductDTO(3L, "洗衣机", new BigDecimal("523"), 90);
        ProductDTO p4 = new ProductDTO(4L, "电话", new BigDecimal("64345"), 150);

        PRODUCT_MAP.put(p1.getId(), p1);
        PRODUCT_MAP.put(p2.getId(), p2);
        PRODUCT_MAP.put(p3.getId(), p3);
        PRODUCT_MAP.put(p4.getId(), p4);
    }

    @Override
    public List<ProductDTO> selectProductList() {
        log.info("开始查询商品信息列表");
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    @Override
    public ProductDTO selectById(Long id) {
        log.info("开始根据id查询商品信息，id：[{}]", id);
        ProductDTO productDTO = PRODUCT_MAP.get(id);
        Assert.notNull(productDTO, String.format("未查询到id为[%s]的商品信息", id));
        return productDTO;
    }

}