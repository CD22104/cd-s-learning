<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (注释)此文件由 GB2UTF8 1.2 Beta 生成于 2009-3-31 12:46:59，软件作者：阿勇(fxy_2002@163.com) pc-soft.cn -->
<!--#include file="constant.asp"-->
<%title="MIR 实验室工作进度：每个人的最後一笔资料"%>
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
<% students = getMirStudentName
j=0
For row = 0 to UBound(students)
	person = students(row)
	Set Conn = Server.CreateObject("ADODB.Connection")
	Conn.Open "DBQ=" & Server.MapPath(progressDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
	sql = "select * from work where name = '" & person & "' order by entryDate desc"
	set RS = Conn.Execute(sql)
	If Not RS.Eof Then %>
		<tr>
		<td bgcolor=<%=color(j)%> align=center><a target=_blank href="listEachPerson.asp?person=<%=person%>"><%=person%></a> </td>
		<td bgcolor=<%=color(j)%> valign=top><% PrintField RS, "finished", 0 %> &nbsp; </td>
		<td bgcolor=<%=color(j)%> valign=top><% PrintDateTask RS, "thisDate", "thisTask" %> &nbsp; </td>
		<td bgcolor=<%=color(j)%> valign=top><%=RS("summary")%> &nbsp;</td>
		<td bgcolor=<%=color(j)%> valign=top><%=RS("entryDate")%><br><%=RS("entryTime")%> &nbsp; </td>
	<% Else %>
		<tr>
		<td bgcolor=<%=color(j)%> align=center><a target=_blank href="listEachPerson.asp?person=<%=person%>"><%=person%></a> </td>
		<td bgcolor=gray valign=top>&nbsp;</td>
		<td bgcolor=gray valign=top>&nbsp;</td>
		<td bgcolor=gray valign=top>&nbsp;</td>
		<td bgcolor=gray valign=top>&nbsp;</td>
		<td bgcolor=gray valign=top>&nbsp;</td>
	<% End If
	RS.close
	j = j+1
	If j=UBound(color)+1 Then
		j=0
	End If
Next %>
</table>
<% Conn.Close %>

</body>
</html>