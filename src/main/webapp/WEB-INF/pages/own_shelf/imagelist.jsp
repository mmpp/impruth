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
 <s:submit method="onClickPrePage" value="<< 戻る" disabled="%{pageNumber<=1}" /> <s:submit method="onClickNextPage" value="次へ >> " disabled="%{pageNumber>=pageMaxNumber}" /></s:form>

 <table  style="width:0px;">
				<tr>
				<s:iterator status="list" value="ownBooks" id="ownBooks" >

					<td style="vertical-align:bottom;width:110px;"><div style="width:108px;"><img style="width:108px;" src='<s:property value="imageUrl"/>'　/> </div>
					<table style="font-size: 0.5em;border-bottom:1px solid black;">
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
				<s:if test="%{#list.index%DEFAULT_LINE_BOOK_COUNT == DEFAULT_LINE_BOOK_COUNT-1}">
				</tr>
				<tr>
				</s:if>
								</s:iterator>
				</tr>
		</table>
</body>
</html>