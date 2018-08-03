### 理解区块链

###### 分布式数据库
最早（1970）的数据库有Oracle，MySQL，db2 这些都是 
RDBMS（Relational Database Management System）关系数据库管理系统
他们是将数据以表格的形式存储在磁盘上

后来数据量越来越大，在一个机器上存储数据变得困难，一个是容量不够
一个是随着B树层数加深导致查找和节点平衡导致的性能增加。所以我们急需一个新型数据库
来解决这些问题。这时NoSql的概念被提出
NoSQL，指的是非关系型的数据库。NoSQL有时也称作Not Only SQL的缩写，
是对不同于传统的关系型数据库的数据库管理系统的统称。NoSql代表有
MongoDB，Hbase，Redis,他们都能在多个机器上进行数据的存储和查询
NoSql是支持分布式存储的

###### 区块链
它是一种特殊的分布式数据库，所以它是用来存储数据的，而且是分布式存储
在分布式数据库中，一个存储数据的服务器叫做一个节点。

任何人都可以架设服务器，加入区块链网络，成为一个（存储）节点

没有中心节点，每个节点都是平等的，都保存着整个数据库

你可以向任何一个节点，写入/读取数据，因为所有节点最后都会同步，保证区块链一致

区块链就是数据库，那么一个区块就是其中的一条数据，每次写入一条数据，就是创建一个区块

###### 哈希函数/散列函数
给定任意长度的字符串（原文/key），经过哈希函数的计算，返回一个固定长度的字符串，这个字符串叫
哈希值，哈希值也叫指纹，Md5就是**一种**哈希函数，因为结果长度固定，那么value的可能性也是固定的
比如128位的md5，有2^128种可能，我们希望的是随机key的value能平均的散列在这些可能中
这样能减少hash碰撞


哈希函数是不可逆的

哈希函数有两个特点，防碰撞，防篡改
防碰撞，两个不同的key，要保证他们哈希值相等的概率很小
防篡改，比如1和2，两个key的哈希值要有很大区别才行，不能通过1的哈希值就能推算出2的哈希值

以MD5为例，其输出长度为128位，设计预期碰撞概率为1/2^{64} 这个数字很小

###### 区块的内容
http://www.ruanyifeng.com/blog/2017/12/blockchain-tutorial.html

存储在分布式数据库（区块链）中的一条数据叫做区块，区块的内容：
分为区块头和区块体，head body

区块头包含了当前区块的多项特征值：
生成时间
实际数据（即区块体）的哈希
上一个区块的哈希

区块链的hash算法是SHA256， 哈希值长度是256位，所以发生碰撞的概率几乎为0

结论：
每个区块的哈希都是不一样的，可以通过哈希标识区块。
如果区块的内容变了，它的哈希一定会改变。

然后我们对head的所有内容做hash计（算法是SHA256），得出一个长度256的hash值
这个值就是这个block（区块）的唯一标识，如果block的head或者body有改变，那么
这个唯一标识也一定改变。

区块链不可篡改性：
因为你修改了一个区块的内容，那么这个区块的hash值一定会变，则下一个节点
对应的hash也会变（因为后一个节点的head中有前一个节点的hash值）
所以要改变后面所有节点的hash值，这个计算很耗时，除非你掌握全网算力的51%以上

###### 采矿
计算出一个新区块的hash值（先计算出body（这个很快），然后计算head的就是整个区块的hash值）
的过程叫做采矿，计算的机器叫矿机，操作的人叫矿工

他的设计是，平均每10分钟，全网才能生成一个新区块，一小时也就六个

他保证这个时间的机制是，在head设置一个difficulty（难度系数），和Nonce（临时变量/随机值）
通过一个常数除以难度系数，得到一个目标值，我们计算出的head的hash值必须要小于这个值
这个区块才算有效，否则要你要改变Nonce的值，重新对head进行hash，直到计算出
小于目标值的hash值。因为hash值没有规律可循，所以Nonce值只能从0开始一个一个用穷举法试

第 100000 个区块的 Nonce 值是274148111，就是说他计算了2.7亿次hash值才生成（挖出）一个合法的区块
这样就保证了生成一个区块是需要一定时间的。

Nonce是一个整型，最大 MAX_VALUE = 2147483647;也就是生成一个区块你可能要进行21亿次hash计算
如果，21亿次后还是没有计算出合法（小于目标值）的hash值，那么区块链协议中允许你改变区块体，重新计算

###### 难度系数的动态调节

因为计算出合法的hash值概率是随机的，那么就没法保证 刚好10分钟生成一个区块 的规定
因为有的可能Nonce 值遍历了几个就算出来了，有的可能要遍历好几亿才算出来
所以中本聪采取了改变difficulty来控制事件，difficulty越大，那么目标值越小
计算出合法的hash概率也就越小，这样生成一个区块的时间就长了。
反之，difficulty 越小，生成一个区块也就越快

他规定，难度系数每两周（两周生成2016个区块）调整一次，根据这2016个区块的平均生成时间
如果平均时间比10分钟小10%那么将difficulty增大10%，这样计算的时间肯定边长了
反之difficulty减小


###### 分叉
比如两个矿机都在计算一个新区块的hash（新区块的head中有前一个合法区块的hash值）
这两个区块同时要加入区块链，那么这个时候区块链就有了分叉，所以必须选择一个分叉
选择的规则就是，看哪个分叉的区块长（合法链接的区块多），就选择哪个分叉
如果两个分叉是长度相等，那么选择最先 生成6个区块的分叉就是合法的

区块生成需要算力，那么拥有算力大的分叉，很大几率是合法的


###### 区块链意义
一个新区块写入区块链，至少要10分钟
所有节点（不同的服务器）都同步数据（新加入的区块），则需要更多的时间

所以区块链的使用场景就是，很多人，互相不能信任，也没有一个领袖信任，那么就使用
区块链来记录数据（信息），这样的数据（信息）是不可被篡改的
否则我们直接使用正常的数据库来存储信息即可



###### 区块链协议




