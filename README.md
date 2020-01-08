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
- [数据结构](#数据结构)
- [排序算法](#排序算法)
- [操作系统](#操作系统)
- [并发编程](#并发编程)
- [缓存](#缓存)
- [分布式理论](#分布式理论)
- [计算机网络](#计算机网络)
- [数据库](#数据库)
- [设计模式](#设计模式)
- [LeetCode](#LeetCode)
- [分享总结](#分享总结)
- [开发模式](#开发模式)
- [面试备战](#面试备战)
- [工具](#工具)

---

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
- [select、poll、epoll之间的区别总结[整理]](https://www.cnblogs.com/anker/p/3265058.html)

### 并发编程
- [伪共享（false sharing），并发编程无声的性能杀手](https://www.cnblogs.com/cyfonly/p/5800758.html)
- [HashMap? ConcurrentHashMap? 相信看完这篇没人能难住你！](https://juejin.im/post/5b551e8df265da0f84562403)
- [从ReentrantLock的实现看AQS的原理及应用](https://mp.weixin.qq.com/s/sA01gxC4EbgypCsQt5pVog)
- [【基本功】不可不说的Java“锁”事](https://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651749434&idx=3&sn=5ffa63ad47fe166f2f1a9f604ed10091&chksm=bd12a5778a652c61509d9e718ab086ff27ad8768586ea9b38c3dcf9e017a8e49bcae3df9bcc8&scene=21#wechat_redirect)
- [【原创】Java并发探索(3)之synchronized原理](https://mp.weixin.qq.com/s/uAyMS-Fl8MWhdk-wKLcIHg)
- [Java线程的6种状态及切换(透彻讲解)](https://blog.csdn.net/pange1991/article/details/53860651)
- [线程通信详解](https://mp.weixin.qq.com/s/zwM-_t-A4iztxGJ4sPgX2g)


### 缓存
- [缓存穿透、缓存击穿、缓存雪崩、热点数据失效](https://juejin.im/post/5c9a67ac6fb9a070cb24bf34)
- [避免缓存穿透的利器之BloomFilter](https://juejin.im/post/5db69365518825645656c0de)
- [Redis9种数据结构以及它们的内部编码实现](https://mp.weixin.qq.com/s/GLqZf-0sLQ7nnJ8Xb9oVZQ)
- [Redis为什么是单线程？为什么有如此高的性能？](https://juejin.im/post/5caae9876fb9a05e1530288b)
- [（讨论）缓存同步、如何保证缓存一致性、缓存误用](https://segmentfault.com/a/1190000015804406)

### 分布式理论
- [多图：Raft算法原理非常详细的解读](https://mp.weixin.qq.com/s/OwYcrSOwH-n_65u9PPUqoA)
- [面试再被问到一致性 Hash 算法，这样回答面试官！](https://mp.weixin.qq.com/s/bnuo7knTnp1U7ggEh840iQ)
- [CAP 一致性协议及应用解析](https://segmentfault.com/a/1190000018275818)
- [Kafka的Consumer负载均衡算法](https://juejin.im/post/5baca032e51d450e735e74af)

### 计算机网络
- [TCP为啥要3次握手和4次挥手？握两次手不行吗？](https://mp.weixin.qq.com/s/ANBpgkprBbB3g1UgvvOBjw)
- [TCP协议详解](https://www.cnblogs.com/qdhxhz/p/10267932.html)

### 数据库
- [MySQL中的行级锁,表级锁,页级锁](https://www.hollischuang.com/archives/914)
- [从MySQL Bug#67718浅谈B+树索引的分裂优化](http://hedengcheng.com/?p=525)
- [MySQL索引为什么要用B+树实现？](https://mp.weixin.qq.com/s?__biz=MzIxMzk3Mjg5MQ==&mid=2247483916&idx=1&sn=bfc33b53f8176e6f4d7e64c087ad36a4&chksm=97afe0f8a0d869eeaa14d8b26eca9d6fa09f9fda4557b40cb22ebe75851aa4dfb67d822233d9&scene=0&subscene=90&sessionid=1539434820&ascene=7&devicetype=andro)

### 设计模式
- [Java设计模式](https://java-design-patterns.com/)

### LeetCode
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

### 分享总结
- [Java函数式接口](files/Java函数式接口.pdf)
- [聊聊单元测试](files/侃大山之单元测试.pdf)
- [@Transactional注解回滚异常范围](files/@Transactional注解回滚异常范围.md)
- [sql多余的引号可能导致的索引失效问题](files/sql多余的引号可能导致的索引失效问题.md)
- [死锁](files/死锁.md)

### 开发模式
- [软件开发模式对比(瀑布、迭代、螺旋、敏捷)](https://www.cnblogs.com/-oyk/archive/2012/10/08/2714669.html)
- [软件能力成熟度模型](https://baike.baidu.com/item/%E8%BD%AF%E4%BB%B6%E8%83%BD%E5%8A%9B%E6%88%90%E7%86%9F%E5%BA%A6%E6%A8%A1%E5%9E%8B)
- [软件过程与项目管理（一）](https://www.jianshu.com/p/cf42afa8d886)
- [软件过程与项目管理（二）](https://www.jianshu.com/p/a1eeee703306)
- [软件过程与项目管理（三）](https://www.jianshu.com/p/a621cb19699a)
- [软件过程与项目管理（四）](https://www.jianshu.com/p/70b15cca3e83)

### 面试备战
- 简历
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

- 杂货铺
    - [从实际案例聊聊Java应用的GC优化](https://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651747273&idx=1&sn=7f947064a41eeecb6816a5d0838581ae&chksm=bd12aa848a65239289d5c39264e89bd175f377f6554bfe93b37ad6498cf13deff356333c5398&scene=21#wechat_redirect)
    - [JVM是怎么和操作系统交互的？](https://mp.weixin.qq.com/s/5cl6t1gAYM_qdlq_CtvcOQ)
    - [JVM 必问知识点:类加载过程](https://mp.weixin.qq.com/s/jut6U-J5XubPOk5eiEWZew)
    - [再谈基于 Kafka 和 ZooKeeper 的分布式消息队列原理](https://gitbook.cn/books/5bc446269a9adf54c7ccb8bc/index.html)
    - [Java异常体系(美团面试)](https://www.cnblogs.com/aspirant/p/10790803.html)
    - [面试常问的PECS原则，到底是什么鬼？](https://mp.weixin.qq.com/s/-xEqJttBB2R0MW6M66G7IA)
    - [如何设计出骚气的秒杀系统？](https://mp.weixin.qq.com/s/62Thk-KIPwFXSdupGMMq9Q)
    - [不了解Java反射机制？看这篇就明白了！](https://mp.weixin.qq.com/s/kO0kVh2KwxiGMhh25LKLqQ)
    - [Dubbo 的 8000 字图文详解，建议收藏！](https://mp.weixin.qq.com/s/bwLSxsTRwhyOh_gTU0GVnQ)
    - [必会的44个Java性能优化细节！](https://mp.weixin.qq.com/s/pxKSlVBSTnEL0MuiY7UKBg)
    
### 工具
- [Mac环境搭建](https://mp.weixin.qq.com/s/HpxzVOZYhm0flf3ziANcGg)
- [git代码统计](https://segmentfault.com/a/1190000008542123)
- [BTrace使用笔记](https://ningyu1.github.io/site/post/39-btrace/)