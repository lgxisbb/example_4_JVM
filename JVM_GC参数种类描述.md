## 串行收集器
```
-XX:+UseSerialGC                        // 串行回收器


```

## 并行收集器

``` java

新生代并行
老年代串行

-XX:+UseParNewGC                       // 串行收集器
-XX:+ParallelGCThreads                 // 限制线程数量

```