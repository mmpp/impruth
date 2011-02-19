<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>所有書籍情報</title>
		<script language="JavaScript" src="js/barcode.js" >
		</script>
		<script language="JavaScript">

		var myEditForm;

		/**
		 * バーコードスキャンボタンをクリック
		 */
		function onClickScanBarcodeButton(myForm,jsonUrl){
			myEditForm = myForm;
		    var barcode = myForm.ownList_ownBook_barcode.value;
			if(!onScanBarcode(barcode)){
				alert('バーコードが正しくありません'); 
				return false;
			}
			// Webから抽出させます... //
			jsonUrl += "?barcode="+barcode;
			myEditForm.scan.disabled=true;
			callJson(jsonUrl);
			
			
			
		}

		/**
		 * バーコードのJOSON結果を処理します
		 */
		function populateJSON(result){
			// jsonの結果を格納します
			var jsonResultObject = eval('('+result+')');
			myEditForm.title.value=jsonResultObject.jsonBook.title;
			myEditForm.author.value=jsonResultObject.jsonBook.authorName;
			myEditForm.publisher.value=jsonResultObject.jsonBook.publishCompanyName;
			// myEditForm.new_newBook_releaseDate.value=jsonResultObject.jsonBook.releaseDate;
			if(jsonResultObject.jsonBook.imageUrl !=null )
				if(jsonResultObject.jsonBook.imageUrl.length>0){
				myEditForm.imageUrl.value=jsonResultObject.jsonBook.imageUrl;
				// 画像を表示する
				refreshImage(myEditForm.imageUrl.value);
			}
			
			// ボタンを戻す
			myEditForm.scan.disabled=false;
			// 登録ボタンを戻す
			myEditForm.regist.disabled=false;
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
		/**
		 * バーコード入力欄のキープレス処理
		 */
		function onkeyDownBarcode(form,event) {
			pressKey=event.keyCode;

			// 改行処理
			if(pressKey==13){
				form.scan.onclick(); 
				return false;
			} 
		}
		</script>
		<script language="JavaScript">
			function refreshImage(url){
				// 現在の表示をクリア
				var imageForm = document.getElementById("imageForm");
				imageForm.innserHTML = "";
				var img = document.createElement("img");
				img.src = url;
				imageForm.appendChild(img);
			}
			
		</script>
	</head>
	<body >
所有書籍情報 : <s:property value="user.firstName" /><Br>
<s:form theme="simple">
<s:submit method="onClickAddOwnBook" value="+ 新規追加"  disabled="disabled"/>
<s:submit method="onClickChangeList" value="□ 表一覧" />
</s:form>
<s:form theme="simple">
		<table border="1">
			<thead>
				<tr>
					<th>バーコード</th>
					<th>タイトル</th>
					<th>著者</th>
					<th>出版社</th>
					<th>イメージ</th>
				</tr>
			</thead>
			<tbody>
				<tr><s:url var="urlBarcodeJson" action="scanBarcode" />
					<td><s:textfield name="ownBook.barcode" onkeydown="return onkeyDownBarcode(this.form,event);" size="13" /><input name="scan" type="button" value="スキャン"  onclick="onClickScanBarcodeButton(this.form,'<s:property value="%{urlBarcodeJson}" />')"/></td>
					<td><input name="title" disabled="disabled"/></td>
					<td><input name="author" disabled="disabled"/></td>
					<td><input name="publisher" disabled="disabled"/></td>
	
					<td><input name="imageUrl" disabled="disabled" /><span id="imageForm"></span></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<s:submit value="新規登録" method="onClickRegist" disabled="true" id="regist" />
					</td>
				</tr>
			</tfoot>
		</table>
</s:form>
</body>
</html>