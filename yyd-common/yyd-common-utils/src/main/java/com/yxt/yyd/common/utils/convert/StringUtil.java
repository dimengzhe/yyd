package com.yxt.yyd.common.utils.convert;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * @Author dimengzhe
 * @Date 2022/7/23 23:38
 * @Description
 */
public class StringUtil extends StringUtils {

    /**
     * 空字符串
     */
    private static final String NULLSTR = "";

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';

    /**
     * 星号
     */
    private static final String START = "*";

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }


    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 查找指定字符串是否匹配指定字符串列表中的任意一个字符串
     *
     * @param str  指定字符串
     * @param strs 需要检查的字符串数组
     * @return 是否匹配
     */
    public static boolean matchesTwo(String str, List<String> strs) {
        if (isEmpty(str) || isEmpty(strs)) {
            return false;
        }
        for (String testStr : strs) {
            if (matchesTwo(str, testStr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(String str, List<String> strs) {
        if (isEmpty(str) || isEmpty(strs)) {
            return false;
        }
        for (String testStr : strs) {
            if (matches(str, testStr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(String str, String pattern) {
        if (isEmpty(pattern) || isEmpty(str)) {
            return false;
        }

        pattern = pattern.replaceAll("\\s*", ""); // 替换空格
        int beginOffset = 0; // pattern截取开始位置
        int formerStarOffset = -1; // 前星号的偏移位置
        int latterStarOffset = -1; // 后星号的偏移位置

        String remainingURI = str;
        String prefixPattern = "";
        String suffixPattern = "";

        boolean result = false;
        do {
            formerStarOffset = indexOf(pattern, START, beginOffset);
            prefixPattern = substring(pattern, beginOffset, formerStarOffset > -1 ? formerStarOffset : pattern.length());

            // 匹配前缀Pattern
            result = remainingURI.equals(prefixPattern);
            // 已经没有星号，直接返回
            if (formerStarOffset == -1) {
                return result;
            }

            // 匹配失败，直接返回
            if (!result) {
                return false;
            }
            if (!isEmpty(prefixPattern)) {
                remainingURI = substringAfter(str, prefixPattern);
            }

            // 匹配后缀Pattern
            latterStarOffset = indexOf(pattern, START, formerStarOffset + 1);
            suffixPattern = substring(pattern, formerStarOffset + 1, latterStarOffset > -1 ? latterStarOffset : pattern.length());

            result = remainingURI.equals(suffixPattern);
            // 匹配失败，直接返回
            if (!result) {
                return false;
            }
            if (!isEmpty(suffixPattern)) {
                remainingURI = substringAfter(str, suffixPattern);
            }

            // 移动指针
            beginOffset = latterStarOffset + 1;

        }
        while (!isEmpty(suffixPattern) && !isEmpty(remainingURI));

        return true;
    }

    /**
     * 查找指定字符串是否匹配
     *
     * @param str     指定字符串
     * @param pattern 需要检查的字符串
     * @return 是否匹配
     */
    public static boolean matchesTwo(String str, String pattern) {
        if (isEmpty(pattern) || isEmpty(str)) {
            return false;
        }
        pattern = pattern.replaceAll("\\s*", ""); // 替换空格
        int beginOffset = 0; // pattern截取开始位置
        int formerStarOffset = -1; // 前星号的偏移位置
        int latterStarOffset = -1; // 后星号的偏移位置

        String remainingURI = str;
        String prefixPattern = "";
        String suffixPattern = "";

        boolean result = false;
        do {
            formerStarOffset = indexOf(pattern, START, beginOffset);
            prefixPattern = substring(pattern, beginOffset, formerStarOffset > -1 ? formerStarOffset : pattern.length());

            // 匹配前缀Pattern
            result = remainingURI.contains(prefixPattern);
            // 已经没有星号，直接返回
            if (formerStarOffset == -1) {
                return result;
            }

            // 匹配失败，直接返回
            if (!result) {
                return false;
            }
            if (!isEmpty(prefixPattern)) {
                remainingURI = substringAfter(str, prefixPattern);
            }

            // 匹配后缀Pattern
            latterStarOffset = indexOf(pattern, START, formerStarOffset + 1);
            suffixPattern = substring(pattern, formerStarOffset + 1, latterStarOffset > -1 ? latterStarOffset : pattern.length());

            result = remainingURI.contains(suffixPattern);
            // 匹配失败，直接返回
            if (!result) {
                return false;
            }
            if (!isEmpty(suffixPattern)) {
                remainingURI = substringAfter(str, suffixPattern);
            }

            // 移动指针
            beginOffset = latterStarOffset + 1;
        }
        while (!isEmpty(suffixPattern) && !isEmpty(remainingURI));
        return true;
    }
}
