package com.dream.sunny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liming.kuang
 * @date 2022/11/15 15:28
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {

    private static final long serialVersionUID = 4998394819607680746L;
    /**
     * 接口名称
     */
    private String interfaceName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数类型列表
     */
    private Class<?>[] paramTypes;

    /**
     * 参数值列表
     */
    private Object[] paramValues;

}
