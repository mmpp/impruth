<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>書庫管理システム ＜蒼のインプルス＞　蔵書詳細情報　<s:property  value="detail.title"/></title>
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<link rel="stylesheet" type="text/css" href="css/indexCard.css" />
	</head>
	<body>
		<h1>書庫管理システム ＜蒼のインプルス＞　</h1>
		蔵書詳細<br />
		<table border="1" class="indexCard" >
			<tr class="title">
				<th>タイトル</th>
				<td><s:property value="detail.title"/></td>
			</tr>
			<tr >
				<th>著者</th>
				<td><s:property value="detail.author"/></td>
			</tr>
			<tr>
				<th>ISBN</th>
				<td><s:property value="detail.barcode"/></td>
			</tr>
			<tr>
			</tr>
		</table>
		<div>
		表紙<br>
		<img src='<s:property value="detail.imageUrl"/>' />
		</div>
		<s:a href="javascript:history.back();" >戻る</s:a>
	</body>
</html>