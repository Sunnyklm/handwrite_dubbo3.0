package com.dream.sunny;


import com.dream.sunny.api.HelloService;

/**
 * @author liming.kuang
 * @date 2022/11/15 15:38
 * @description
 */
public class DubboConsumerMain {


    public static void main(String[] args) {
//        String send = new HttpClient().send("localhost", 8080,
//                new Invocation("com.dream.sunny.api.HelloService", "sayHello", new Class[]{String.class}, new Object[]{"哈哈"}));
//        System.out.println(send);


        HelloService proxy = ProxyFactory.getProxy(HelloService.class);
        String s = proxy.sayHello("还好还好");
        System.out.println(s);
    }
}
