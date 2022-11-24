package com.dream.sunny.protocolstorey;

import com.dream.sunny.URL;
import com.dream.sunny.invokerstorey.Invoker;

/**
 * @author liming.kuang
 * @date 2022/11/15 17:54
 * @description
 */
public interface Protocol {

    /**
     * 服务注册
     */
    void export();

    /**
     * 数据获取
     *
     * @return
     */
    Invoker refer();
}
