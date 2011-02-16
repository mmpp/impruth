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
<s:submit method="onClickChangeList" value="□ 表一覧" />
</s:form>
		<table border="1">
				<tr>
				<s:iterator status="list" value="ownBooks" id="ownBooks" >

					<td style="vertical-align:bottom"><img src='<s:property value="imageUrl"/>'>
					<table style="font-size: 0.5em;">
						<tr>
							<th>ISBN</th>
							<td><s:property value="barcode"/></td>
						</tr>
						<tr>
							<th nowrap>タイトル</th>
							<td><s:property value="title"/></td>
						</tr>
						<tr>
							<th>著者</th>
							<td><s:property value="author"/></td>
						</tr>
						<tr>
							<th nowrap>出版社</th>
							<td><s:property value="publisher"/></td>
						</tr>
					</table>
					</td>
				<s:if test="#list.index%10 == 9">
				</tr>
				<tr>
				</s:if>
								</s:iterator>
				</tr>
		</table>
</body>
</html>