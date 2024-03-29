package com.heaven1949.springcloud.order.controller;

import com.heaven1949.springcloud.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 订单管理器
 *
 * @author zhangjian
 * @date 2021年06月01日 11:40:19
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final StringRedisTemplate redisTemplate;

    public OrderController(OrderService orderService, StringRedisTemplate redisTemplate) {
        this.orderService = orderService;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 下单
     * 当调用微服务出现异常会降级到saveOrderFail方法中
     *
     * @param userId    用户id
     * @param productId 产品id
     * @return
     */
    @GetMapping("/save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object selectProductList(HttpServletRequest request, @RequestParam Long userId, @RequestParam Long productId) {
        return orderService.save(userId, productId);
    }

    /**
     * 下单失败的降级处理方法（参数个数、顺序需和上面保持一致，出参也一样）
     *
     * @param userId
     * @param productId
     * @return
     */
    private Object saveOrderFail(HttpServletRequest request, Long userId, Long productId) {
        System.out.println("进入OrderController中的降级方法");

        String saveOrderKye = String.format("save-order-fail:userId:%s:productId:%s", userId, productId);
        // 有数据代表60秒内已经发过
        String sendValue = redisTemplate.opsForValue().get(saveOrderKye);
        final String ip = request.getRemoteAddr();

        // 新启动一个线程进行业务逻辑处理
        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                redisTemplate.opsForValue().set(saveOrderKye, "紧急提醒，用户下单失败，userId：[" + userId + "]，productId：[" + productId + "]请查找原因，ip地址：" + ip,
                        60, TimeUnit.SECONDS);
            } else {
                System.out.println("userId：[" + userId + "]，productId：[" + productId + "]已经发送过短信，60秒内不重复发送");
            }
        }).start();

        Map<String, Object> msg = new HashMap<>(2);
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，请稍后重试");
        return msg;
    }

}