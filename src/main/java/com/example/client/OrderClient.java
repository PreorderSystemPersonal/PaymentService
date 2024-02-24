package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="OrderClient",url = "${feign.OrderClient.url}")
public interface OrderClient {

    //feignclient 성공 여부
    @RequestMapping(method= RequestMethod.GET, value="/api/internal/order", consumes = "application/json")
    void success();

    //결제 실패로 인한 주문 취소 요청
    @RequestMapping(method= RequestMethod.POST, value="/api/internal/order/cancel", consumes = "application/json")
    void cancel(@RequestParam(name = "id") Long orderId);
}
