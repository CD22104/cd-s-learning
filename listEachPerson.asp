<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (注释)此文件由 GB2UTF8 1.2 Beta 生成于 2009-3-31 12:46:59，软件作者：阿勇(fxy_2002@163.com) pc-soft.cn -->
<!--#include file="constant.asp"-->
<% person=request("person") %>
<%title="MIR 实验室工作进度：" & person & "的全部登录资料"%>
<!--#include file="head.asp"-->
<!--#include file="function.asp"-->
<center>[<a href=default.asp>回到主选单</a>]</center>

<% Dim color(8)
color(0) = "#ffffdd"
color(1) = "#ffeeee"
color(2) = "#eeffee"
color(3) = "#e0e0f9"
color(4) = "#eeeeff"
color(5) = "#ffe9d0"
color(6) = "#ffffdd"
color(7) = "#eeeeff"
color(8) = "#e0e0f9"
%>

<p>
<table border=1 align=center>
<tr>
<th align=center>姓名
<th align=center>本周完成事项
<th align=center>下周预定完成事项：<br>【<font color=red>预定完成日期</font>】工作描述
<th align=center>综合说明
<th align=center> 登录日期
<%
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "DBQ=" & Server.MapPath(progressDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
sql = "select * from work where name = '" & person & "' order by entryDate desc"
set RS = Conn.Execute(sql)
j=0
Do While Not RS.Eof %>
	<tr>
	<td bgcolor=<%=color(j)%> align=center><font color=green><b><%=person%></b></font> </td>
	<td bgcolor=<%=color(j)%> valign=top><% PrintField RS, "finished", 0 %> &nbsp; </td>
	<td bgcolor=<%=color(j)%> valign=top><% PrintDateTask RS, "thisDate", "thisTask" %> &nbsp; </td>
	<td bgcolor=<%=color(j)%> valign=top><%=RS("summary")%> &nbsp;</td>
	<td bgcolor=<%=color(j)%> valign=top><%=RS("entryDate")%><br><%=RS("entryTime")%> &nbsp; </td>
	<% j = j+1
	If j=UBound(color)+1 Then
		j=0
	End If
	RS.MoveNext
Loop %>
</table>
<% RS.close %>
<% Conn.Close %>

</body>
</html>