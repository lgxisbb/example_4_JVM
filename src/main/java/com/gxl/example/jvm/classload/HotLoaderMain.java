package com.gxl.example.jvm.classload;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/3 17:21
 * @Description 热加载
 */
public class HotLoaderMain {

    static int i;

    static {
        i +=5 ;
    }
    public static void main(String[] args) {

        System.out.println(i);
    }
}
