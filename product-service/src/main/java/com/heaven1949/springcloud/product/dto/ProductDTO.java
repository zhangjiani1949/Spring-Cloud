package com.heaven1949.springcloud.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * ProductDTO
 *
 * @author zhangjian
 * @date 2021年06月01日 13:50:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 库存
     */
    private Integer stock;

}