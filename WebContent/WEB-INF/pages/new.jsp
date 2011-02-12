<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>書庫管理システム ＜蒼のインプルス＞　蔵書詳細情報　新規作成</title>
		<script language="JavaScript" src="js/barcode.js" >
		</script>

		<script language="JavaScript">
		
		/**
		 * バーコード入力を整形します
		 */
		function onGuessCaseBarcode(barcodeElement){
			var currentValue = barcodeElement.value;
			currentValue = currentValue.replace(/[- 　]/g,"");
			barcodeElement.value = currentValue;
		}

		function onGuessCaseText(textfieldElement){
			var currentValue = textfieldElement.value;
			currentValue = currentValue.replace("　"," ");
			currentValue = currentValue.replace("（","(");
			currentValue = currentValue.replace("）",")");
			currentValue = currentValue.replace(/(^\s+)|(\s+$)/g, "");
			textfieldElement.value = currentValue;
		}
		
		var myEditForm;

		/**
		 * バーコードスキャンボタンをクリック
		 */
		function onClickScanBarcodeButton(myForm,jsonUrl){
			myEditForm = myForm;
			if(!onScanBarcode(myForm.new_newBook_barcode.value)){
				alert('バーコードが正しくありません'); 
				return false;
			}
			// Webから抽出させます... //
			jsonUrl += "?barcode="+myForm.new_newBook_barcode.value;
			callJson(jsonUrl);
			
			
			
		}

		/**
		 * バーコードのJOSON結果を処理します
		 */
		function populateJSON(result){
			// jsonの結果を格納します
			var jsonResultObject = eval('('+result+')');
			myEditForm.new_newBook_title.value=jsonResultObject.jsonBook.title;
			myEditForm.new_newBook_authorName.value=jsonResultObject.jsonBook.authorName;
			myEditForm.new_newBook_publishCompanyName.value=jsonResultObject.jsonBook.publishCompanyName;
			myEditForm.new_newBook_releaseDate.value=jsonResultObject.jsonBook.releaseDate;
		}
		
		/**
		 * HTTPリクエスト
		 */
		var httpRequest;

		function callJson(url){
			if(window.XMLHttpRequest){
				httpRequest = new XMLHttpRequest();
			}
			else if ( window.ActiveXObject ){
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			httpRequest.open("GET", url, true);
			httpRequest.onreadystatechange = callback;
			httpRequest.send(null);
		}

		function callback(){
			if(httpRequest.readyState==4){
				if(httpRequest.status==200){
					populateJSON(httpRequest.responseText);
				}
			}
		}

		function onkeyDownBarcode(form,event) {
			pressKey=event.keyCode;

			if(pressKey==13){
				form.btnScan.onclick(); 
				return false;
			} 
		}
		
		</script>
	</head>
	<body>
		<h1>書庫管理システム ＜蒼のインプルス＞　</h1>
		新規作成<br />
		シナリオメモ<br />
		<P>
		 このページでは、以下の機能を有しています。
		 <ol>
		 	<li>蔵書情報を新規作成します</li>
		 	<li>蔵書一覧に遷移する機能を有します</li>
		 </ol>
		</P>
		<s:form theme="simple" method="POST">
		<h3>基本情報</h3>
		<table border="1" >
			<tr>
				<th>管理番号</th>
				<td><s:property value="currentId"/><s:hidden key="currentId"/></td>
			</tr>
			<tr>
				<th>タイトル</th>
				<td>
					<s:textfield key="newBook.title"/>
					<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_title);" />
				</td>
			</tr>
			<tr>
				<th>読みKANA(英字表記)</th>
				<td>
					<s:textfield key="newBook.titleKana"/>
					<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_titleKana);" />
				</td>
			</tr>
			<tr>
				<th>通巻表記</th>
				<td>
					<s:textfield key="newBook.numberValue"/>
					<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_numberValue);" />
				</td>
			</tr>
			<tr>
				<th>並び順番号(数値)</th>
				<td>
					<s:textfield key="newBook.number"/>
					<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_number);" />
				</td>
			</tr>
			<tr>
				<th>サブタイトル</th>
				<td>
					<s:textfield key="newBook.subtitle"/>
					<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_subtitle);" />
				</td>
			</tr>
			<tr>
				<th>著者</th>
				<td>
					<s:textfield key="newBook.authorName"/>
					<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_authorName);" />
				</td>
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
					<th>出版シリーズ</th>
					<th>出版年月</th>
					<th>出版社管理番号</th>
					<th>バーコード</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1</th>
					<td><s:textfield key="newBook.publishCompanyName"/>
						<input type="button" value="Guess case" onclick="onGuessCaseText(this.form.new_newBook_publishCompanyName);" />
					</td>
					<td><s:textfield key="newBook.publishSeriesName"/></td>
					<td><s:textfield key="newBook.releaseDate"/></td>
					<td> </td>
					<td><s:url var="urlBarcodeJson" action="scanBarcode" />
						<s:textfield key="newBook.barcode" onkeydown="return onkeyDownBarcode(this.form,event);" />
						<input type="button" value="Guess case" onclick="onGuessCaseBarcode(this.form.new_newBook_barcode);" />
					    <input name="btnScan" type="button" value="スキャン" onclick="onClickScanBarcodeButton(this.form,'<s:property value="%{urlBarcodeJson}" />')" /> 
					</td>
				</tr>
			</tbody>
		</table>
		<s:submit value="登録" />
		</s:form>
		<a href="list.action" onclick="history.back();return false;">戻る</a>
	</body>
</html>