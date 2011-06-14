<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex,nofollow" />
 
<title>書庫管理システム ＜蒼のインプルス＞</title>

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
			myEditForm.shelf_shelfBook_title.value=jsonResultObject.jsonBook.title;
			myEditForm.shelf_shelfBook_authorName.value=jsonResultObject.jsonBook.authorName;
			myEditForm.shelf_shelfBook_publishCompanyName.value=jsonResultObject.jsonBook.publishCompanyName;
			myEditForm.shelf_shelfBook_releaseDate.value=jsonResultObject.jsonBook.releaseDate;
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
<h1>書庫管理システム ＜蒼のインプルス＞</h1>
ユーザ : ユーザ名<br />
<s:form theme="simple">
<input type="button" method="onClickMeneShelfList" value="所有書籍情報" /> :
<s:submit type="button" method="onClickMeneHope" value="欲しい本リスト(仮)" /> <br />
<s:if test="shelfBook==null">
<s:submit method="onClickMeneAdd" theme="simple" value="新規追加" /><br />
</s:if><s:else>
	<table border="1">
		<tr>
			<th colspan="2">書籍情報</th>
		</tr>
			
		<tr>
			<!-- 書籍情報 -->
			<th>書籍名</th>
			<td><s:textfield name="shelfBook.title" /></td>
		</tr>
		<tr>
			<th>著者</th>
			<td><s:textfield name="shelfBook.authorName"/></td>
		</tr>
		<tr>
			<th>出版社</th>
			<td><s:textfield name="shelfBook.publisherName"/></td>
		</tr>
		<tr>
			<th>書籍種別</th>
			<td><s:textfield name="shelfBook.bookKind"/></td>
		</tr>
		<tr>
			<th>発売日</th>
			<td><s:textfield name="shelfBook.releaseDate"/></td>
		</tr>
		<tr>
			<th>バーコード</th>
			<td>
				<s:textfield name="shelfBook.barcode" onkeydown="return onkeyDownBarcode(this.form,event);" />			
				<input name="btnScan" type="button" value="スキャン" onclick="onClickScanBarcodeButton(this.form,'<s:property value="%{urlBarcodeJson}" />')" /> 
			</td>
		</tr>

		<tr>
			<th colspan="2">ユーザ情報</th>
		</tr>
		<tr>
			<!-- ユーザ情報 -->
			<th>登録日</th>
			<td><s:textfield name="shelfBook.updateDate"/></td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="button" value="更新" />
				<s:reset method="onClickReset" value="キャンセル" />
			</td>
		</tr>
	</table>
</s:else>
</s:form>
<div style="display: none" >
書籍名 : シリーズ (巻数) シリーズサブ名<br />
</div>
	<table border="1">
		<thead>
			<tr>
				<th rowspan="2">No</th>
				<th colspan="5">書籍情報</th>
				<th colspan="2">ユーザ情報</th>
				<th rowspan="2" nowrap >操作</th>
			</tr>
			<tr>
				<!-- 書籍情報 -->
				<th>書籍名</th>
				<th>著者</th>
				<th>出版社</th>
				<th>書籍種別</th>
				<th>発売日</th>
				<!-- ユーザ情報 -->
				<th>登録日</th>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="shelfBooks" status="stat">
			<tr>
				<th><s:property value="%{#stat.index+1}" /></th>
				<td><s:property value="title"/></td>
				<td><s:property value="authorName"/></td>
				<td><s:property value="publisherName"/></td>
				<td><s:property value="bookKind"/></td>
				<td><s:property value="releaseDate"/></td>
				
				<td><s:property value="updateDate"/></td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			</s:iterator>
	
		</tbody>
	</table>
</body>
</html>