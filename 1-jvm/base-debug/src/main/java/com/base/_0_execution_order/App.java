package com.base._0_execution_order;

/**
 * @author jianjun1.wang
 * https://blog.csdn.net/Tommy5553/article/details/81301472
 * @version 1.0
 * @description:
 * @date 2021/3/1 17:19
 */

public class App {

    private static App d = new App();
    private SubClass t = new SubClass();

    static
    {
        System.out.println("App static");
    }

    public App()
    {
        System.out.println("App construct");
    }

    public static void main(String[] args)
    {
        System.out.println("App main");
    }
}

class SuperClass
{
    SuperClass()
    {
        System.out.println("SuperClass construct");
    }
}

class SubClass extends SuperClass
{
    static
    {
        System.out.println("SubClass static");
    }

    public SubClass()
    {
        System.out.println("SubClass construct");
    }
}
