# JAVA--潘伟丰

path：搜索可执行文件的位置

bin:binary，java javac javadoc(使用较多)

include:调用底层代码

lib：library 类库

src：jdk源码

- java程序分类
  - java application(多用) 应用程序：可独立在jvm上运行
  - java applet (已成历史) 应用小程序

集成开发环境：Eclipse IDEN

`/**文档注释*/`注释不能嵌套

```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("hhhhhhhhello");
    }
}
//hello.java:1: 错误: 类HelloWorld是公共的, 应在名为 HelloWorld.java 的文件中声明
```

1. public 类应该是文件的名字,所在的类是文件名
2. 同一个java文件中只能有一个公共puclic的类
3. main必须在public的类中
4. 一个java的文件中有多个class，编译后的.class文件就会有多个
5. 一个java文件中是可以有多个main的，但是只用了public那个类中的main，其他的main没用
6. main和c一样是程序的入口，main的写法固定为`public static void main(String[] args){`
7. public static可互换
8. 注释中的东西除外，其他所有英文，所有的空格、括号、引号（半角）
9. java标识符 
   1. 字母
   2. 数字
   3. 下划线
   4. 美元符号
   5. 数字不开头

university code _表示所有的语言，汉语等

书写规范：

1. 类名：每个单词的首字母大写，其他小写（驼峰原则），GongShang,YellowDog
2. 方法、变量：首个单词的首字母小写，其他大写 studentDog
3. 包：全部小写
4. 常量：全部大写，多个单词用_连接

```java
public class Notaion{
    class Cat{}
    public static void main(String[] args){
        System.out.println("hhh");
    }
}
```

## 10.12

数据类型决定：

1. 数据占内存字节数
2. 数据取值范围
3. 可以进行的操作 



- 数据类型

  - 基本数据类型

    - 数值型

      - 整数类型

        > 整数类型有固定的表数范围和字段长度，而不受具体操作系统的影响，以保证java的可移植性byte:1字节 short:2字节 int:4 long:8
        >
        > 八进制要求以0开头，十六进制要求以0x开头，二进制以0b开头
        >
        > 声明long型常量可以后加l或L long i=3L
        >
        > java中可以用long来处理无符号整数（uint）

      - 浮点类型

        > float i=0.3f

    - 字符型char

      > java中的字符采用Unicode编码，每个字符占两个字节，可用16进制编码表示

    - 布尔型boolean

      > 不可以0或非0的整数替代true和false

  - 引用数据类型

    - 类
    - 接口
    - 数组

基本类型：变量在栈（在这里）,复制p=d，复制的是值

引用类型：变量引用到堆（在那里），复制的是引用，指向同一个地址、对象

集成开发环境：把javac和java的调用封装在一个环境中

```java
package week04;
public class BoolTest {
	// alt+"/" 补全
	// main+alt+"/" 补全main
	// syso+alt+"/" 补全输出
	// ctrl+"/" 注释
	// ctrl+d 删除
	// alt+上箭头 把代码上移
	// 整段代码注释 ctrl+shift+/
	// 整段代码去注释 ctrl+shift+\
	//ctrl+shift+f 规范格式
	public static void main(String[] args) {
	//bool-boolean,一个字节
	//c:非零即真-java：只有false true
	boolean m = true;
	//if(1)-if(true)
	char n='b';
	//c:char 1byte-java:char unicode(每个字符两个字节)
	char k='汉';//java、c：两个字节
	//unicode:前50% ascci,后50% 拉丁
	int a=10;
	int b=015;//八进制
	int c=0xF;//十六进制
	System.out.println(b);
	System.out.println(Integer.toOctalString(b));
	System.out.println(Integer.toBinaryString(-2));
	//-2补码：11111111111111111111111111111110
	int strAge =0; //基本类型的变量都是在栈里面的
	int salary; //声明
	salary=0;//赋值，初始化
	//方法之内定义的是局部变量，方法之外类之内的是成员变量
	//成员变量使用可不初始化，局部变量必须初始化
	float p=0.1f;//0.1double
	double pp=0.1d;
	int ppp=1111111111;//+-2.1billion
	long pppp=3111111111111L;
	char dp='"';//双引号可以这样表示
	}
}

```

每种基本数据类型有固定的长度，所以sizeof（）在Java中没有必要（因为c中只要求short比int短，所以无法估计大小），java不提供无符号整数类型

原码->反码->补码

去符号->0变1,1变0->反码加1

直接量

/r 回车键回到一行开头

## 10.13

#### 类型转换

Boolean不能转换为其他类型

整型常量（整型变量不行）可以直接赋值给byte\short\char,只要范围没超过，不用强转

double型不能转为float

float比long的容量大，因为float1和2之间还有很多数字

容量小的类型自动转换为容量大的类型byte等->int->long->float->double

byte，char，short之间的运算会变成int再运算，他们之间不会互相转换，容量小的自动转化成容量大的

容量大的变成容量小的要强制转换

int b=3;char f=b;错误：整型变量不行

> 整型常量（整型变量不行）可以直接赋值给byte\short\char,只要范围没超过，不用强转

运算符的优先级

switch（表达式）可接受int、byte、char、short

switch中defalt的位置

## 10.19

对象和类的关系

- 从特殊到一般，抽象到具体
- 类是创作的模板，对象是实例
- 类静态定义相同属性，动态是行为
- java中一切皆对象，对象时java的核心

类的定义格式：private int i; public void tt(int oo);

对象的定义格式 Pigsy pig=null;pig=new Pigsy();

类是对代码的组织，对象是是对数据的组织

JVM:类加载器：classloader，用于加载类，按照使用的顺序去加载

```java
package week05;

public class Pigsy {
	//attributes
	String pigHead;
	String humanBody;
	String jcbp;
	//behaviors
	void say(String conn)
	{
		System.out.println("i can say ...");
	}
	public static void main(String[] args) {
//		Pigsy/*type*/ pig/*variable*/ = new Pigsy()/*value*/;
		Pigsy pig=null;
		pig=new Pigsy();
		pig.say("zbj");
		
	}
}


```



| 栈（基本数据类型） | 堆（引用类型空间）           |      |
| ------------------ | ---------------------------- | ---- |
| 放变量名如pig      | 类加载区（放类的代码）       |      |
|                    | 常量池（存放各种各样的常量） |      |
|                    | 对象空间（指 向类加载区）    |      |

方法运行结束后，栈中的变量就没了

垃圾回收机制：每个对象都有一个引用计数器，计数为0，无指针指向，内存到一定空间开始删掉

![69B9022B6838498FED5A2E309D5485C2](C:\Users\LENOVO\Desktop\cd-s-learning\图片\69B9022B6838498FED5A2E309D5485C2.jpg)

Pigsy pig =new Pigsy();写完一段程序，jvm自动会帮你写一段以下语句

```java
public Pigsy()
{
super();
}//构造（对象的）方法，实际上是构造变量的空间，给空间中放值
```

构造方法

1. 构造方法是一个特殊的方法， 通过new调用
2. 构造方法有返回值，但是不用写因为都是确定的
3. 一旦自己定义构造方法，系统则不自动添加，方法名同类名
4. 若自己写了有参的，加个无参数的
5. 也可以用Pigsy pig =new Pigsy(”“”“”);定死

## 10.26

构造函数要构造空间

#### this

- 根据位置不同分成三种
  1. constructor ：当前正在初始化的对象
  2. 当前正在调用这个方法的对象
  3. 调用重载的构造方法（第一行语句）



局部变量作用范围：从定义的那行开始，到包含其的最内层的大括号

内层的局部变量会把外部的变量屏蔽 

任一函数在调用的时候，默认传递一个参数this，所以不用加

重载：同名的方法重复载入类中



#### 构造方法的重载over-written

一同一不同：方法名同，参数不同

参数不同：参数个数、类型不同（顺序不同）

普通方法：跟返回值类型、前面的修饰符无关



#### 封装：先装后封

装what：类内部装属性和方法，包内部装类和接口

granularity: class + package

作用：看到该看到的（受限访问，保护，不乱改）

包（实质：文件夹）

1. 同名看得见
2. 逻辑组织：模块=包，不同人开发=并行
3. 逻辑是不同的包

包名：域名倒着写+模块名 zjgsu.edu.cn->cn.edu.zjgsu.week06



package语句必须是第一行

javac -d . *.java 在当前目录下建立java目录

|           | 同一个类 | 同一个包 | 子类 | 所有类 |
| --------- | -------- | -------- | ---- | ------ |
| private   | *        |          |      |        |
| default   | *        | *        |      |        |
| protected | *        | *        | *    |        |
| public    | *        | *        | *    | *      |

private:本类访问权限

补充：默认构造方法的问题

default：子类访问权限

protected：同一个包中的子类可以，不同包中的子类也可以，不同包中的非子类不行

public：权限很大，在所有地方都可以访问

外部类的封装：public ，default

方法的封装：四个全部

属性的封装：四个全部

面向对象三大特征：继承、封装、多态、抽象

#### 继承

子类拥有父类的属性和方法 ，提供代码的复用

父类是对一批类的抽象，类是对对象的抽象

类是单继承，允许多层继承，不允许多重继承，只能继承非私有的属性和方法；接口允许多继承

构造方法不能被继承

```java
Animal an=new Animal();
	System.out.println(an);
//result:animals.Animal@6d06d69c
```

 如果没有加extend，自动认为是object的子类

直接打印对象，默认call对象的callstring方法

object是所有java类的父类。

java.lang下的类自动导入

覆盖重写条件

1. 返回值，方法名，参数一致
2. 子类访问级别>=父类
3. 子类异常<=父类

重载：在同一个类中；一同（方法名同）一不同；方法名同，参数：个数+顺序+类型

重写：不同类，在父子之间；三同两约束；三同：方法名+返回值+参数；约束：private/public/default/protected修饰符要放大

所有的构造函数第一句都是super（）；

final int LIFE;常量，全大写，常量只能被赋值一次

final void say() ;方法不能被子类重写

final是类的话不能被继承

static：类变量，类方法，属于类。static的东西在对象之前，若static int cnt；可以直接用类访问：Animal.cnt。被对象共享（可用于对象计数）。不属于任何对象

//	Integer.toBinaryString();2进制
//	Integer.toHexString(i);16
//	Integer.toOctalString(i);8

## 11.9

继承的本质：包裹模型

![img](file:///C:\Users\LENOVO\Documents\Tencent Files\1242884655\Image\C2C\9C2A88C0526E6133185C1C7D700F869B.jpg)

无论是cat，animal，homecat都是指的是一个this 

若cat,animal,homecat的构造函数中都有this，这个this指的是最外层的homecat的this，而homecat，他们赋值赋的都是同一个name。

csv

### 11.16

```java
Animal a = new Dog();
a.say();
if(a instanceof Dog)
    ((Dog)a).watchDoor();
//编译时的type，运行时的type
System.out.println("finish");
```

 内部类

- static内部类（类内部类）

- 成员内部类

  可以直接访问外面的属性和方法

类完整名 com.weifengpan.xx$内部类名

```
System.out.prinln(new Animal(){
public void say(){};
public void walk(){}; 
});
```

### 数组

默认初始化 `int[] c = new int[3]`

静态初始化`int[] e = {0,1,2}`

c语言中数组是常量，而java中数组是变量

java中与c语言中数组的区别

names.lenth是通过native实现的

增强for循环

```java
for(String s:names)
{
 
}
//双重循环
for(int[] i:b)
{

}
```

resize

`int[][] b= new int [3][];`

无返回值必须写void

实惨列表和形参列表要匹配

数据传递

{int a=3};

{int a=4};

两个块内不冲突

## 11.23

String charAt (int index) 返回指定**索引（从0开始）**的char

call hierarchy 是确定

static类

享元

string的源码

# Java String indexOf() 方法

------

indexOf() 方法有以下四种形式：

- **public int indexOf(int ch):** 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
- **public int indexOf(int ch, int fromIndex):** 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
- **int indexOf(String str):** 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
- **int indexOf(String str, int fromIndex):** 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。

```java
public class 数组的自增 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        // 静态数组
        int [] staticArray = {1, 2, 3, 4, 5, 6, 0};

        System.out.println("请输入你要插入的数字：");
        int item = sc.nextInt();

        // 添加数据
        staticArray = addItemToArray(staticArray, item);
        staticArray = addItemToArray(staticArray, item);
        // 输出数组
        printIntArray(staticArray);


    }

```

```java
//字符串分割
String str = "www-runoob-com";
      String[] temp;
      String delimeter = "-";  // 指定分割字符
      temp = str.split(delimeter); // 分割字符串
      // 普通 for 循环
      for(int i =0; i < temp.length ; i++){
         System.out.println(temp[i]);
         System.out.println("");
      }
```

## 11.30

String

- all

Array

- equal
- fill
- toString
- copyof

Math

- random

Scanner

- 需要额外添加包util

字符串拼接容易产生垃圾

StringBuffer

synchronized 同步处理

集合（collection）vector arraylist hashset hashmap iterator

hashset



自动装箱，自动拆箱

`HashSet<Student>`

容器：容纳别人的器；

- collection
  - set
    - HashSet
  - list
    - ArrayList
- Map
  - HashMap



