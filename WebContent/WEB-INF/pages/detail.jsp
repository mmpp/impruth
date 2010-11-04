<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>書庫管理システム ＜蒼のインプルス＞　蔵書詳細情報　<s:property  value="detailBook.title"/></title>
	</head>
	<body>
		<h1>書庫管理システム ＜蒼のインプルス＞　</h1>
		蔵書詳細<br />
		シナリオメモ<br />
		<P>
		 このページでは、以下の機能を有しています。
		 <ol>
		 	<li>蔵書情報の詳細情報を表示します</li>
		 	<li>蔵書一覧に遷移する機能を有します</li>
		 	<li>蔵書情報の編集機能に遷移することを考えます</li>
		 </ol>
		</P>
		<h3>基本情報</h3>
		<table border="1" >
			<tr>
				<th>タイトル</th>
				<td><s:property value="detailBook.title"/></td>
			</tr>
			<tr>
				<th>読みKANA(英字表記)</th>
				<td><s:property value="detailBook.titleKana"/></td>
			</tr>
			<tr>
				<th>通巻表記</th>
				<td><s:property value="detailBook.numberValue"/></td>
			</tr>
			<tr>
				<th>並び順番号(数値)</th>
				<td><s:property value="detailBook.number"/></td>
			</tr>
			<tr>
				<th>著者</th>
				<td><s:property value="detailBook.authorName"/></td>
			</tr>
		</table>
		<h3>書籍詳細情報</h3>
		<table border="1" >
			<tr>
				<th>書籍サイズ[mm]</th>
				<td>172 x 114</td>
			</tr>
			<tr>
				<th>ページ数</th>
				<td>208</td>
			</tr>
			<tr>
				<th>書籍厚さ[mm]</th>
				<td>200</td>
			</tr>
		</table>
		<h3>出版情報</h3>
		<table border="1" >
			<thead>
				<tr>
					<th>No</th>
					<th>出版社</th>
					<th>出版年月</th>
					<th>出版社管理番号</th>
					<th>バーコード</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1</th>
					<td><s:property value="detailBook.publishCompanyName"/></td>
					<td>1997/12/24</td>
					<td> </td>
					<td>9784088725093</td>
				</tr>
			</tbody>
		</table>
		<s:form theme="simple" >
			<s:hidden key="id" value="%{detailBook.id}" />
		<table>
			<tr>
				<td>
					<input type="button" value="編集" onclick="alert('この情報を編集する予定です');"/>
				</td>
				<td>
					<s:submit action="delete" value="削除" onclick="return confirm('この情報を削除しても良いですか？');"/>
				</td>
			</tr>
			</table>
			</s:form>
		<s:url id="list" action="list" />
		<s:a href="%{list}">戻る</s:a>
	</body>
</html>