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
<s:submit method="onClickChangeImageList" value="□ 画像一覧" disabled="%{showType.toString()=='IMAGE'}"/>
<s:submit method="onClickChangeList" value="■ 表一覧" disabled="%{showType.toString()=='LIST'}"/> <br>
<s:property value="totalBookCount" /> 件中 <s:property value="%{(pageNumber-1)*pageCount+1}" /> 〜 <s:property value="%{pageNumber*pageCount}" />件表示。
(最大 <s:property value="pageMaxNumber" />ページ)<br />
<s:hidden  name="showType" />
<s:hidden  name="pageNumber" />
 <s:submit method="onClickPrePage" value=" 戻る" disabled="%{pageNumber <= 1}" /> <s:submit method="onClickNextPage" value="次へ " disabled="%{pageNumber >= pageMaxNumber}" /></s:form>

		<table border="1" width="1200">
			<thead>
				<tr style='background-color:#CCCCCC;' >
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
				<s:url id="urlList" action="index" ><s:param name="isbn" value="{barcode}" /></s:url>
				<tr style='background-color:<s:property value="%{#list.index % 2 ==0 ?'#FFFFFF':'#EEEEEE'}" />; ' >
					<td><s:property value="barcode"/></td>
					<td><s:a href="%{urlList}"><s:property value="title"/></s:a></td>
					<td><s:property value="author"/></td>
					<td><s:property value="publisher"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
</body>
</html>