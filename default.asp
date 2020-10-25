<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (注释)此文件由 GB2UTF8 1.2 Beta 生成于 2009-3-31 12:46:59，软件作者：阿勇(fxy_2002@163.com) pc-soft.cn -->
<!--#include file="constant.asp"-->
<%title="MIR 实验室工作进度登录网页"%>
<!--#include file="head.asp"-->
<!--#include file="function.asp"-->

<h3><img src="redball.gif">
填写进度</h3>
<% students = getMirStudentName %>
<center>

<form name=form1 action="form.asp" method=post target=_blank>
<select name="person" >
<option>=== 请选您的姓名 ===
<% For i = 0 to UBound(students)
    
    Response.Write("<option>" & students(i))      
Next %>
</select>
<br />
密码: <input type=password size=10 name=password>
<input type=submit value="登陆">
<p align=center>
<input type=hidden name="person" value="<%=person%>">
</form>

</center>
<ol>
<li>请务必在每星期五下午五点前填写完毕。过了星期六午夜，系统自动跳到下一周，就无法再填写本周的进度了。
<li>请务必每一栏都要填写，尤其是「本周预定完成事项」，一定要填入相关的「预定完成时间」。
</ol>
<hr>

<h3><img src="redball.gif">
资料列表</h3>
<ul>
<li>每周填写之资料：
	<a target=_blank href="listEachWeek.asp?weekDiff=0">本周</a>、
	<a target=_blank href="listEachWeek.asp?weekDiff=-1">前一周</a>、
	<a target=_blank href="listEachWeek.asp?weekDiff=-2">前两周</a>、
	<a target=_blank href="listEachWeek.asp?weekDiff=-3">前三周</a>、
	<a target=_blank href="listEachWeek.asp?weekDiff=-4">前四周</a>
<li>每个人的历史资料：
<% For i = 0 to UBound(students)
	If i=0 Then
		Response.Write("<a target=_blank href=listEachPerson.asp?person=" & students(i) & ">" & students(i) & "</a>")
	Else
		Response.Write("、<a target=_blank href=listEachPerson.asp?person=" & students(i) & ">" & students(i) & "</a>")
	End If
Next %>
<li><a target=_blank href="listAllPersonLastRecord.asp">每个人的最後一笔资料</a>
</ul>
<hr>

<h3><img src="redball.gif">
有关本系统</h3>
<ul>
<li>本系统特点：超级简单易用，适合忙碌的管理者
<li>想要把整套系统移植到自己的实验室使用吗？没问题，请直接和本系统发展者<a href="http://www.cs.nthu.edu.tw/~jang">张智星</a>接洽。
</ul>
<hr>
<p align=right><font size=-1>By <a href="http://www.cs.nthu.edu.tw/~jang">Roger Jang</a></font>

</ul>
<!!--#include file="foot.asp"-->