package com.yxt.yyd.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author dimengzhe
 * @Date 2022/2/9 21:52
 * @Description 工具类
 */
public class BeanUtils {


    /**
     * 获取String 类型
     *
     * @param map
     * @param keyName      键值对中键名称
     * @param defaultValue 默认值
     * @return
     */
    public static String getString(Map<String, Object> map, String keyName, String defaultValue) {
        if (map == null) {
            return defaultValue;
        }
        if (map.containsKey(keyName)) {
            Object o = map.get(keyName);
            if (o instanceof String) {
                return (String) o;
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    // 获取Integer
    public static Integer getInteger(Map<String, Object> map, String keyName) {
        if (map == null) {
            return -1;
        }
        if (map.containsKey(keyName)) {
            Object o = map.get(keyName);
            if (o instanceof Integer) {
                return (int) o;
            } else {
                return -1;
            }

        } else {
            return -1;
        }
    }

    //获取map类型
    public static Map<String, Object> getMap(Map<String, Object> map, String keyName) {
        if (map == null) {
            return new HashMap<>();
        }
        if (map.containsKey(keyName)) {
            Object o = map.get(keyName);
            if (o instanceof Map) {
                return (Map) o;
            } else {
                return new HashMap<>();
            }

        } else {
            return new HashMap<>();
        }
    }

    // 获取List类型
    public static List<Map<String, Object>> getListData(Map<String, Object> map, String keyName) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (map == null) {
            return list;
        }
        if (map.containsKey(keyName)) {
            Object o = map.get(keyName);
            if (o instanceof List) {
                for (int i = 0; i < ((List) o).size(); i++) {
                    Object o1 = ((List) o).get(i);
                    if (o1 instanceof Map) {
                        list.add((Map) o1);
                    }
                }
            }
        }
        return list;
    }


}
