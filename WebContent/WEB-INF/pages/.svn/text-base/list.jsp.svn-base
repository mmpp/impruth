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
			蔵書一覧<br />
			シナリオメモ<br />
			<P>
			 このページでは、以下の機能を有しています。
			 <ul>
			 	<li>蔵書情報の一覧を表示します</li>
			 	<li>蔵書情報の一覧のページング機能を有します</li>
			 	<li>蔵書を選択し、詳細情報表示画面へ遷移します</li>
			 </ul>
			</P>
		<a href="new.action">新規作成</a>
			
		<table border="1">
			<thead>
				<tr>
					<th>No</th>
					<th>タイトル</th>
					<th>通巻数</th>
					<th>著者</th>
					<th>出版社</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator status="list" value="books" >
				 <s:url var="detailUrl" action="detail">
				 	<s:param name="id" value="id" />
				 </s:url> 
				<tr>
					<th><s:property value="%{#list.index+1}"/></th>
					<td><s:a href="%{detailUrl}" ><s:property value="title"/></s:a></td>
					<td><s:property value="number"/></td>
					<td><s:property value="authorName"/></td>
					<td><s:property value="publishCompanyName"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	</body>
</html>