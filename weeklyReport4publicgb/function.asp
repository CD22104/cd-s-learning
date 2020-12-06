<%@ CODEPAGE=936 %>
<%Response.Charset="GB2312"%>

<!-- (注释)此文件由 GB2UTF8 1.2 Beta 生成于 2009-3-31 12:46:59，软件作者：阿勇(fxy_2002@163.com) pc-soft.cn -->
<% Function sameweek(date1, date2)
	Dim date0, weekNum1, weekNum2
	'Determine if the given dates are in the same week
	date0 = #1/1/98#
	weekNum1 = DateDiff("ww", date0, date1, vbSunday, vbFirstFullWeek)
	weekNum2 = DateDiff("ww", date0, date2, vbSunday, vbFirstFullWeek)
	If weekNum1=weekNum2 Then
		sameweek = True
	Else
		sameweek = False
	End If
End Function %>

<% Function getMirStudentName
	Dim Conn, RS, SQL, i, x	'Local variables!
	Set Conn = Server.CreateObject("ADODB.Connection")
	' memberDb is defined in constant.inc
	Conn.Open "DBQ=" & Server.MapPath(memberDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
	sql = "select NickName from MIR where acitve=yes order by NickName"
	sql = "SELECT ChineseName FROM MIR WHERE (((MIR.Active)=Yes)) ORDER BY ChineseName"
	set RS = Server.CreateObject("ADODB.RecordSet")
	RS.Open SQL, Conn, 1, 1, 1

	ReDim x(RS.RecordCount-1)
	For i = 0 to Ubound(x)
		x(i) = RS("ChineseName")
		RS.MoveNext
	Next
	RS.Close
	Conn.Close
	getMirStudentName = x
End Function %>

<% Function checkMirPassword(person, password)
	Dim Conn, RS, SQL	'Local variables!
	Set Conn = Server.CreateObject("ADODB.Connection")
	' memberDb is defined in constant.inc
	Conn.Open "DBQ=" & Server.MapPath(memberDb) & ";Driver={Microsoft Access Driver (*.mdb)};Driverld=25;FIL=MS Access;"
	SQL = "select * from MIR where (active=yes and ChineseName='" & person & "' and Birthday='" & password & "')"
rem	SQL = "SELECT * FROM MIR WHERE (((MIR.Active)=Yes) AND ((MIR.ChineseName)='郭智超') AND ((MIR.Birthday)='19781218'))"
rem	Response.Write SQL
	Set RS = Conn.Execute(SQL)
	checkMirPassword = Not RS.Eof
	RS.Close
	Conn.Close
End Function
%>

<% Function PrintField(RS, field, editable)
'Assume that RS.Eof is false
	Response.Write "<ol>"
	For i=0 to 4
		If editable=0 Then
			If trim(RS(field & i))<>"" Then
				Response.Write "<li>" & RS(field & i) 
			End If
		Else
			Response.Write "<li><textarea name="
			Response.Write field & i
			Response.Write " cols=30 rows=2 wrap=virtual>"
			Response.Write RS(field & i) 
			Response.Write "</textarea>"
		End If
	Next
	Response.Write "</ol>"
End Function %>

<% Function PrintDateTask(RS, dateField, taskField)
'Assume that RS.Eof is false
	Response.Write "<ol>"
	For i=0 to 4
		If trim(RS(taskField & i))<>"" Then
			Response.Write "<li>【<font color=red>" & RS(dateField & i) & "</font>】" & RS(taskField & i) 
		End If
	Next
	Response.Write "</ol>"
End Function %>

<% Sub PrintSession(dateField, taskField)
	Response.Write "<ol>"
	For i=0 to 4
'		If trim(session(taskField & i))<>"" Then
			Response.Write "<li>【<font color=red>" & session(dateField & i) & "</font>】" & session(taskField & i) 
'		End If
	Next
	Response.Write "</ol>"
End Sub %>