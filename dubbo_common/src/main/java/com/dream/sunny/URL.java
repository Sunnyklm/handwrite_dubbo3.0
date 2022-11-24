package com.dream.sunny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liming.kuang
 * @date 2022/11/15 17:29
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URL implements Serializable {

    private static final long serialVersionUID = 1455639671768943361L;

    /**
     * 协议类型
     */
    private String protocol;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 接口名称
     */
    private String interfaceName;

    /**
     * 实现类
     */
    private Class<?> interfaceType;
}
