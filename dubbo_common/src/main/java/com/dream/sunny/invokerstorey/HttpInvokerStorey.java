package com.dream.sunny.invokerstorey;

import com.dream.sunny.Invocation;
import com.dream.sunny.URL;
import com.dream.sunny.protocol.http.HttpClient;

/**
 * @author liming.kuang
 * @date 2022/11/15 20:51
 * @description
 */
public class HttpInvokerStorey implements Invoker {
    private final URL url;

    public HttpInvokerStorey(URL url) {
        this.url = url;
    }

    @Override
    public String invoker(Invocation invocation) {
        return new HttpClient().send(url.getIpAddress(), url.getPort(), invocation);
    }
}
