package com.heaven1949.springcloud.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * OrderDTO
 *
 * @author zhangjian
 * @date 2021年06月01日 14:04:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 订单总价
     */
    private BigDecimal totalPrice;
    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

}