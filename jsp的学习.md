# jsp的学习
## jsp的概念
全名Java Server Pages,可以看作简易版的Servlet，是一种动态网页技术标准  
> 动态网页会实时更新，静态网页则不会变化，动态网页需要服务端脚本语言，静态网页不需要。 

jsp基于BS架构，以tomcat为服务器  
> ### cs架构（client server）：如qq服务器和客户端，每个人的手机上都有一个qq的应用软件  
> > 优点：响应快，更美观。
> > 缺点：如果软件升级，则每个客户端都需要升级，且每一个用户都需要安装软件，若有一个客户端坏了，需要特定的维修。  
> ### bs架构（browser server）：如京东服务器，他的客户端是各个浏览器（如IE，火狐）
> > 优点：a.服务器本身升级即可 b.只要浏览器不坏，一般都可以运营（服务器一般不会坏），维护方便

## 访问tomcat的常见错误情况
1.404：资源不存在  
2.500：服务器内部错误（代码有误）  
3.403：权限不足  
4.300/301:页面重定向（跳转）  
5.200：一切正常  

## 虚拟
### 虚拟路径
在tomcat中webapps是一个虚拟路径
①配置虚拟路径可以在tomcat/config/server.xml中的<host>中配置`<context docBase="" path="" />`，其中path是相对于webapps的相对路径，docBase是项目的实际路径，以后访问path会自动访问docBase，此种配置需要重启tomcat  
②在/conf/catalina/localhost中创建Jspproject.xml,写一句`<context docBase="" path="" />`  
### 虚拟主机
如访问www.test.com。先在本机域名解析器解析（变成ip地址），若有，则不联网查找，若无，则联网进行解析查找。  
想要通过www.test.com访问本机ip，则①需要在/conf/server.xml的<Engine>中写  

```jsp
<Host appBase="" name="www.test.com">
    <context ...>
</Host>
```
并在<Engine>中将默认引擎改为www.test.com  ②在本机Windows/system/drivers/etc中将hosts中写入`127.0.0.1  www.test.com`即可  
总：浏览器输入www.test.com->hosts中找映射->server.xml中找引擎->找到虚拟路径
> 注：每个网页的默认端口为80

## 统一字符集编码
### 编码分类
1.设置jsp文件的编码（jsp文件的pageEncoding属性，即jsp->java）  
2.设置浏览器读取jsp文件的编码（jsp文件的content属性）  
*.一般将以上统一为utf-8编码
### 文本编码
1.整体Eclipse的设置 2.单个项目的设置 3.项目中单个文件的设置  

## jsp的执行流程
`客户端（如IE）`<——>`tomcat服务器`   
[请求——>  响应<—— ]第一次访问jsp->java->class，后面直接访问class文件（若有修改则需重新编译，即视为第一次访问）  

## Eclipse中创建web项目
### 项目组成
项目中有①WEB-INF文件夹，其中有web.xml（描述性文本，其中可以设置默认的初始页面）  
```jsp
<welcome-file-list>   
    <welcome-file>index.jsp</welcome-file>  
</welcome-file-list>
```
 ②class文件目录：放置最终执行文件，如JSP->java->class  ③lib文件目录：放置第三方依赖，jar包
### jsp在Eclipse中执行
浏览器可以直接执行webcontent中的文件，但WEB-INF中的文件无法通过客户端直接访问，只能通过请求转发来访问  
> 注：并不是任何的内部跳转都能访问到WEB-INF，原因是跳转有两种办法：①请求转发，②重定向  
> 配置tomcat运行的环境(apache tomcat9.0)：右键项目->build path->add library->server runtime
### 部署tomcat
添加server后在server中添加项目（Eclipse中的tomcat和本机上的tomcat是分别独立的，一般建议将两者保持一致：
通过第一次创建tomcat实例后，将双击选择server location，将Eclipse中的tomcat变成托管模式即use tomcat installation
### 重启tomcat服务
一般而言，修改web.xml，配置文件，Java文件，需要重启tomcat服务  

## jsp的页面元素
### 脚本scriptlet
1.<% 局部变量，Java语句 %>
2.<%! 全局变量，方法 %>
3.<%=输出表达式%>  
> 注：3.语句的输出不写分号，而2.语句的输出要写分号——如<%="hello"+name%>相当于<%out.print("hello"+name);%> 
> <%out.print("hello"+name);%>此语句用out.println也同样不会回车，在网页中要用`<br />`回车
### 指令
如page指令——<%@page ... %>，page指令可指定的属性有，language（jsp使用的脚本语言），import（导入类），pageEncoding,contentType（浏览器解析jsp编码）  
### 注释
1. HTML注释<!-- --> 只有他能在网页源码中被看见
2. Java注释//  /*  */
3. jsp注释<%-- --%>
### jsp内置对象（自带的，不需要new也能使用的对象）
#### 1.out 向用户端输出内容

#### 2.request 请求对象储存客户端

向服务端发送的请求信息 `客户端（服务器）`-(请求)->`服务端tomcat/jsp`

```
request的常用方法：
String getParameter(String name) 根据字段返回值  
String[] getParameterValues(String name) 根据key返回多个字段值  
Void setCharacterEncoding() 设置post方式请求编码（tomcat7之前用的是iso8859-1，tomcat8以后默认为utf-8）  
```
> 注册页面的建立
```jsp
register.jsp
<body>
	<form action="show.jsp">
		用户名：<input type="text" name="uname" /><br />
		passward:<input type="password" name="upsd" /><br />
		age:<input type="text" name="uage" /><br />
		hobbies:<br />
		<input type="checkbox" name="uhobbies" value="足球" />足球
		<input type="checkbox" name="uhobbies" value="篮球"/>篮球
		<input type="checkbox" name="uhobbies" value="乒乓球"/>乒乓球<br />
		<input type="submit" name="注册" /> 
	</form>
</body>

show.jsp
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("uname");
	int age = Integer.parseInt(request.getParameter("uage"));
	String pwd = request.getParameter("upwd");
	String[] hobbies = request.getParameterValues("uhobbies") ;
	%>
	注册成功，信息如下：<br />
	姓名：<%=name %><br />
	年龄：<%=age %><br />
	密码：<%=pwd %><br />
	爱好：<br />
	<%
	for(String hobby :hobbies)
	{
		out.print(hobby+ "&nbsp;");//&nbsp;为空格
	}
	%>
</body>

得到show.jsp的地址http://localhost:8080/test/show.jsp?uname=123&upsd=123&uage=12&uhobbies=%E8%B6%B3%E7%90%83&uhobbies=%E7%AF%AE%E7%90%83&%E6%B3%A8%E5%86%8C=%E6%8F%90%E4%BA%A4%E6%9F%A5%E8%AF%A2%E5%86%85%E5%AE%B9
```
> ### 提交方式
> get提交方式
> * 1.在jsp文件中提交方式的指定：`<form action="show.jsp"，method="get" >`2.地址栏 3.超链接`<a href="xx">`  
> * 与post的区别:  
> 1. get方式在地址栏显示信息，可容纳信息有限，仅4-5kb,容纳不下会报错，而post不会
> 2. 若牵涉到文件上传，密码保密则使用post，推荐使用post
> ### 统一请求的编码request（乱码解决方式）
> 1. get方式请求：
> * a.统一每个变量的编码`new String = (name.getBytes(iso-8859-1),"utf-8");`不推荐
> * b.修改server.xml，一次性地更改tomcat默认get提交的编码：第64行——`<Connector connectionTimeout="20000" ... redictRort="8443" URIEncoding="utf-8" />`使get的方式为utf-8（推荐在使用使先统一）
> 2. post方式请求
>
> * `request.setCharacterEncoding("utf-8");`同上述代码

#### 3.response:响应对象`客户端`—（响应）—>服务端

```java
提供的方法：
void addCookie(Cookie cookie);服务端向客户端增加cookie对象
void sendRedirect(String location) throws IOException;页面跳转的一种方法（重定向）
void setContetType(String type) 设置服务端响应的编码
```

> 登陆页面的建立

```jsp
login.jsp->check.jsp->success.jsp
login.jsp
<body>
	<form action="check.jsp" method="post"> <!--一般不设置method默认post-->
		用户名：<input type="text" name="uname"><br />
		密码：<input type="password" name="upwd"><br />
		提交：<input type="submit" name="登陆"><br />
	</form>
</body>
check.jsp
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		if(name.equals("zs")&& pwd.equals("abc"))//假设zs abc
		{
            //相对路径
			//response.sendRedirect("success.jsp");
			//重定向导致数据丢失，最后页面处于success.jsp
			request.getRequestDispatcher("success.jsp").forward(request,response);
			//页面跳转：请求转发,可以获取到数据，地址栏没有改变（仍为check.jsp）
		}
		else
		{
			//登陆失败
			out.print("用户名或密码有误");
		}
	%>
</body>
success.jsp
<body>
	登陆成功！
	欢迎您：
	<%
		String name =request.getParameter("uname");
		out.print(name);
	%>
</body>
```

> 请求转发，重定向
>
> |                          | 请求转发          | 重定向             |
> | ------------------------ | ----------------- | ------------------ |
> | 地址栏是否改变           | 不变（check.jsp） | 改变(success.jsp)  |
> | 是否保留第一次请求的数据 | 保留              | 不保留             |
> | 请求的次数               | 1                 | 2                  |
> | 跳转发生的位置           | 服务端            | 客户端发出二次跳转 |
>
> 请求转发：客户端->【服务端check.jsp->服务端success.jsp】
> ```mermaid
> sequenceDiagram
> 客户端 ->> 服务端check.jsp: 第一次请求request
> 服务端check.jsp ->> 服务端success.jsp: 请求转发
> 服务端success.jsp ->> 客户端: 响应
> ```
> 重定向：客户端->服务端check.jsp:响应——去找服务端success.jsp，客户端->服务端sucess.jsp
>
> ```mermaid
> sequenceDiagram
> 客户端 ->> 服务端check.jsp: 第一次请求request
> 服务端check.jsp ->>客户端: 第一次响应（指向新的跳转地址success.jsp）
> 客户端 ->> 服务端success.jsp: 第二次请求request
> 服务端success.jsp ->>客户端: 第一次响应
> ```

#### 4.session（服务端）

> ##### Cookie(客户端，不是内置对象)
>
> cookie是由服务端生成的，再发送给客户端保存。
>
> 相当于本地缓存：客户端->服务端 （客户端访问服务端，在第一次访问之后会产生一个cookie，如hello.mp4,在第一次观看时会使用网络流量，但在观看完后会产生一个cookie发送给客户端，使在下一次直接在本机看）
>
> 缺点：导致不安全（如自动登录） 优点：提高访问服务端的效率
>
> Cookie包含一个 key-value对，是由javax.servlet.http.Cookie这个类产生的对象
>
> ###### 方法
>
> ```java
> public Cookie(String key,String value)构造
> String getName()获取name
> String getValue()获取value
> void setMaxAge(int expiry);最大有效期（秒）
> ```
>
> ###### 服务端发给客户端的过程
>
> 1.服务端准备cookie`public Cookie(String key,String value）` `response.addCookie(Cookie cookie)`
>
> 2.页面跳转（转发/重定向）
>
> 3.客户端获取cookie: `request.getCookies();`
> ```jsp
> cookie应用案例：
> /Cookie/response_addcookie.jsp
> <body>
> 	<%
> 	//服务端
> 	Cookie cookie1=new Cookie("name","zs");
> 	Cookie cookie2=new Cookie("pwd","abc");
> 	response.addCookie(cookie1);
> 	response.addCookie(cookie2);
> 	
> 	//页面跳转到客户端（转发，重定向）
> 	response.sendRedirect("result.jsp");
> 	%>
> </body>
> /Cookie/result.jsp
> <body>
> 	<% 
> 	//客户端
> 		Cookie[] cookies = request.getCookies();
> 		for(Cookie cookie:cookies)
> 		{
> 		out.print(cookie.getName()+"--"+cookie.getValue()+"<br />");
> 		}
> 	%>
> </body>
> ```
> _注：a.服务端增加cookie：response 	客户端获取对象：request	b.不能直接获取某一个单独对象，只能一次性将所有的cookie全部拿到_
>
> ![](C:\Users\LENOVO\Desktop\cd-s-learning\图片\cookie.PNG)
> 通过F12可以发现，除了自己设置的cookie对象外，还有一个name为JSESSIONID的cookie
>
> 建议cookie中仅保存英文和数字，否则需要进行编码解码处理
>
> ```jsp
> 记住用户
> login.jsp->check.jsp->A.jsp
> login.jsp:
> <body>
> 	<%!
> 	String uname;
> 	%>
> 	<%
> 	Cookie[] cookies=request.getCookies();
> 	for(Cookie cookie :cookies)
> 	{
> 		if(cookie.getName().equals("uname")){
> 			uname=cookie.getValue();
> 		}
> 	}
> 	%>
> 	<form action="check.jsp" method="post"> <!--一般不设置method默认post-->
> 		用户名：<input type="text" name="uname" value="<%=(uname==null?"":uname) %>"><br />
> 		密码：<input type="password" name="upwd"><br />
> 		提交：<input type="submit" name="登陆"><br />
> 	</form>
> </body>
> check.jsp:
> <body>
> 	<%
> 		request.setCharacterEncoding("utf-8");
> 		String name = request.getParameter("uname");
> 		String pwd = request.getParameter("upwd");
> 		//将用户名加入到Cookie中
> 		Cookie cookie = new Cookie("uname",name);
> 		response.addCookie(cookie);//将Cookie发回给cookie
> 		response.sendRedirect("A.jsp");
> 	%>
> </body>
> A.jsp:
> <body>
> 	登陆成功！
> 	欢迎您：
> 	<%
> 		String name =request.getParameter("uname");
> 		out.print(name);
> 	%>
> </body>
> ```
>
> 此时cookie可在整个客户端通用(此时操作后IE,FIREFOX等打开login.jsp都已填入uname)
>
> ```mermaid
> sequenceDiagram
> 客户端login.jsp ->> 服务端check.jsp: 请求request
> 服务端check.jsp ->>客户端A.jsp/或其他: 跳转response
> ```
>
> 

#### 5.application

#### 6.pageContext

#### 7.config

#### 8.page

#### 9.exception