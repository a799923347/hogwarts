# HOGWARTS
<p align="center">
<img src="https://ftp.bmp.ovh/imgs/2019/12/4f48ba2e606721a7.png" width="300"/>
</p>

> 霍格沃茨魔法学校，（英语：Hogwarts School of Witchcraft and Wizardry），简称霍格沃茨，是英国作家J·K·罗琳的
> 魔幻小说《哈利·波特》系列中魔法学校的主要场景，据称是欧洲三大魔法学校之一。  
> --维基百科[霍格沃茨魔法学校](https://zh.wikipedia.org/wiki/%E9%9C%8D%E6%A0%BC%E8%8F%AF%E8%8C%B2%E9%AD%94%E6%B3%95%E8%88%87%E5%B7%AB%E8%A1%93%E5%AD%B8%E9%99%A2)  
> 本库主要用于本人平时的学习积累以及技术上一些相关想法的实践。遂取名Hogwarts，即学习的地方。

---

## 目录
- [Java](#Java)
- [JVM](#JVM)
- [数据结构](#数据结构)
- [排序算法](#排序算法)
- [操作系统](#操作系统)
- [并发编程](#并发编程)
- [缓存](#缓存)
- [消息队列](#消息队列)
- [分布式理论](#分布式理论)
- [Dubbo](#Dubbo)
- [计算机网络](#计算机网络)
- [数据库](#数据库)
- [Hadoop](#Hadoop)
- [LeetCode](#LeetCode)
- [分享与好记性不如烂笔头](#分享与好记性不如烂笔头)
- [开发模式](#开发模式)
- [面试备战](#面试备战)
- [工具](#工具)

---

### Java

<details>
<summary>点击展开列表</summary>

- [从实际案例聊聊Java应用的GC优化](https://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651747273&idx=1&sn=7f947064a41eeecb6816a5d0838581ae&chksm=bd12aa848a65239289d5c39264e89bd175f377f6554bfe93b37ad6498cf13deff356333c5398&scene=21#wechat_redirect)
- [GC之详解CMS收集过程和日志分析](https://www.cnblogs.com/zhangxiaoguang/p/5792468.html)
- [JVM是怎么和操作系统交互的？](https://mp.weixin.qq.com/s/5cl6t1gAYM_qdlq_CtvcOQ)
- [JVM 必问知识点:类加载过程](https://mp.weixin.qq.com/s/jut6U-J5XubPOk5eiEWZew)
- [Java异常体系(美团面试)](https://www.cnblogs.com/aspirant/p/10790803.html)
- [面试常问的PECS原则，到底是什么鬼？](https://mp.weixin.qq.com/s/-xEqJttBB2R0MW6M66G7IA)
- [解释下 Java 术语的逆变、协变、不变是什么](https://mp.weixin.qq.com/s/SiK3rcZNhHCldiQzIql8_g)
- [不了解Java反射机制？看这篇就明白了！](https://mp.weixin.qq.com/s/kO0kVh2KwxiGMhh25LKLqQ)
- [必会的44个Java性能优化细节！](https://mp.weixin.qq.com/s/pxKSlVBSTnEL0MuiY7UKBg)
- [Java OutOfMemory异常清单 —— 在自己的机器上制造内存溢出](https://blog.csdn.net/hzy38324/article/details/76719105)
- [JAVA中断机制详解](https://www.cnblogs.com/wxgblogs/p/5416788.html)
- [HashMap? ConcurrentHashMap? 相信看完这篇没人能难住你！](https://juejin.im/post/5b551e8df265da0f84562403)
- [永久代与元数据区](https://juejin.im/post/5dae7e5de51d45249850cf9f)
- [基于Java Agent与Javassist实现零侵入AOP](https://ouyblog.com/2019/03/%E5%9F%BA%E4%BA%8EJava-Agent%E4%B8%8EJavassist%E5%AE%9E%E7%8E%B0%E9%9B%B6%E4%BE%B5%E5%85%A5AOP)
- [万字讲解SPI机制，完爆面试知识点](https://mp.weixin.qq.com/s/QKXz1idNs5MJI-FcKXWaIg)
</details>

### JVM
- [JVM实用参数（一）JVM类型以及编译器模式](http://ifeve.com/useful-jvm-flags-part-1-jvm-types-and-compiler-modes-2/)
- [JVM实用参数（二）参数分类和即时（JIT）编译器诊断](http://ifeve.com/useful-jvm-flags-part-2-flag/)
- [JVM实用参数（三）打印所有XX参数及值](http://ifeve.com/useful-jvm-flags-part-3-printing-all-xx-flags-and-their-values/)
- [JVM实用参数（四）内存调优](http://ifeve.com/useful-jvm-flags-part-4-heap-tuning/)
- [JVM实用参数（五）新生代垃圾回收](http://ifeve.com/useful-jvm-flags-part-5-young-generation-garbage-collection/)
- [JVM实用参数（六） 吞吐量收集器](http://ifeve.com/useful-jvm-flags-part-6-throughput-collector/)
- [JVM实用参数（七）CMS收集器](http://ifeve.com/useful-jvm-flags-part-7-cms-collector/)
- [JVM实用参数（八）GC日志](http://ifeve.com/useful-jvm-flags-part-8-gc-logging/)
- [了解 CMS 垃圾回收日志](http://ifeve.com/jvm-cms-log/)

### 数据结构
- 树
    - [红黑树](https://mp.weixin.qq.com/s/lZQ1MThnkIoRURTnI8ZXYw)

### 排序算法
- [十大经典排序算法（动图演示）](https://www.cnblogs.com/onepixel/p/7674659.html)
- 交换排序
    - [冒泡排序](src/main/java/com/bowen/hogwarts/sort/BubbleSort.java)
    - [快速排序](src/main/java/com/bowen/hogwarts/sort/QuickSort.java)
- 插入排序
    - [插入排序](src/main/java/com/bowen/hogwarts/sort/InsertionSort.java)
    - [希尔排序](src/main/java/com/bowen/hogwarts/sort/ShellSort.java)
- 选择排序
    - [选择排序](src/main/java/com/bowen/hogwarts/sort/SelectionSort.java)
    - [堆排序](src/main/java/com/bowen/hogwarts/sort/HeapSort.java)
- [归并排序](src/main/java/com/bowen/hogwarts/sort/MergeSort.java)

### 操作系统
- [零拷贝](https://developer.ibm.com/articles/j-zerocopy/)
- [聊聊同步、异步、阻塞与非阻塞](https://www.jianshu.com/p/aed6067eeac9)
- [聊聊Linux 五种IO模型](https://www.jianshu.com/p/486b0965c296)
- [聊聊IO多路复用之select、poll、epoll详解](https://www.jianshu.com/p/dfd940e7fca2)

### 并发编程
- [伪共享（false sharing），并发编程无声的性能杀手](https://www.cnblogs.com/cyfonly/p/5800758.html)
- [Java8使用@sun.misc.Contended避免伪共享](https://www.jianshu.com/p/c3c108c3dcfd)
- [从ReentrantLock的实现看AQS的原理及应用](https://mp.weixin.qq.com/s/sA01gxC4EbgypCsQt5pVog)
- [【基本功】不可不说的Java“锁”事](https://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651749434&idx=3&sn=5ffa63ad47fe166f2f1a9f604ed10091&chksm=bd12a5778a652c61509d9e718ab086ff27ad8768586ea9b38c3dcf9e017a8e49bcae3df9bcc8&scene=21#wechat_redirect)
- [【原创】Java并发探索(3)之synchronized原理](https://mp.weixin.qq.com/s/uAyMS-Fl8MWhdk-wKLcIHg)
- [Java并发编程：Synchronized及其实现原理](https://www.cnblogs.com/paddix/p/5367116.html)
- [Java线程的6种状态及切换(透彻讲解)](https://blog.csdn.net/pange1991/article/details/53860651)
- [线程通信详解](https://mp.weixin.qq.com/s/zwM-_t-A4iztxGJ4sPgX2g)
- [Java的Fork/Join任务，你写对了吗？](https://www.liaoxuefeng.com/article/1146802219354112)


### 缓存

<details>
<summary>点击展开列表</summary>

- [Redis基础](https://juejin.im/post/5db66ed9e51d452a2f15d833)
- [缓存雪崩、击穿、穿透](https://juejin.im/post/5dbef8306fb9a0203f6fa3e2)
- [Redis哨兵、持久化、主从、手撕LRU](https://juejin.im/post/5dc3a9fbf265da4d3c072eab)
- [Redis双写一致性、并发竞争、线程模型](https://juejin.im/post/5dc850b4e51d452c2308ee27)
- [缓存穿透、缓存击穿、缓存雪崩、热点数据失效](https://juejin.im/post/5c9a67ac6fb9a070cb24bf34)
- [避免缓存穿透的利器之BloomFilter](https://juejin.im/post/5db69365518825645656c0de)
- [Redis9种数据结构以及它们的内部编码实现](https://mp.weixin.qq.com/s/GLqZf-0sLQ7nnJ8Xb9oVZQ)
- [Redis为什么是单线程？为什么有如此高的性能？](https://juejin.im/post/5caae9876fb9a05e1530288b)
- [（讨论）缓存同步、如何保证缓存一致性、缓存误用](https://segmentfault.com/a/1190000015804406)
- [Redis持久化机制：RDB和AOF](https://juejin.im/post/5d776dcef265da03b574744d)
- [Redis 为什么用跳表而不用平衡树？](https://juejin.im/post/57fa935b0e3dd90057c50fbc)
- [关于Redis热点key的一些思考](https://juejin.im/post/5d259544f265da1bd522f689)
</details>

### 消息队列
- [再谈基于 Kafka 和 ZooKeeper 的分布式消息队列原理](https://gitbook.cn/books/5bc446269a9adf54c7ccb8bc/index.html)
- [Kafka为什么速度那么快？](https://juejin.im/post/5cd2db8951882530b11ee976)
- [Kafka的Consumer负载均衡算法](https://juejin.im/post/5baca032e51d450e735e74af)

### 分布式理论
- [多图：Raft算法原理非常详细的解读](https://mp.weixin.qq.com/s/OwYcrSOwH-n_65u9PPUqoA)
- [面试再被问到一致性 Hash 算法，这样回答面试官！](https://mp.weixin.qq.com/s/bnuo7knTnp1U7ggEh840iQ)
- [CAP 一致性协议及应用解析](https://segmentfault.com/a/1190000018275818)
- [详解蚂蚁金服大规模分布式架构下数据一致性实践](https://mp.weixin.qq.com/s/eGcTO-zLUwtgqYmpyREm1Q)
- [TCC分布式事务的实现原理](https://juejin.im/post/5bf201f7f265da610f63528a)
- [最终一致性分布式事务如何保障实际生产中99.99%高可用](https://juejin.im/post/5bf2c6b6e51d456693549af4)
- [分布式系统理论之Quorum机制](https://www.cnblogs.com/hapjin/p/5626889.html)
- [微服务下如何保证事务的一致性](https://mp.weixin.qq.com/s/SfU5gNFA4hEMiSZz6Q0I0Q)

### Dubbo
- [Dubbo 的 8000 字图文详解，建议收藏！](https://mp.weixin.qq.com/s/bwLSxsTRwhyOh_gTU0GVnQ)
- [框架设计](https://dubbo.apache.org/zh-cn/docs/dev/design.html)
- [实现细节](https://dubbo.apache.org/zh-cn/docs/dev/implementation.html)
- [服务调用过程](https://dubbo.apache.org/zh-cn/docs/source_code_guide/service-invoking-process.html)

### 计算机网络
- [TCP为啥要3次握手和4次挥手？握两次手不行吗？](https://mp.weixin.qq.com/s/ANBpgkprBbB3g1UgvvOBjw)
- [TCP协议详解](https://www.cnblogs.com/qdhxhz/p/10267932.html)
- [TCP/IP五层模型和OSI七层模型](https://segmentfault.com/a/1190000019062885)

### 数据库
- [MySQL中的行级锁,表级锁,页级锁](https://www.hollischuang.com/archives/914)
- [从MySQL Bug#67718浅谈B+树索引的分裂优化](http://hedengcheng.com/?p=525)
- [一步步分析为什么B+树适合作为索引的结构 以及索引原理](https://www.cnblogs.com/aspirant/p/9214485.html)
- [MySQL索引为什么要用B+树实现？](https://mp.weixin.qq.com/s?__biz=MzIxMzk3Mjg5MQ==&mid=2247483916&idx=1&sn=bfc33b53f8176e6f4d7e64c087ad36a4&chksm=97afe0f8a0d869eeaa14d8b26eca9d6fa09f9fda4557b40cb22ebe75851aa4dfb67d822233d9&scene=0&subscene=90&sessionid=1539434820&ascene=7&devicetype=andro)
- [一条简单的更新语句，MySQL是如何加锁的](https://mp.weixin.qq.com/s/X4Kn1ZnPrGLqBcBoJY1ObA)
- [这一次，彻底读懂Mysql执行计划](https://juejin.im/post/5a52386d51882573443c852a)
- [MySQL的InnoDB索引原理详解](https://kyle.ai/blog/6439.html)
- [B树和B+树的插入、删除图文详解](https://www.cnblogs.com/nullzx/p/8729425.html)
- [读《MySQL 实战》01 Server层和存储引擎](http://www.linkedkeeper.com/1304.html)

### Hadoop
- [Hadoop伪分布式环境搭建](https://juejin.im/post/5b8e94c1e51d451a447a97ae)
- [HDFS 详细解析](https://juejin.im/post/5b9727d2e51d450e79034030)
- [YARN 详细解析](https://juejin.im/post/5bb59eb65188255c5121d650)
- [MapReduce 原理讲解](https://juejin.im/post/5bb59f87f265da0aeb7118f2)
- [MapReduce之Shuffle过程详述](https://matt33.com/2016/03/02/hadoop-shuffle/)

### LeetCode

<details>
<summary>点击展开列表</summary>

- [有效的括号](src/main/java/com/bowen/hogwarts/leetcode/BracketIsValid.java)
- [括号生成](src/main/java/com/bowen/hogwarts/leetcode/GenerateParenthesis.java)
- [整数反转](src/main/java/com/bowen/hogwarts/leetcode/IntegerReverse.java)
- [回文数](src/main/java/com/bowen/hogwarts/leetcode/IsPalindrome.java)
- [电话号码的字母组合](src/main/java/com/bowen/hogwarts/leetcode/LetterCombinations.java)
- [无重复字符的最长子串](src/main/java/com/bowen/hogwarts/leetcode/LongestNoDupSubString.java)
- [最长回文子串](src/main/java/com/bowen/hogwarts/leetcode/LongestPalindrome.java)
- [最长公共前缀](src/main/java/com/bowen/hogwarts/leetcode/LongestSharedPrefix.java)
- [盛最多水的容器](src/main/java/com/bowen/hogwarts/leetcode/MaxArea.java)
- [最大子串和](src/main/java/com/bowen/hogwarts/leetcode/MaxSubArray.kt)
- [寻找两个有序数组的中位数](src/main/java/com/bowen/hogwarts/leetcode/MedianOfTwoOrderedArray.java)
- [合并两个有序链表](src/main/java/com/bowen/hogwarts/leetcode/MergeTwoOrderedLinkedList.java)
- [下一个排列](src/main/java/com/bowen/hogwarts/leetcode/NextPermutation.java)
- [正则表达式匹配](src/main/java/com/bowen/hogwarts/leetcode/RegexMatch.java)
- [删除链表的倒数第N个节点](src/main/java/com/bowen/hogwarts/leetcode/RemoveNthFromEnd.java)
- [反转链表](src/main/java/com/bowen/hogwarts/leetcode/ReverseListNode.java)
- [删除排序数组中的重复项](src/main/java/com/bowen/hogwarts/leetcode/RmDupElemOfOrderedArray.java)
- [搜索旋转后的排序数组](src/main/java/com/bowen/hogwarts/leetcode/SearchRotatedOrderedArray.java)
- [字符串转换整数](src/main/java/com/bowen/hogwarts/leetcode/StringConvertInteger.java)
- [字符串相乘](src/main/java/com/bowen/hogwarts/leetcode/StringMultiply.java)
- [实现Java的indexOf()](src/main/java/com/bowen/hogwarts/leetcode/StrStr.java)
- [三数之和](src/main/java/com/bowen/hogwarts/leetcode/ThreeNumberSum.java)
- [两数相除](src/main/java/com/bowen/hogwarts/leetcode/TwoNumberDivide.java)
- [两数相加](src/main/java/com/bowen/hogwarts/leetcode/TwoNumbersAddition.java)
- [Z字形变换](src/main/java/com/bowen/hogwarts/leetcode/ZShapeConvert.java)
- [字符串的排列](src/main/java/com/bowen/hogwarts/leetcode/StringCheckInclusion.java)
- [翻转字符串里的单词](src/main/java/com/bowen/hogwarts/leetcode/ReverseWordsOfString.java)
- [二叉树的锯齿形层次遍历](src/main/java/com/bowen/hogwarts/leetcode/ZigzagTraverseBinaryTree.java)
- [重排链表](src/main/java/com/bowen/hogwarts/leetcode/ReorderList.java)
- [LRU缓存机制](src/main/java/com/bowen/hogwarts/leetcode/LruCache.java)
- [岛屿的最大面积](src/main/java/com/bowen/hogwarts/leetcode/MaxAreaOfIsland.java)
- [复原IP地址](src/main/java/com/bowen/hogwarts/leetcode/RestoreIpAddresses.java)
- [最长连续递增序列](src/main/java/com/bowen/hogwarts/leetcode/FindLengthOfLCIS.java)
- [最长上升子序列](src/main/java/com/bowen/hogwarts/leetcode/LengthOfLis.java)
- [合并区间](src/main/java/com/bowen/hogwarts/leetcode/MergeIntervals.java)
- [排序链表](src/main/java/com/bowen/hogwarts/leetcode/SortList.java)
</details>



### 分享与好记性不如烂笔头
- [Java函数式接口](files/Java函数式接口.pdf)
- [聊聊单元测试](files/侃大山之单元测试.pdf)
- [@Transactional注解回滚异常范围](files/@Transactional注解回滚异常范围.md)
- [sql多余的引号可能导致的索引失效问题](files/sql多余的引号可能导致的索引失效问题.md)
- [死锁](files/死锁.md)
- [ThreadPoolExecutor笔记](files/ThreadPoolExecutor笔记.md)
- [shell编程笔记](files/shell编程笔记.md)

### 开发模式
- [软件开发模式对比(瀑布、迭代、螺旋、敏捷)](https://www.cnblogs.com/-oyk/archive/2012/10/08/2714669.html)
- [软件能力成熟度模型](https://baike.baidu.com/item/%E8%BD%AF%E4%BB%B6%E8%83%BD%E5%8A%9B%E6%88%90%E7%86%9F%E5%BA%A6%E6%A8%A1%E5%9E%8B)
- [软件过程与项目管理（一）](https://www.jianshu.com/p/cf42afa8d886)
- [软件过程与项目管理（二）](https://www.jianshu.com/p/a1eeee703306)
- [软件过程与项目管理（三）](https://www.jianshu.com/p/a621cb19699a)
- [软件过程与项目管理（四）](https://www.jianshu.com/p/70b15cca3e83)

### 面试备战
- 简历怎么写
    - [大厂面试面试官看了直呼想要的简历](https://mp.weixin.qq.com/s/0pNv6pMnenKn1A9PE61VnQ)
- 面经
    - [3 年经验的 Java 后端妹子，横扫阿里、滴滴、美团，整理出这份厚厚的 8000 字面经](https://mp.weixin.qq.com/s/w1jXMsgog8eaaSUDyWYNbA)
    - [一个妹子的后台面试经验总结（蚂蚁金服+美团+携程+滴滴+....）](https://mp.weixin.qq.com/s/3_iz8i0TeRP6X6PuIW1EYQ)
    - [美团社招Java开发一面，二面，三面，四面合并面经](https://mp.weixin.qq.com/s/vyZ0BIskiv_CT8ypl7znEw)
    - [开挂般的面经：十面阿里，七面头条](https://juejin.im/post/5cd288d86fb9a031ef63cf5c)
    - [面试题(19)今日头条Java后台研发三面题目](https://blog.csdn.net/cowbin2012/article/details/89716771)
    - [今日头条研发面经](https://segmentfault.com/a/1190000016556077)
    - [2年Java，蚂蚁一面，卒！](https://mp.weixin.qq.com/s/yGbCGKDfuH4Xn92zWUkA5A)
    - [面经：为了拿到字节跳动offer，鬼知道我经历了啥...](https://mp.weixin.qq.com/s/mx7LAClkLgmEMHrmvE8ktQ)
    - [你离BAT之间，只差这一套Java面试题。](https://www.hollischuang.com/archives/2223)
    - [Spring常见面试题汇总（超详细回答-值得收藏）](https://mp.weixin.qq.com/s/q1mxZYShdnvEfF1zWrtZfg)
    - [阿里面试题合集118道送答案（新总结）：天猫+蚂蚁金服+阿里巴巴](https://www.toutiao.com/i6758263258471203332)
    - [我的后台Java面经（阿里、腾讯、头条、京东、IBM等）](https://mp.weixin.qq.com/s/YXzRW6t9FEr1YXLqGBotLA)

- 杂货铺
    - [如何设计出骚气的秒杀系统？](https://mp.weixin.qq.com/s/62Thk-KIPwFXSdupGMMq9Q)
    - [阿里盒马领域驱动设计实践](https://www.infoq.cn/article/alibaba-freshhema-ddd-practice/)
    - [如何设计一个高并发系统？](https://github.com/doocs/advanced-java/blob/master/docs/high-concurrency/high-concurrency-design.md)
    - [Spring-bean的循环依赖以及解决方式](https://blog.csdn.net/u010853261/article/details/77940767)
    - [9000+ 字，彻底征服 Spring AOP ，美滋滋](https://mp.weixin.qq.com/s/BYxXMAEIfOSCCx1KanP9lg)
    - [Spring AOP 实现原理与 CGLIB 应用](https://www.ibm.com/developerworks/cn/java/j-lo-springaopcglib/index.html)
    - [如何解决秒杀的性能问题和超卖的讨论](https://www.cnblogs.com/billyxp/p/3701124.html)
    - [Sentinel原理：滑动窗口](https://github.com/all4you/sentinel-tutorial/blob/master/sentinel-principle/sentinel-slide-window/sentinel-slide-window.md)
    - [Sentinel工作主流程](https://github.com/alibaba/Sentinel/wiki/Sentinel%E5%B7%A5%E4%BD%9C%E4%B8%BB%E6%B5%81%E7%A8%8B)
    - [Sentinel 核心类解析](https://github.com/alibaba/Sentinel/wiki/Sentinel-%E6%A0%B8%E5%BF%83%E7%B1%BB%E8%A7%A3%E6%9E%90)
    - [朋友圈式的Timeline设计方案](https://www.myway5.com/index.php/2017/06/29/timeline-design/)
    - [性能之争：响应式编程真的有效吗？](https://www.infoq.cn/article/xYCWYK9*TfmpFNO6RkWt)
    - [Reactive（响应式）编程-Reactor](http://ifeve.com/reactive%EF%BC%88%E5%93%8D%E5%BA%94%E5%BC%8F%EF%BC%89%E7%BC%96%E7%A8%8B-reactor/)
    - [架构师的初级技能，选组件！](https://mp.weixin.qq.com/s/vN2uPnRSsFW7mEQHGtX_4Q)
    
### 工具
- [Mac环境搭建](https://mp.weixin.qq.com/s/HpxzVOZYhm0flf3ziANcGg)
- [git代码统计](https://segmentfault.com/a/1190000008542123)
- [BTrace使用笔记](https://ningyu1.github.io/site/post/39-btrace/)
- [IDEA 2019.3激活破解教程（永久）](https://juejin.im/post/5df8a5a5e51d4557f0460990)
- [Mac下用Charles实现Android http和https抓包](https://blog.csdn.net/luochoudan/article/details/72801573)
- [vi/vim使用进阶: 指随意动，移动如飞 (一)](https://blog.easwy.com/archives/advanced-vim-skills-basic-move-method/)
- [homebrew国内镜像](https://frankindev.com/2020/05/15/replace-homebrew-source/)
