package com.gxl.example.jvm.classload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/3 11:30
 * @Description 类加载器运行类
 * <p>
 * 增加指定参数 使得 TempLoader 加载进了 BootLoader
 * -Xbootclasspath/a:/Users/apple/project/example_4_JVM/src/main/java
 * 输出 I'am loader by null
 * 使用AppLoader加载TempLoader的字节流
 * 输出 I'am loader by sun.misc.Launcher$AppClassLoader@18b4aac2
 */
public class TempLoaderMain {

    public static void main(String[] args) throws Exception {
        ClassLoader cl = TempLoaderMain.class.getClassLoader();

        // boot loader
        TempLoader bootLoader = new TempLoader();
        bootLoader.print();

//         使得AppClassLoader 加载TempLoader类
        byte[] classBytes = loadClassBytes("com.gxl.example.jvm.classload.TempLoader");
        Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
        defineClass.setAccessible(true);
        defineClass.invoke(cl, classBytes, 0, classBytes.length);
        defineClass.setAccessible(false);

        TempLoader appLoader = new TempLoader();
        appLoader.print();
    }


    /**
     * 读取 className 的字节流
     *
     * @param className
     * @return
     * @throws IOException
     */
    public static byte[] loadClassBytes(String className) throws IOException {

        String path = new StringBuilder(className.replace(".", "/")).append(".class").toString();

        InputStream in = ClassLoader.getSystemResourceAsStream(path);
        URL absPath = ClassLoader.getSystemResource(path);
        File file = new File(absPath.getPath());
        byte[] bytes = new byte[Long.valueOf(file.length()).intValue()];
        in.read(bytes);
        return bytes;
    }
}
