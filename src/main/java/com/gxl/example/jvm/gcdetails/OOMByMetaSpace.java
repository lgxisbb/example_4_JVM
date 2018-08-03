package com.gxl.example.jvm.gcdetails;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/2 17:06
 * @Description 重现OOM perm
 * -Xms2m -Xmx2m -XX:-UseGCOverheadLimit
 */
public class OOMByMetaSpace {

    /**
     * intern 会把创建的字符串加入到常量池中
     * 常量池不会被GC回收,所以到一定的程度后自动抛出OOM
     *
     * @param args
     */
    public static void main(String[] args) {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        List<String> l = new ArrayList();
        while (true) {
            l.add(UUID.randomUUID().toString().intern());
        }

    }
}
