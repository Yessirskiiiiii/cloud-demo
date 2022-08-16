package com.threewater.order.clients;

import com.threewater.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Yessirskiii
 * @Date: 2022/08/16/14:44
 * @Description: Feign 客户端
 */
@FeignClient("userService")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable long id);

}
