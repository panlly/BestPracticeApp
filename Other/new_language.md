### 如何学习新的编程语言
0.先要了解这个语言的历史，了解的过程中会出现一些名词，你也需要搞懂，这有利于你快速记忆这门语言。
  比如js历史，你需要了解浏览器内核是啥，ecmaScript是啥，等等一些概念性的东西，否则以后
  查找问题遇到这些名词不知道，你就看不懂人家在写什么

1.学习语法规则，比如定义数据类型，定义函数，继承，关键字作用，文件依赖规则等
  基本上看基础，比如w3cSchool，菜鸟教程，官网的教程，大牛的教程等
2.看了这些你也写不出程序，而且有很多关键字，api作用/用法你也记不住
  所以这个时候需要实践，因为很多关键字的用法繁多，你背了也不一定记住用法
  所以还得应用的实际中，多写几遍才能记住。这个时候最好选择官方的示例项目
  比如Android在github上有示例工程，phaser引擎也有

3.在使用的过程中要了解周边工具，比如js中的npm,anywhere 等工具/软件用法
  和配置文件的规则，比如webpack的配置规则
4.在你学会和理解用原生的sdk进行命令行编译和构建后，选择一款强大的IDE是你学习路中必不可少的
  因为IDE有便捷的操作，强大的提示功能，甚至能自动为你纠错和优化
  Android肯定是Android studio，js是webStorm ,c/c++是visual studio
5.然后，你需要一个实战项目来熟悉这门语言（框架）的常用api，否则你自己写的时候
  api都不知道有哪些，还得现查，就会很慢



    如果我们已经掌握一门编程语言，那么新学语言会容易一些
因为语言实现的功能大致类似，比如
引入（import/#include）
定义数据类型，循环，判断
代码块，作用域，访问限制修饰符，异常体系
定义函数，使用数组，使用引用（指针）
定义类，继承，多态，函数重载，泛型（模板）

然后还要了解这个语言提供的标准库的常用api
比如java的lang包下的类，
比如C stdlib.h
C++的 iostream类

    所以我们应该在掌握的基础语法后，去看一些开源的demo
去读懂它，从而去建立自己的编程风格，然后就是自己写demo
最后最好能应用到工作中，否则印象不深，自己写一个软件也是可以的



### 定义类，构造函数，类继承机制
只要是面向对象的语言，都需要构造函数来创建对象
java kotlin ，js构造函数各不相同

如何定义父类，以及抽象类

* 创建类的实例

### 定义和调用函数（对象函数，类函数）
一般由表明这是函数的关键字，返回值，函数名，参数列表构成
当然还有访问限制修饰符（public ，private）
是否是继承函数（override）
是否静态，是否可被继承（final static）


比如js中的函数
```javascript
function 函数名(参数1,参数2){
    var a=1;
    return a*2;
}

```
```java
[修饰符] 返回值 函数名(参数1,参数2){
    int a=1;
    return a*2;
}

```
函数的覆盖和重载

自身函数的调用，父类函数的调用


### 声名变量，常量
一般都有
局部变量
全局变量
他们的生命周期不同，可被访问的区域也不同

### 模块体系
定义包（命名空间）
定义引入
就是代码写在不同的文件中，他们之间要相互引用代码或者变量
java的import c的 #include

### 熟悉常用库中的类
比如 java.lang.String
js 中的String
oc 中的NSString


### 命名规则
变量，常量的命名，包的命名，类的命名，函数的命名





