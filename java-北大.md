# java-北大

path:命令

classpath:所要引用的类的路径

使用package时的编译：文件及路径一致、程序中使用package语句、使用import语句

### jdk中的工具

javac 编译

java 运行

javaw 运行图形界面程序

使用jar打包：打包 jar cvfm A.jar A.man A.class(c创建 v详情 f指定文件名 m清单文件)，A.man是清单文件

使用javadoc生成文档

javap查看类的信息、javap反汇编

### 数据类型与常量

数据类型决定数据的存储方式和运算方式

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









### 类、字段和方法

类包含了字段和方法

构造方法：与类名同名，而且不写返回的数据类型

![image-20201101101015671](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101101015671.png)

类都有一个至多个构造方法，如果没有定义任何构造方法，系统会自动产生一个构造方法，称为默认构造方法 

访问 person p=new Person（）；

好处：封装性，安全性

方法重载：多个方法有相同的名字，编译时能识别出来，各方法的签名不同（参数和参数类型不同），可以实现多态，同一句话做不同的操作

### this的使用

使用this可以解决局部变量和 域同名的变量

this.age(类中域)=age（局部变量）

用this调用另一种构造方法

![image-20201101103138035](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101103138035.png)

this代表也叫person的函数，调用语句必须在第一句

### 类的继承

三大特征：继承，多态，封装

java支持单继承：一个类只能有一个直接父类。

继承可以修改父类的状态或重载父类的行为，可以添加新的状态和行为

好处：提高抽象程度，实现代码重用，提高开发效率和可维护性。

java中的继承是通过extends实现的

class Student extends Person{};

如果没有extends语句，则该类默认为java.lang.Object的子类

![image-20201101103956932](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101103956932.png)

对字段的继承

- 子类默认继承父类的所有字段
- 若子类重新定义一个和父类域变量完全相同的变量，称为域的隐藏或重载

对方法的继承

- 除非加private自动继承
- 通过定义与父类同名的方法可以覆盖和修改（课在前面写上@override）

#### super

用于访问父类的字段和方法。可以用this.age或super.age 访问父类的域和方法

![image-20201101105036988](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101105036988.png)

若子类也有age，父类也有age，此时理应子类覆盖了父类的，但可以用super找回父类的age

构造方法是不能继承的（构造方法与类同名）

![image-20201101105535963](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101105535963.png)

子类的对象可以被视为父类

父类的对象不能视为子类

父类类型变子类可以强制类型转换

![image-20201101110502748](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101110502748.png)

### 包

与类的继承没有关系，子类和父类可以位于不同的包中。是为了解决名字空间，名字冲突

包有两方面的含义

1. 名字空间、存储路径（文件夹）
2. 可访问性（同一包中的各个类，默认情况下可互相访问）

包层次的根目录是由环境变量classpath来决定的

需要用import语句来导入所需要的类

编译和运行是要使用javac将.class文件放入相应的目录，用-d指明包的根目录javac -d d:\tang\ch04,运行时指明含有main的类名

编译和运行多个包时指明这些包的根目录用classpath

![image-20201101111733918](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101111733918.png)

### 访问控制/修饰符

修饰符:可以修饰类，也可以修饰类的成员

- 访问修饰符public/private

![image-20201101140506567](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101140506567.png)

setter与getter

![image-20201101140859359](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101140859359.png)

- 其他修饰符

  ![image-20201101141321653](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101141321653.png)
  - static字段：是类的字段，不属于任何一个对象实例，保存在类的内存区域的公共存储单元 ，可以通过对象或类名来访问，可以用来表示全局变量

    ![image-20201101142102244](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101142102244.png)

    static方法（类方法）

    也是在整个类里的内存，属于整个类，不能访问实例变量，不能使用this或super

  - final类：不能被继承，不能被继承

    final方法：不能被覆盖

    final字段、局部变量：值被给定，不能更改，只读亮，只被赋值一次

    static final 可以表示常量，若不赋值为0，false，null

  - abstract类：不能被实例化

    abstract方法只需声明，不需实现，用；而不是{}

    抽象类中包含抽象方法，若一个类中包含了abstract方法，则必须声明为abstract类，但abstract类里可以不包含abstract方法

### 接口interface

某种特征的约定，定义的接口都是public abstract

接口可以实现多继承，与类的继承关系无关

![image-20201101144306631](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101144306631.png)

接口也是引用类型（三大引用类型：class，接口，数组）

作用

- 可以实现不相关类的相同行为，不需要考虑这些类之间的层次关系，在一定意义上实现了多重继承
- 指明多个类需要实现的方法
- 可以了解对象的交互页面不需了解对象对应的类

![image-20201101144601257](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101144601257.png)

接口里面自动public

接口中的常量具有Public,static,final的属性

java8以上接口还可以是static

### 类定义

![image-20201101145242481](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101145242481.png)

![image-20201101145428025](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101145428025.png)

![image-20201101145613645](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101145613645.png)

### 变量及其传递

- 基本类型变量：值直接存于变量中，复制值

  引用型变量：除占据一定的内存空间外，引用的对象实体也要占据一定空间， 传递引用值，而不是复制对象实体（可以改变对象的属性）

![image-20201101165643807](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101165643807.png)

- 字段变量（存在堆中，自动赋初值）与局部变量（栈，需显式赋值）
- ![image-20201101170143021](C:\Users\LENOVO\AppData\Roaming\Typora\typora-user-images\image-20201101170143021.png)

