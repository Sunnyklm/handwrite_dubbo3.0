package com.dream.sunny.service;

import com.dream.sunny.api.HelloService;

import java.io.Serializable;

/**
 * @author liming.kuang
 * @date 2022/11/15 13:50
 * @description
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "调用结果:" + name;
    }
}
