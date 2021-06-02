package com.heaven1949.springcloud.product.controller;

import com.heaven1949.springcloud.product.dto.ProductDTO;
import com.heaven1949.springcloud.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品管理器
 *
 * @author zhangjian
 * @date 2021年06月01日 11:40:19
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    // 集群情况下，用于订单服务查看到底调用的是哪个商品微服务节点
    @Value("${server.port}")
    private String port;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductDTO> selectProductList() {
        return productService.selectProductList();
    }

    @GetMapping("/{id}")
    public ProductDTO selectById(@PathVariable Long id) {
        ProductDTO productDTO = productService.selectById(id);
        ProductDTO result = new ProductDTO();
        BeanUtils.copyProperties(productDTO, result);
        result.setName(productDTO.getName() + ":" + port);
        return result;
    }

}