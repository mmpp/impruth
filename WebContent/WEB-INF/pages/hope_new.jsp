<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex,nofollow" />
 
<title>書庫管理システム ＜蒼のインプルス＞</title>
</head>
<body>
<h1>書庫管理システム ＜蒼のインプルス＞</h1>
ユーザ : ユーザ名<br />
<s:form theme="simple">
<s:submit action="shelf" value="所有書籍情報" /> :
<s:submit method="onClickMeneHope" value="欲しい本リスト(仮)" /> <br />
</s:form>
欲しい本追加 <br />
<div style="display: none" >
書籍名 : シリーズ (巻数) シリーズサブ名<br />
</div>
<div style="display: none" >
希望レベル
	<table border="1">
		<tr><th>S</th><td>新品必須</td></tr>
		<tr><th>A</th><td>新品もしくはきれいな古本</td></tr>
		<tr><th>B</th><td>古本でも良い</td></tr>
		<tr><th>C</th><td>古本が良い</td></tr>
		<tr><th>D</th><td>古本で十分(\100)</td></tr>
		<tr><th>E</th><td>読めればOK借りてでも</td></tr>
	</table>
</div>
	<s:form theme="simple">
	<table border="1">
		<tr>
			<th colspan="2">書籍情報</th>
		</tr>
			
		<tr>
			<!-- 書籍情報 -->
			<th>書籍名</th>
			<td><s:textfield value="title"/></td>
		</tr>
		<tr>
			<th>著者</th>
			<td><s:textfield value="authorName"/></td>
		</tr>
		<tr>
			<th>出版社</th>
			<td><s:textfield value="publisherName"/></td>
		</tr>
		<tr>
			<th>書籍種別</th>
			<td><s:textfield value="bookKind"/></td>
		</tr>
		<tr>
			<th>発売日</th>
			<td><s:textfield value="releaseDate"/></td>
		</tr>

		<tr>
			<th colspan="2">ユーザ情報</th>
		</tr>
		<tr>
			<!-- ユーザ情報 -->
			<th>登録日</th>
			<td><s:textfield value="updateDate"/></td>
		</tr>
		<tr>
			<th>希望レベル(S,A,B,C,D,E)</th>
			<td><s:textfield value="level"/></td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="button" value="更新" />
				<input type="reset" value="キャンセル" />
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>