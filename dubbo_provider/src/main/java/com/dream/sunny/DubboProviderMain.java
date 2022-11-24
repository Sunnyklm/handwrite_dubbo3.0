package com.dream.sunny;


import com.dream.sunny.api.HelloService;
import com.dream.sunny.protocolstorey.Protocol;
import com.dream.sunny.protocolstorey.ProtocolFactory;
import com.dream.sunny.register.RegisterCenter;
import com.dream.sunny.service.HelloServiceImpl;

/**
 * @author liming.kuang
 * @date 2022/11/15 13:46
 * @description
 */
public class DubboProviderMain {

    public static void main(String[] args) {

        URL url = new URL("http", "localhost", 8080, HelloService.class.getName(), HelloServiceImpl.class);
        Protocol protocol = ProtocolFactory.get(url);
        protocol.export();
    }
}
