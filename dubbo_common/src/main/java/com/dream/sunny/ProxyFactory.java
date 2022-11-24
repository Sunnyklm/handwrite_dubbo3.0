package com.dream.sunny;

import com.dream.sunny.cluster.ClusterInvoker;
import com.dream.sunny.invokerstorey.HttpInvokerStorey;
import com.dream.sunny.invokerstorey.Invoker;
import com.dream.sunny.protocol.http.HttpClient;
import com.dream.sunny.protocolstorey.Protocol;
import com.dream.sunny.protocolstorey.ProtocolFactory;
import com.dream.sunny.register.RegisterCenter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author liming.kuang
 * @date 2022/11/15 16:49
 * @description
 */
public class ProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);

                // 负载均衡调用
                Invoker join = ClusterInvoker.join(interfaceClass.getName());
                return join.invoker(invocation);
            }
        });
    }

}
