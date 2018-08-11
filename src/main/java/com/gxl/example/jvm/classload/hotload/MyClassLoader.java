package com.gxl.example.jvm.classload.hotload;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/11 10:43
 * @Description 我的类加载器
 */
public class MyClassLoader extends URLClassLoader {


    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        // 这个时候就会去找自己加载的类
        Class<?> c = findLoadedClass(name);

        if (c == null) {
            try {
                c = findClass(name);
            } catch (Exception e) {
                //ignore
            }
        }

        if (null == c) {
            c = super.loadClass(name, resolve);
        }
        return c;
    }

}
