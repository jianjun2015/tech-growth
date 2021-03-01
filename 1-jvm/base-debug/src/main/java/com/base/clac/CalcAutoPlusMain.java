package com.base.clac;

/**
 * @author jianjun1.wang
 * @version 1.0
 * @description:
 * @date 2021/3/1 17:09
 */
public class CalcAutoPlusMain {

    public static void main(String[] args) {

        Integer num1 = 1;
        Integer num2 = 1;
        Integer num3 = 1;
        Integer num4 = 1;
        Integer num5 = 1;

        Integer result1 = num1++;
        Integer result2 = ++num2;
        Integer result3 = num5 + 1;

        /**1*/
        System.out.println(result1);
        /**2*/
        System.out.println(num1);
        /**2*/
        System.out.println(result2);
        /**2*/
        System.out.println(num2);
        /**1*/
        System.out.println(num3++);
        /**2*/
        System.out.println(++num4);
        /**2*/
        System.out.println(result3);


    }

}
