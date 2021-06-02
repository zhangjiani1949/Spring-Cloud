package com.heaven1949.springcloud.order.client.fallback;

import com.heaven1949.springcloud.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 针对商品服务，错降级处理
 *
 * @author zhangjian
 * @date 2021年06月01日 18:46:27
 */
@Slf4j
@Component
public class ProductClientFallback implements ProductClient {

    @Override
    public String selectById(Long id) {
        log.info("商品信息服务异常（根据id[" + id + "]查询商品信息），进行降级处理");
        // TODO: 2021/06/01 降级处理
        return "商品信息服务异常（根据id查询商品信息），进行降级处理";
    }

}