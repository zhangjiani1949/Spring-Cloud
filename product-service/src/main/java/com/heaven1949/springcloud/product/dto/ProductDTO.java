package com.heaven1949.springcloud.product.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ProductDTO
 *
 * @author zhangjian
 * @date 2021年06月01日 13:50:07
 */
@Data
@Builder
public class ProductDTO {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品种类
     */
    private String productType;
    /**
     * 单价
     */
    private BigDecimal productPrice;

}