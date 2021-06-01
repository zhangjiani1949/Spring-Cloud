package com.heaven1949.springcloud.order.controller;

import cn.hutool.core.lang.UUID;
import com.heaven1949.springcloud.order.dto.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单管理器
 *
 * @author zhangjian
 * @date 2021年06月01日 11:40:19
 */
@RestController("/order")
public class OrderController {

    @GetMapping("/list")
    public Object selectProductList() {
        List<OrderDTO> list = new ArrayList<>();
        list.add(OrderDTO.builder().id(1L).orderNo(UUID.fastUUID().toString()).orderStatus("未支付").createTime(new Date()).build());
        list.add(OrderDTO.builder().id(2L).orderNo(UUID.fastUUID().toString()).orderStatus("已完成").createTime(new Date()).build());
        return list;
    }

}