package com.gxl.example.jvm.classload.hotload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/3 17:21
 * @Description 热加载
 */
public class HotLoaderMain {

    private MyClassLoader cl;
    private Object worker;
    private long lastTime;
    private String classPath = "com.gxl.example.jvm.classload.hotload.Worker";

    public static void main(String[] args) {
        new HotLoaderMain().exec();
    }

    public void exec() {

        if (checkIsNeedReload(classPath)) {
            System.out.println("需要重新加载");
            reload();
            System.out.println("重新加载完毕");
        }

        try {
            invoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkIsNeedReload(String className) {
        String cn = className.replace(".", "/");
        URL resource = ClassLoader.getSystemResource(cn + ".class");
        File file = new File(resource.getPath());
        long l = file.lastModified();
        if (l > lastTime) {
            lastTime = l;
            return true;
        }

        return false;
    }


    public static byte[] getClassByteCode(String className) throws IOException {

        URL resource = ClassLoader.getSystemResource(className);
        File f = new File(resource.getPath());
        if (!f.exists()) {
            throw new RuntimeException(className + " class file not exists");
        }

        byte[] bytes = new byte[(int) f.length()];

        InputStream in = ClassLoader.getSystemResourceAsStream(className);
        in.read(bytes, 0, bytes.length);
        return bytes;
    }


    public void reload() {
        URL resource = ClassLoader.getSystemResource("");
        cl = new MyClassLoader(new URL[]{resource});
        try {
//            byte[] classByteCode = getClassByteCode(c);
//            cl.defClass(classByteCode);
            // 这里不能
            worker = cl.loadClass(this.classPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void invoke() throws Exception {
        Method print = worker.getClass().getDeclaredMethod("print");
        print.invoke(worker);
    }
}
