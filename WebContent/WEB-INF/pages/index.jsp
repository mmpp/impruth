<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>書庫管理システム ＜蒼のインプルス＞　蔵書一覧</title>
	</head>
	<body>
		<h1>書庫管理システム ＜蒼のインプルス＞　</h1>
			書籍一覧<br />
		<table border="1">
			<thead>
				<tr>
					<th>No</th>
					<th>タイトル</th>
					<th>著者</th>
					<th>バーコード</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator status="list" value="list" >
				<tr>
					<s:url id="urlList" action="index" ><s:param name="isbn" value="{barcode}" /></s:url>
					<th><s:property value="%{#list.index+1}"/></th>
					<td><s:a href="%{urlList}"><s:property value="title"/></s:a></td>
					<td><s:property value="author"/></td>
					<td><s:property value="barcode"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	</body>
</html>