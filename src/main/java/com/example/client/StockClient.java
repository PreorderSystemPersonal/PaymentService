package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="stockClient",url = "${feign.stockClient.url}")
public interface StockClient {
    //재고 생성
    @RequestMapping(method= RequestMethod.POST, value = "/api/internal/stock/increase",consumes = "application/json")
    void increase(@RequestParam(name = "id") Long productId, @RequestParam(name="stock") Long stock);}