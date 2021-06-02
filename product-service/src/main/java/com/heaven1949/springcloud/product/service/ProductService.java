package com.heaven1949.springcloud.product.service;

import com.heaven1949.springcloud.product.dto.ProductDTO;

import java.util.List;

/**
 * ProductService
 *
 * @author zhangjian
 */
public interface ProductService {

    /**
     * 查询所有商品信息
     *
     * @return
     */
    List<ProductDTO> selectProductList();

    /**
     * 根据商品id查询商品信息
     *
     * @param id
     * @return
     */
    ProductDTO selectById(Long id);

}
