package com.gxl.example.jvm.classload;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/3 11:29
 * @Description 类加载器测试
 * <p>
 * I'am loader by sun.misc.Launcher$AppClassLoader@18b4aac2
 */
public class TempLoader {


    static {
        System.out.println("111");
    }

    public void print() {

        ClassLoader classLoader = TempLoader.class.getClassLoader();
        System.out.println("I'am loader by " + classLoader);
    }
}
