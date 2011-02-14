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
<s:submit method="onClickAddOwnBook" value="+ 新規追加"  disabled="disabled"/>
<s:submit method="onClickAddOwnBook" value="= 一覧"  disabled="disabled"/>
</s:form>
<s:form theme="simple">
		<table border="1">
			<thead>
				<tr>
					<th>バーコード</th>
					<th>タイトル</th>
					<th>著者</th>
					<th>出版社</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:textfield name="ownBook.barcode"/></td>
					<td><input value="title" disabled="disabled"/></td>
					<td><input value="author" disabled="disabled"/></td>
					<td><input value="publisher" disabled="disabled"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<s:submit value="新規登録" method="onClickRegist"/>
					</td>
				</tr>
			</tfoot>
		</table>
</s:form>
</body>
</html>