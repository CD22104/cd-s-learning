<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (注释)此文件由 GB2UTF8 1.2 Beta 生成于 2009-3-31 12:46:59，软件作者：阿勇(fxy_2002@163.com) pc-soft.cn -->
<!--#include file="constant.asp"-->
<% person = Request.Form("person") %>
<% title="登录<font color=green>" & person & "</font>的本周工作进度" %>
<!--#include file="head.asp"-->
<!--#include file="function.asp"-->
<center>[<a href=listEachPerson.asp?person=<%=person%>><%=person%>的所有登录资料</a>][<a href=index.asp>回到主选单</a>]</center>

<%
session("finished0")=""
session("finished1")=""
session("finished2")=""
session("finished3")=""
session("finished4")=""
session("thisTask0")=""
session("thisTask1")=""
session("thisTask2")=""
session("thisTask3")=""
session("thisTask4")=""
session("thisDate0")=""
session("thisDate1")=""
session("thisDate2")=""
session("thisDate3")=""
session("thisDate4")=""
session("prevTask0")=""
session("prevTask1")=""
session("prevTask2")=""
session("prevTask3")=""
session("prevTask4")=""
session("prevDate0")=""
session("prevDate1")=""
session("prevDate2")=""
session("prevDate3")=""
session("prevDate4")=""
session("summary")=""

'Find the date of the last record
Set Conn = Server.CreateObject("ADODB.Connection")
Conn.Open "DBQ=" & Server.MapPath(progressDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
sql = "select * from work where name='" & person & "' order by entryDate desc"
'Response.Write(sql)
'Response.End
Set RS = Conn.Execute(sql)
If RS.Eof=FALSE Then	' 找到最後一笔资料
	LastEntryDate = DateValue(RS("entryDate"))
	If sameweek(date, LastEntryDate) Then		' 若和目前时间在同一个星期，则显示旧资料
		session("finished0")=RS("finished0")
		session("finished1")=RS("finished1")
		session("finished2")=RS("finished2")
		session("finished3")=RS("finished3")
		session("finished4")=RS("finished4")
		session("thisTask0")=RS("thisTask0")
		session("thisTask1")=RS("thisTask1")
		session("thisTask2")=RS("thisTask2")
		session("thisTask3")=RS("thisTask3")
		session("thisTask4")=RS("thisTask4")
		session("thisDate0")=RS("thisDate0")
		session("thisDate1")=RS("thisDate1")
		session("thisDate2")=RS("thisDate2")
		session("thisDate3")=RS("thisDate3")
		session("thisDate4")=RS("thisDate4")
		session("summary")=RS("summary")
		RS.MoveNext	' 找看看是否有下一笔资料
		If RS.Eof=FALSE	Then	' 找到第二笔资料，应该是上星期的资料
			session("prevTask0")=RS("thisTask0")
			session("prevTask1")=RS("thisTask1")
			session("prevTask2")=RS("thisTask2")
			session("prevTask3")=RS("thisTask3")
			session("prevTask4")=RS("thisTask4")
			session("prevDate0")=RS("thisDate0")
			session("prevDate1")=RS("thisDate1")
			session("prevDate2")=RS("thisDate2")
			session("prevDate3")=RS("thisDate3")
			session("prevDate4")=RS("thisDate4")
		End If
	Else					' 若和目前时间不在同一个星期...
		session("prevTask0")=RS("thisTask0")
		session("prevTask1")=RS("thisTask1")
		session("prevTask2")=RS("thisTask2")
		session("prevTask3")=RS("thisTask3")
		session("prevTask4")=RS("thisTask4")
		session("prevDate0")=RS("thisDate0")
		session("prevDate1")=RS("thisDate1")
		session("prevDate2")=RS("thisDate2")
		session("prevDate3")=RS("thisDate3")
		session("prevDate4")=RS("thisDate4")
	End If
End If

RS.Close
Conn.Close
%>

<form method=post action="register.asp">
<table border=1 align=center>
<tr>
<th align=center colspan=2>上周预定完成事项
<th align=center rowspan=2>本周完成事项
<th align=center colspan=2>下周预定完成事项
<th align=center rowspan=2>综合说明
<tr>
<th align=center>工作描述<th align=center>预定完成日期
<th align=center>工作描述<th align=center>预定完成日期
<% For i=0 to 4 %>
	<tr>
	<td><%=session("prevTask" & i)%>&nbsp;
	<td><%=session("prevDate" & i)%>&nbsp;
	<td><textarea name=<%=("finished" & i)%> cols=20 rows=3 wrap=virtual><%=session("finished" & i)%></textarea>
	<td><textarea name=<%=("thisTask" & i)%> cols=20 rows=3 wrap=virtual><%=session("thisTask" & i)%></textarea>
	<td><textarea name=<%=("thisDate" & i)%> cols=15 rows=3 wrap=virtual><%=session("thisDate" & i)%></textarea>
	<% If i=0 Then %>
	<td rowspan=5><textarea name="summary" cols=20 rows=18 wrap=virtual><%=session("summary")%></textarea>
	<% End If %>
<% Next %>
</table>

<input type=submit value="送出表单">
<input type=reset  value="恢复原值">
</h3>
<p align=center>
<input type=hidden name="person" value="<%=person%>">
</form>

<!--#include file="foot.asp"-->