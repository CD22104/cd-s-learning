<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (ע��)���ļ��� GB2UTF8 1.2 Beta ������ 2009-3-31 12:46:59��������ߣ�����(fxy_2002@163.com) pc-soft.cn -->
<!--#include file="constant.asp"-->
<% person = Request.Form("person") %>
<% title="��¼<font color=green>" & person & "</font>�ı��ܹ�������" %>
<!--#include file="head.asp"-->
<!--#include file="function.asp"-->
<center>[<a href=listEachPerson.asp?person=<%=person%>><%=person%>�����е�¼����</a>][<a href=index.asp>�ص���ѡ��</a>]</center>

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
If RS.Eof=FALSE Then	' �ҵ�����һ������
	LastEntryDate = DateValue(RS("entryDate"))
	If sameweek(date, LastEntryDate) Then		' ����Ŀǰʱ����ͬһ�����ڣ�����ʾ������
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
		RS.MoveNext	' �ҿ����Ƿ�����һ������
		If RS.Eof=FALSE	Then	' �ҵ��ڶ������ϣ�Ӧ���������ڵ�����
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
	Else					' ����Ŀǰʱ�䲻��ͬһ������...
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
<th align=center colspan=2>����Ԥ���������
<th align=center rowspan=2>�����������
<th align=center colspan=2>����Ԥ���������
<th align=center rowspan=2>�ۺ�˵��
<tr>
<th align=center>��������<th align=center>Ԥ���������
<th align=center>��������<th align=center>Ԥ���������
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

<input type=submit value="�ͳ���">
<input type=reset  value="�ָ�ԭֵ">
</h3>
<p align=center>
<input type=hidden name="person" value="<%=person%>">
</form>

<!--#include file="foot.asp"-->