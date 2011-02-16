<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有書籍情報</title>
</head>
<body>
所有書籍情報 : <s:property value="user.firstName" /><Br>
<s:form theme="simple">
<s:submit method="onClickAddOwnBook" value="+ 新規追加" />
<s:submit method="onClickChangeImageList" value="□ 画像一覧" />
</s:form>
		<table border="1">
			<thead>
				<tr>
					<!--
					<th>書籍イメージ(テスト)</th>
					-->
					<th>バーコード</th>
					<th>タイトル</th>
					<th>著者</th>
					<th>出版社</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator status="list" value="ownBooks" id="ownBooks" >

				<tr>
					<td><s:property value="barcode"/></td>
					<td><s:property value="title"/></td>
					<td><s:property value="author"/></td>
					<td><s:property value="publisher"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
</body>
</html>