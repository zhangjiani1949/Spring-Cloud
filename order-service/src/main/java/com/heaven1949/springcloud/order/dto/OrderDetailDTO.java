package com.heaven1949.springcloud.order.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * OrderDetailDTO
 *
 * @author zhangjian
 * @date 2021年06月01日 14:09:09
 */
@Data
@Builder
public class OrderDetailDTO {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单总价
     */
    private BigDecimal totalPrice;
    /**
     * 产品id
     */
    private Long productId;

}