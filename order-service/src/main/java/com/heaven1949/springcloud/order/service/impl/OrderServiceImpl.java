package com.heaven1949.springcloud.order.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.heaven1949.springcloud.order.client.ProductClient;
import com.heaven1949.springcloud.order.dto.OrderDTO;
import com.heaven1949.springcloud.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * OrderServiceImpl
 *
 * @author zhangjian
 * @date 2021年06月01日 15:11:35
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductClient productClient;

    @Override
    public OrderDTO save(Long userId, Long productId) {
        log.info("开始下单，userId：[{}]，productId：[{}]", userId, productId);
        String response = productClient.selectById(productId);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        System.out.println(response);
        // 因为在商品微服务配置了集群，所以这里打印看下调用了是哪个集群节点，输出端口号
        return OrderDTO.builder()
                .userId(userId)
                .orderNo(UUID.fastUUID().toString())
                .productName(jsonObject.get("name").toString())
                .totalPrice(new BigDecimal(jsonObject.get("price").toString()))
                .createTime(LocalDateTime.now())
                .build();
    }

}