package com.dream.sunny.protocolstorey;

import com.dream.sunny.URL;
import com.dream.sunny.invokerstorey.HttpInvokerStorey;
import com.dream.sunny.invokerstorey.Invoker;
import com.dream.sunny.protocol.http.HttpServer;
import com.dream.sunny.register.LocalRegister;
import com.dream.sunny.register.RegisterCenter;

/**
 * @author liming.kuang
 * @date 2022/11/15 17:58
 * @description
 */
public class HttpProtocolStorey implements Protocol {

    private final URL url;

    public HttpProtocolStorey(URL url) {
        this.url = url;
    }

    @Override
    public void export() {
        LocalRegister.localRegister(url.getInterfaceName(), url.getInterfaceType());

        RegisterCenter.register(url.getInterfaceName(), url);

        new HttpServer().start(url.getIpAddress(), url.getPort());
    }

    @Override
    public Invoker refer() {
        return new HttpInvokerStorey(url);
    }
}
