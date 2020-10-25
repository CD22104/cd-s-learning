# maven的学习
## maven的概念
### maven是什么
maven是服务于Java平台的自动化构建工具

> 部署：将Java,js,jsp等各种文件组装筛选变成一个可以直接运行的项目

### maven的用处
1. 可以借助maven将项目分割成多个工程
2. 可以将项目变成jar包放在仓库中供引用
3. 可以通过maven下载jar包，maven也会将需要的jar包自动导入进来
## maven固定的目录结构
### 遵守的原因
要让maven明白各个文件在哪才能进行编译。
方式：①以配置的方式明确 ②遵守约定
_注：约定>配置>编码_
### 目录结构
* project name
    + src(源码)
        - main(放主程序)
            * java（存放Java源文件）
            * resources（存放框架或其他工具的配置文件）
        * test（放测试文件）
            * Java
            * resources
    * pom.xml（project object model / maven工程的核心配置文件）

## 坐标表示

使用3个向量唯一在仓库中定位工程

1.<groupid>公司名、项目名</groupid>  2.<artifactid>特征、模块名</artifactid>  3.<version>版本号</version>

坐标与路径的关系：/group/artifact/version

## 仓库（用于下载所需的jar包）

有1.本地仓库  2.中央仓库  3.中央仓库镜像  【4.私服（公司范围内用的仓库】

访问顺序: 本地仓库—（若无）—>私服—（若无）—>中央仓库  

> 中央仓库的镜像是对中央仓库的分流操作（如中国，美国）

## pom在Eclipse中运行

- 在pom.xml中写完依赖后，需将maven project进行update操作：在pom.xml右击run as,选择build...，在goal中输入命令clean
- goals中可输入clean，test两个命名，因为要重新编译，先要clean

- test中的语句`assertEquals("hello.zs",result);`用于判断是否与预期相等

- main和test下的包裹名称相同，则不用导包，默认在一个文件夹下（约定）

- JDK只能识别source folder中的源码

- 统一项目的jdk：

  - build path

  - 右键项目——属性——project factors——java version(新版本，存在的)

  - 通过maven pom.xml配置

    ```jsp
    <profiles>
        <profile></profile>
    </profiles>
    ```

- 统一版本

  ```jsp
  <properties>
  	<project.build.sourceEncoding><UTF-8>
      <g.a.v的地址>
  </properties>
  后面引用<dependency>
          <g></g><a></a>
          <v>${gav的地址}</v>
         </dependency>
  ```

## maven的重要功能

- 清理：删除编译结果，便于重新编译

- 编译：Java->class

- 测试：用测试代码去测试

- 报告：显示测试结果

- 打包：将项目中的多个文件并为一个（打包：java->jar包，web->war包）

- 安装：将打包成的包放入本地仓库（如A,B,C是一个项目的三个模块，可在处理完A后将其打包放入本地仓库以便B的利用）

- 部署：将包放在服务器上运行

  > ###### Eclipse中布置的web可直接运行，将此项目复制到tomcat/webapps下不能直接运行的原因及解决办法：
  >
  > Eclipse的项目部署时生成一个对应的部署项目在wtpwebapps中，区别在于没有源码文件src，只有class文件和jsp文件，因此tomcat中项目的目录结构与要求不符。
  >
  > 要想在tomcat中运行，就要在Eclipse中部署或将项目打成war包放在tomcat/webapps中（无需解压缩）

### maven的常见命令

- 编译   mvn compile（只编译main文件中的）
- 测试   mvn test
- 打包   mvn package（测试通过才能打包）
- 安装   mvn install（将开发的模块放入本地仓库，供其他项目使用，位置gav）
- 清理   mvn clean（删除target目录，删除编译文件的目录）

> 运行mvn命令必须在pom文件所在的目录

## 依赖

#### 概念

在maven项目中，如果要使用当时存在的jar或模块，可以通过依赖实现（去仓库寻找），如果A中的某些类需要用到B中的某些类，称A依赖于B

#### 依赖的范围及有效性

a.jar->b.jar:maven在编译、测试、运行项目时，各自使用一套classpath

###### 依赖的有效性

| 会否调用仓库里对应的jar包 | compile | test | provided |
| ------------------------- | ------- | ---- | -------- |
| 编译                      | √       |      | √        |
| 测试                      | √       | √    | √        |
| 运行                      | √       |      |          |

###### 代码写法

```jsp
<dependencies>
    <dependency>
        <groupID>...</groupID>
        <artifactID>...</artifactID>
        <version>...</version>
        <scope>...</scope>
    </dependency>
</dependencies>
```

#### maven的依赖排除

通过maven引入A.jar会自动引入B.jar

A.jar(x.java,y.java,z.java)->B.jar(p.java,c.java,i.java)

若A与B的依赖关系仅有z.java->c.java则使用x.java不需引用，则要排除

```jsp
<dependency>
    <g></g>
    <a></a>
    <v></v>
    <exclusions>
        <exclusion>
            <g>
            <a>
        </exclusion>
    </exclusions>        
```

#### 依赖的传递性

要想满足HelloworldTime.jar->Helloworld2.jar->junit4.0.jar，前提是范围为compile

```jsp
<!--Helloworld2.jar中的junit-->
<development>
    <g>junit</g>
    <a>junit</a>
    <v>4.0</v>
    <scope>test</scope><!--范围仅限于test,也可改为compile，不写默认为compile-->
</development>
```

#### 依赖原则

1. 最短优先原则

   HelloworldTime.jar->Helloworld2.jar->junit4.0.jar（两部）

   |-->junit3.8.jar（一步）

   使用junit3.8.jar

2. 路径长度相同

   - 同一文件中有两个相同的依赖，版本不同（一般不需允许出现此种情况）：后面的覆盖前面的

   - 不同文件中有两个相同的依赖：

     HelloworldTime.jar->Helloworld2.jar->commons-io2.4.jar

     |-->Hello->commons-io2.3.jar

     则先声明的覆盖后声明的（如在Helloworldtime中先写的Helloworld2后写的hello，则使用helloworld2中的2.4版本）

> 即在同一个pom中后覆盖前，在不同的pom中前覆盖后

## maven的生命周期

生命周期和构建的关系：执行某命令，会将其之前的命令全部执行一遍，即执行打包命令，则会同时完成编译，测试，打包命令

生命周期包含三个阶段：

1. clean lifecycle   清理（阶段：pre-clean,clean,post-clean）
2. default lifecycle   默认（常用）
3. site lifecycle   站点（阶段：pre-site,site,post-site,site-deploy部署）

## maven的继承

父工程建立pom打包方式，建立 工程中是普通文件夹（不是源码路径）

父工程的打包要用pom的方式

若A继承B，则可以继承B所有的依赖，而依赖中A->B->C要考虑B到C的关系

实现方式：

1. 建立父工程

2. 在父工程中写依赖

   ```jsp
   <dependencyManagement>
       <dependencies>
           <dependency>
           </dependency>
       </dependencies>
   </dependencyManagement>
   ```

3. 给子工程认父工程

   - 加入父工程坐标

   - 当前pom.xml到父工程pom.xml的相对路径

     ```jsp
     <parent>
         <g></g>
         <a></a>
         <v></v>
         <relativePath>.../B/pom.xml</relativePath>
     </parent>        
     ```

     > 一般如果是继承，子工程的pom中的g和v与父工程相同，可以只写a

4. 在子类中需要声明（父类中的依赖可能很多，而子类只需其中的少数），所以子类中的pom依旧用`<dependency><g><a></dependency>`不需要v

## maven的聚合

maven项目能识别的：自身包含，本地仓库中的

Maven2依赖于maven1，则在执行是maven1必须先install（加入仓库），以上前置工程的install操作可以通过install一次搞定

> clean清除的是target目录，但不会清除仓库内容

```jsp
<modules>
    <module>../maven1（项目的根路径，项目名）</module>
    <module>../maven2</module>
</modules>
若此时的顺序有误，系统会自动排序，故无需考虑顺序
```

聚合的配置只能配置在pom方式打包的maven工程中，配置完聚合后，以后只要操作总工程，就会自动操作

## 聚合和继承的区分

聚合：maven可以将大工程分成多个子模块，聚合能将多个子模块合起来

继承：父->子工程，可以通过父工程，统一管理依赖的版本

> pom打包形式，要么是聚合，要么是父类

## 部署web工程（war包）

- src
  - main
    - java
    - resource
    - webapp
      - web-inf-web.xml
      - index.jsp

通过maven直接部署运行web项目：a.配置cargo；b.deploy命令（部署命令），在实际开发中，开发人员将自己的项目开发完后打成war包发给实施人员去部署