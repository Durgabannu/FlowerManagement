package com.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.dto.OrderDTO;

@FeignClient(name = "OrderServices", url = "http://localhost:8082") 
public interface OrderServiceFeignClient {
	 @PostMapping("/orders")
	    OrderDTO createOrder(@RequestBody OrderDTO orderDTO);

}
