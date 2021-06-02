package com.heaven1949.springcloud.order.service;

import com.heaven1949.springcloud.order.dto.OrderDTO;

/**
 * OrderService
 *
 * @author zhangjian
 */
public interface OrderService {

    /**
     * 下单
     *
     * @param userId    用户id
     * @param productId 商品id
     * @return
     */
    OrderDTO save(Long userId, Long productId);

}
