package com.heaven1949.springcloud.order.client;

import com.heaven1949.springcloud.order.client.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 商品服务客户端
 *
 * @author zhangjian
 * @date 2021年06月01日 18:11:55
 */
@FeignClient(name = "product-service", fallback = ProductClientFallback.class)
public interface ProductClient {

    /**
     * 根据id查询商品信息
     * 针对Feign调用，@PathVariable、@RequestParam等需求指定value值，否则会报错：PathVariable annotation was empty on param 0.
     *
     * @param id
     * @return
     */
    @GetMapping("/api/v1/product/{id}")
    String selectById(@PathVariable(value = "id") Long id);

}
