[TOC]

## ﻿打印虚拟机GC信息基本信息参数

``` java
-verbose:gc                     // 输出简单的GC信息 
-XX:PrintGC                     // 输出简单的GC信息 
-XX:PrintGCDetails              // 输出gc详细信息
-XX:PrintGCTimeStamps           // 打印此次垃圾回收距离jvm开始运行的所耗时间 
-Xloggc:logs/gc.og              // 输出gc信息到某一个文件中
-XX:+PrintHeapAtGc              // 每一次GC的详细信息
-XX:+TraceClassloading          // 打印类的加载信息
-XX:+PrintClassHistogram        // jvm中所有的类的使用情况                    
```

## 指定JVM内存控制参数
``` java
-Xms                                        // 指定最小的堆空间
-Xmx                                        // 指定最大的堆空间
-Xmn                                        // 设置新生带的大小
-XX:NewRatio                                // 新生代（eden + 2s ）和老年代的的比值
                                            // -XX:NewRatio=4  ： 新生代：老年代1:4    即 年轻带占据对的5分之1
-XX:SurvivorRatio                           // 设置两个survivor区和eden的比值
                                            // -XX:SurvivorRatio=8 :   survivor:eden = 2:8 即每个survivor占据新生代的10分之1
-XX:+HeapDumpOnOutOfMemeryError             // 发生OutMemeryError的时候导出堆到文件中
-XX:+HeapDumpPath                           // 导出OOM的路径
-XX:+OnOutOfMemoryError=PrintStack.sh %p    // 发生OOM的时候执行一个脚本
-Xss128k                                    // 指定线程栈的大小
-XX:PermSize                                // 设置永久大小
-XX:MaxPermSize                             // 设置永久区最大大小
```