# HTML5：超文本标记语言

html5：用来表达是什么，而不是表达格式

### 标记

```html
<!DOCTYPE html>
<html>
    <head>
        <title>我的页面</title>
        <meta charet=utf-8>
    </head>
    <body>
        我的第一个html页面
    </body>
</html>
```

>  浏览器会根据本机编码来解析html

## 段落（一般浏览器不换行）

分段<p></p>——段落，最后呈现的效果（如是否空行等等，由浏览器来决定）

段内分行`<br>`无结束标记

第一级标题`<h1></h1>`,可作六级标题，数字越大，字符越小（内含自动换行）

拆单词`<wbr></wbr>`，告诉浏览器此单词可分开，以保证右对齐

连续的两层标题`<hgroup></hgroup>`

```html
<hgroup>
    <h1>我喜欢</h1>
    <h2>你啊</h2>
</hgroup>
```

### 字体样式

加粗`<b></b>`,斜体`<i></i>`,可嵌套

打字机的字体`<tt></tt>`,字缩小`<small></small>`

删除`<del></del>`加入`<ins><ins>`

不被提倡的`<s></s>`效果与del类似

上标( 平方)`<sup></sup>`,下标`<sub></sub>`

高亮`<mark><mark>`

### 短语格式

强调`<em></em>`着重`<strong></strong>`,定义`<dfn></dfn>`，代码（小段）`<code></code>`，例子代码`<samp></samp>`，用户输入`<kbd></kbd>`，变量`<var></var>`，引用`<cite></cite>`

### 特殊格式

地址`<address></address>`，缩进（可嵌套）`<blockquote></blockquote>`，小引用`<q></q>`,不做格式重排（可原本展示原有格式）`<pre></pre>`

### 属性

加入分割线`<hr>`，无结束符号，`<hr width=50%>`(width=50,占50个像素点),分割线长度占页面50%，高度size=10，align=lest 靠左，缩写`<abbr title="中华人民共和国">PRC</abbr>`

> 所有标记都可跟`title=“”`在鼠标停留后出现文字

`<bdo dir=rtl><bdi></bdi></bdo>`,文字从右向左排

小于符号/大于符号：a<2——`a&lt;2`,a>2——`a&gt;2`,&:`&amp;`,不可打断的空格`&nbsp;`&uuml;——`&uuml;`,&Uuml;——`&Uuml；`

### 列表

形成文字前的·（形成文字前的数字，即将`<ul>`变成`<ol>`）

```html
<ul>
    <li>红茶</li>
    <li>可乐</li>
</ul>
```

若用`<ol strart=-1>`,则第一个项目标号-1

### 形成词条

<dl>
    <dt>方糖</dt>
    <dd>方的糖，甜的</dd>
</dl>

```
<dl>
    <dt>方糖</dt>
    <dd>方的糖，甜的</dd>
</dl>
```

### 图片

在html中被看做一个字符，从左往右与字符一起排`<img src="mama.jpg(可加其他网站的网址)" width="200" alt="mama"(放在图片底层，以免加载不出)/>`，传统上属性的值加引号，gif，jpg，png其他格式不一定可在浏览器看，加入网页`<iframe src="http://....com"><iframe>`,可加width hight属性

### 链接

1. `<a href="http:  "（协议非常重要，要是没有会找当前目录下）>网易新闻</a>`，在文字“网易新闻上”加超链接
2. 导航至该网页里的某一段落：在某一段落的`<p>`中写上`<p id="haha">`(h1,h2也可以用)，用超链接`<a href="you.html #haha">前往you网页的位置</a>`

若有`<a href="http://news.163.com" target=-blank(建立新的空白页面)>网易新闻</a>`

在图形上建立超链接

`<img src="" width=100 hight=100 usemap="#map" />`

```html
<map name="map">
    <area shape="ract" coords="0,0(坐标),50,50（长宽）" href="http..." alt="news" />
  <area shape="circle" coords="75,75,25（半径）" href="http..." alt="news" />  
</map>
```

### 表格

`<table></table>`,大表格有

```html
<thead>
<tbody>
<tfoot>
</tfoot>
</tbody>
</thead>
```

`<table>:此时无格子线<table border="1">:此时有格子线`

```html
<tr>表格的一行
    <td>ios</td>一行中的一格
    <td>yes</td>
    <td>yes</td>
</tr>

<thead>
    <tr>
        <th>OS</th>
        <th>Chinese</th>
        <th>French</th>
    </tr>
</thead>
```

</thead><caption>`表格`</caption>

列宽会根据表格自动调整