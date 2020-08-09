package com.book.thinkinginjava.doc.regex.string;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author jojo
 * @create 2020/2/28 下午9:44
 */
public class StringRegex {

    /**
     * ? 1个或0个
     * × 0个或多个
     * + 一个或多个
     * \d 表示一位数字
     * \\ java中表示"插入一个正则表达式的反斜线"，例表示一位数字“\\d”
     * + 在正则中有特殊意义，所以加"\\"转义
     * \W 非单词字符
     * \w 一个单词字符
     * . 任意字符
     * ^ 行开头
     * $ 结尾
     * * 0到任意多个
     */

    public static void main(String[] args) {
        /*System.out.println("1234".matches("\\d+"));
        System.out.println("+1234".matches("-?\\d+"));
        System.out.println("+1234".matches("(\\+|-)\\d+"));
        System.out.println("-1234".matches("(\\+|-)\\d+"));
        System.out.println("1234".matches("(\\+|-)?\\d+"));*/

        /*upperCasePoint("W123..");
        split("batch");
        splitByYuanYin("我门a是e祖国的i花朵ou");*/

        System.out.println("1个或零个X---------------------------");
        System.out.println("X".matches("X?"));
        System.out.println("XX".matches("X?"));
        System.out.println("X".matches("X??"));
        System.out.println("XX".matches("X??"));
        System.out.println("零个或多个X---------------------------");
        System.out.println("X".matches("X*"));
        System.out.println("XX".matches("X*"));
        System.out.println("X".matches("X*?"));
        System.out.println("XX".matches("X*?"));
    }

    /**
     * 以大写字母开头+句号结尾
     */
    public static void upperCasePoint(String target) {
        System.out.println(target.matches("^[A-Z].*[.]$"));
    }

    /**
     * 在“a”和“c”处分割
     */
    public static void split(String target) {
        String[] split = target.split("[ac]");
        System.out.println(Arrays.toString(split));
    }

    public static void splitByYuanYin(String target) {
        String result = target.replaceAll("[aeiou]", "_");
        System.out.println(result);
    }

}
