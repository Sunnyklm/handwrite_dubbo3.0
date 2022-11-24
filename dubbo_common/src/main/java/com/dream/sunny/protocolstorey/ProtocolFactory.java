package com.dream.sunny.protocolstorey;

import com.dream.sunny.URL;

/**
 * @author liming.kuang
 * @date 2022/11/15 17:52
 * @description
 */
public class ProtocolFactory {


    public static Protocol get(URL url) {

        switch (url.getProtocol()) {
            case "dubbo":
                return new DubboProtocolStorey();
            case "http":
            default:
                return new HttpProtocolStorey(url);
        }
    }


}
