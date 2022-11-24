package com.dream.sunny.protocol.http;

import com.dream.sunny.Invocation;
import com.dream.sunny.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liming.kuang
 * @date 2022/11/15 13:52
 * @description 容器
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        try {
            // 获取传输的结果
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            // 获取到
            Class<?> interfaceImplClass = LocalRegister.getInterface(invocation.getInterfaceName());

            // 通过方法名称 + 参数类型列表 即可定位到具体执行哪一个方法
            Method method = interfaceImplClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());

            // 通过反射执行方法
            String result = (String) method.invoke(interfaceImplClass.newInstance(), invocation.getParamValues());

            // 将结果输出到 响应流中
            IOUtils.write(result, resp.getOutputStream());

            System.out.println(result);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {

            System.out.println("执行失败， 做任务补偿");

        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
