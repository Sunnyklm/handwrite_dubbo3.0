package com.dream.sunny.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liming.kuang
 * @date 2022/11/15 15:51
 * @description
 */
public class LocalRegister {

    public static Map<String, Class<?>> localRegisterMap = new ConcurrentHashMap<>();

    public static void localRegister(String interfaceName, Class<?> interfaceType) {
        localRegisterMap.put(interfaceName, interfaceType);
    }

    public static Class<?> getInterface(String interfaceName) {
        return localRegisterMap.get(interfaceName);
    }
}
