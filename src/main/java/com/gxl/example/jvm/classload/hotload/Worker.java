package com.gxl.example.jvm.classload.hotload;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/10 16:15
 * @Description
 */
public class Worker {

    /**
     * 输出一句话
     */
    public void print() {
        System.out.println("I'm Loading in " + Worker.class.getClassLoader());
        System.out.println(" I'm Worker instance . v1.1");
    }
}
