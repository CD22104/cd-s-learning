<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (注释)此文件由 GB2UTF8 1.2 Beta 生成于 2009-3-31 12:46:59，软件作者：阿勇(fxy_2002@163.com) pc-soft.cn -->
<!--#include file="constant.asp"-->
<% person=Request.Form("person") %>
<% password=Request.Form("password") %>
<% title=person & " 工作进度登录表" %>
<!--#include file="head.asp"-->
<!--#include file="function.asp"-->

<%
If Not checkMirPassword(person, password) Then %>
	<p align=center>亲爱的 <font color=green><%=person%></font>，您的认证资料错误，请回<a href="javascript:history.go(-1)">前页</a>修改。
	<% Response.End
End If
%>

<%
'检查资料，确认是修改或是新增
insertNewData=1
recordId=-1
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "DBQ=" & Server.MapPath(progressDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
sql = "select * from work where name='" & person & "' order by entryDate desc"
'Response.Write(sql)
'Response.End
Set RS = Conn.Execute(sql)
If RS.Eof=FALSE Then	' 找到最後一笔资料
	LastEntryDate = DateValue(RS("entryDate"))
	If sameweek(date, LastEntryDate) Then		' 若和目前时间在同一个星期
		insertNewData=0
		recordId=RS("id")
	End If
End If
RS.Close
Conn.Close
%>

<%
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "DBQ=" & Server.MapPath(progressDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
If insertNewData=1 Then	' 插入新资料
	sql = "insert into work (name, entryDate, entryTime, summary, "
	sql = sql & "finished0, finished1, finished2, finished3, finished4, "
	sql = sql & "thisTask0, thisTask1, thisTask2, thisTask3, thisTask4, "
	sql = sql & "thisDate0, thisDate1, thisDate2, thisDate3, thisDate4) values ('"
	sql = sql & Request("person") & "', '"
	sql = sql & date & "', '"
	sql = sql & time & "', '"
	sql = sql & Request("summary") & "', '"
	sql = sql & Request("finished0") & "', '" & Request("finished1") & "', '" & Request("finished2") & "', '" & Request("finished3") & "', '" & Request("finished4") & "', '"
	sql = sql & Request("thisTask0") & "', '" & Request("thisTask1") & "', '" & Request("thisTask2") & "', '" & Request("thisTask3") & "', '" & Request("thisTask4") & "', '"
	sql = sql & Request("thisDate0") & "', '" & Request("thisDate1") & "', '" & Request("thisDate2") & "', '" & Request("thisDate3") & "', '" & Request("thisDate4") & "')"
	'Response.Write sql
	'Response.End
Else	' 更新资料
	sql = "update work set"
	sql = sql & " finished0='" & Request.Form("finished0") & "',"
	sql = sql & " finished1='" & Request.Form("finished1") & "',"
	sql = sql & " finished2='" & Request.Form("finished2") & "',"
	sql = sql & " finished3='" & Request.Form("finished3") & "',"
	sql = sql & " finished4='" & Request.Form("finished4") & "',"
	sql = sql & " thisTask0='" & Request.Form("thisTask0") & "',"
	sql = sql & " thisTask1='" & Request.Form("thisTask1") & "',"
	sql = sql & " thisTask2='" & Request.Form("thisTask2") & "',"
	sql = sql & " thisTask3='" & Request.Form("thisTask3") & "',"
	sql = sql & " thisTask4='" & Request.Form("thisTask4") & "',"
	sql = sql & " thisDate0='" & Request.Form("thisDate0") & "',"
	sql = sql & " thisDate1='" & Request.Form("thisDate1") & "',"
	sql = sql & " thisDate2='" & Request.Form("thisDate2") & "',"
	sql = sql & " thisDate3='" & Request.Form("thisDate3") & "',"
	sql = sql & " thisDate4='" & Request.Form("thisDate4") & "',"
	sql = sql & " summary='" & Request.Form("summary") & "',"
	sql = sql & " entryDate='" & date & "',"
	sql = sql & " entryTime='" & time & "'"
	sql = sql & " where id=" & recordId
	'Response.Write sql
	'Response.End
End If
'Response.write sql
Conn.Execute(sql)

'Retrieve the record just entered
sql = "select * from work where name='" & Request("person") & "' order by entryDate desc"
'Response.write sql
Set RS = Conn.Execute(sql)
%>

<p align=center>
亲爱的 <font color=green><%=RS("name")%></font>，您输入的资料如下。若有错误，可回<a href="javascript:history.go(-1)">前页</a>修改。

<p>
<table align=center border=1>
<tr>
	<th align=center>上周预定完成事项：<br>【<font color=red>预定完成日期</font>】工作描述
	<th align=center>本周完成事项
	<th align=center>下周预定完成事项：<br>【<font color=red>预定完成日期</font>】工作描述
	<th align=center>综合说明
	<th align=center>登录日期
<tr>
	<td valign=top><% PrintSession "prevDate", "prevTask" %> &nbsp; </td>
	<td valign=top><% PrintField RS, "finished", 0 %> &nbsp;</td>
	<td valign=top><% PrintDateTask RS, "thisDate", "thisTask" %> &nbsp; </td>
	<td valign=top><%=RS("summary")%> &nbsp;</td>
	<td><%=RS("entryDate")%><br><%=RS("entryTime")%> &nbsp; </td>
</table>
<% RS.close %>
<% Conn.Close %>
<!--#include file="foot.asp"-->