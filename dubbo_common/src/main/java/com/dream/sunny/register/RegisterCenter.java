package com.dream.sunny.register;

import com.dream.sunny.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liming.kuang
 * @date 2022/11/15 17:28
 * @description 注册中心 -> zk/redis/nacos
 */
public class RegisterCenter {

    public static Map<String, List<URL>> centerMap = new ConcurrentHashMap<>();

    public static void register(String interfaceName, URL url) {

        List<URL> urlList = centerMap.get(interfaceName);

        if (urlList == null) {
            urlList = new ArrayList<>();
        }

        urlList.add(url);
        centerMap.put(interfaceName, urlList);
        saveFile();
    }

    public static List<URL> get(String key) {
        centerMap = getFile();
        if (centerMap != null) {
            return centerMap.get(key);
        }
        return null;
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/kuangliming/learnspace/exercise_project/dubbo/rpc/temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(centerMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/kuangliming/learnspace/exercise_project/dubbo/rpc/temp.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
