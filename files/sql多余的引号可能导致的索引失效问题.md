讲一个sql引号的问题，以下是一条常见的sql

```sql
select * from order_order where biz_status = 'DONE' and biz_code = '1104';
```

根据条件对某些数据做更新，这是没有问题的，但如果不小心点错了引号的位置，比如

```sql
select * from order_order where biz_status = 'DONE and biz_code' = '1104';
```

这并不是一条符合我们本意的sql，也本应该是一条错误的语句，但实际上却是可以执行的，使用explain extended+show warnings诊断之后发现，经mysql转义之后原语句变成了如下的语句

```sql
explain extended select id from order_order where biz_status = 'DONE and user_idno' = 'aaa';

show warnings;

/ select#1 / select f2l_credit.order_order.id AS id from f2l_credit.order_order where ((f2l_credit.order_order.biz_status = 'DONE and user_idno') = 'aaa')
```

先判断(f2l_credit.order_order.biz_status = 'DONE and user_idno')的结果为0，再将0与'aaa'比较发现结果为1，分析发现执行0='aaa'的判断时有如下警告

```sql
select 0='aaa';

show warnings;

Truncated incorrect DOUBLE value: 'aaa'
```

再实验发现，如果将'aaa'与0做加法运算会得到以下结果

```sql
select 'aaa'+0;

0
```

所以猜测解释器无法将'aaa'转换成浮点型数据就给了一个默认的0(后面验证发现并不是这样的)，于是0=0便是恒成立的；
再进一步实验发现执行

```sql
select 23='23aaa';

select 23='24aaa';

select 23='23aa34a5';

```


得到的结果分别是

>1

>0

>0

所以断定mysql在将字符串转成浮点型数据的时候应该是只截取了前部的数值部分，所以'aaa'这样的字符串前面没有数值被截取成0也就能说的通了，并不是给了一个默认的数值0；

最后重点:如果这样的问题发生在了一条update语句中，就有可能发生对全表数据做更新的情况