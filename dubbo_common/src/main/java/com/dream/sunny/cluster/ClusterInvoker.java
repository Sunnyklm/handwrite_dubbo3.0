package com.dream.sunny.cluster;

import com.dream.sunny.Invocation;
import com.dream.sunny.URL;
import com.dream.sunny.invokerstorey.Invoker;
import com.dream.sunny.protocolstorey.Protocol;
import com.dream.sunny.protocolstorey.ProtocolFactory;
import com.dream.sunny.register.RegisterCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liming.kuang
 * @date 2022/11/15 21:15
 * @description
 */
public class ClusterInvoker implements Invoker {

    static List<Invoker> randomList = new ArrayList<>();

    public static Invoker join(String name) {
        List<URL> urlList = RegisterCenter.get(name);

        for (URL url : urlList) {
            Protocol protocol = ProtocolFactory.get(url);
            randomList.add(protocol.refer());
        }

        return new ClusterInvoker();
    }


    @Override
    public String invoker(Invocation invocation) {

        Invoker random = LoadBalance.random(randomList);

        return random.invoker(invocation);
    }
}
