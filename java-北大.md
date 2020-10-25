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

