package com.heaven1949.springcloud.order.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * OrderDTO
 *
 * @author zhangjian
 * @date 2021年06月01日 14:04:13
 */
@Data
@Builder
public class OrderDTO {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单状态（1-未支付；2-已支付；3-已发货；4-已完成）
     */
    private String orderStatus;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 订单明细
     */
    private List<OrderDetailDTO> details;

}