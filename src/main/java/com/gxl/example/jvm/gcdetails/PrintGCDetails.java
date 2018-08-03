package com.gxl.example.jvm.gcdetails;

/**
 * @Author Lucky Dragon
 * @CreateTime 2018/8/2 16:20
 * @Description 输出GC日志详情
 * 设置最大堆数 5MB
 * 设置最小堆数 5MB
 * -Xmx5M -Xms5M -XX:+PrintGCDetails
 * [GC (Allocation Failure) [PSYoungGen: 1024K->480K(1536K)] 1024K->496K(5632K), 0.0009326 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap
 * PSYoungGen      total 1536K, used 1205K [0x00000007bfe00000, 0x00000007c0000000, 0x00000007c0000000)
 * eden space 1024K, 70% used [0x00000007bfe00000,0x00000007bfeb5698,0x00000007bff00000)
 * from space 512K, 93% used [0x00000007bff00000,0x00000007bff78020,0x00000007bff80000)
 * to   space 512K, 0% used [0x00000007bff80000,0x00000007bff80000,0x00000007c0000000)
 * ParOldGen       total 4096K, used 16K [0x00000007bfa00000, 0x00000007bfe00000, 0x00000007bfe00000)
 * object space 4096K, 0% used [0x00000007bfa00000,0x00000007bfa04000,0x00000007bfe00000)
 * Metaspace       used 3175K, capacity 4496K, committed 4864K, reserved 1056768K
 * class space    used 348K, capacity 388K, committed 512K, reserved 1048576K
 */
public class PrintGCDetails {


    /**
     * 1024 byte = 1MB
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] bytes = null;

        for (int i = 0; i < 10; i++) {
            bytes = new byte[1024];
        }
    }
}
