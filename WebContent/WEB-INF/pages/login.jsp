<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<div style="float:left;">
既に登録されている方
<s:form theme="simple">
<table>
 <tr>
  <th>ユーザ名:</th>
  <td><s:textfield name="user.emailAddress" value="%{user.emailAddress}"/></td>
 </tr>
 <tr>
  <th>パスワード:</th>
  <td><s:password name="user.password"/></td>
 </tr>
 <tr>
  <td colspan=2 align="right" ><s:submit value="ログイン"/></td>
 </tr>
</table>
</s:form>
パスワードを忘れた方<br>
<input type=button value="メールする"/>
</div>
<div style="width:50%; float:right; border-left:solid 1px black;">
新規登録<br>
<input type=button value="今すぐ登録する"/><br>
<input type=button value="ゲストとしてログインする"/><br>
<br>
<input type=button value="ヘルプの表示"/>

</div>
</body>
</html>