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

