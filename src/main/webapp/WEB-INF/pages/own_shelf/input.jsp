<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>所有書籍情報</title>
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<link rel="stylesheet" type="text/css" href="css/indexCard.css" />
		
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
			// ボタン等の表示処理
			enabledScanButton(false);
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
			// ボタン等の表示処理
			enabledScanButton(true);
		}
		function populateError(responseCode){
			alert('例外が発生しましたので管理者にご連絡下さい。 responseCode:'+ responseCode);
			// ボタン等の表示処理
			enabledScanButton(true);
			// 登録は出来ない
			myEditForm.regist.disabled=true;

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
				}else{
					// 正常終了以外
					populateError(httpRequest.status);
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
		function enabledScanButton(flag){
			var scanWaitAnimation = document.getElementById("scanWaitingImg");
			if(flag){
				// 有効化
					
				// ボタンを戻す
				myEditForm.scan.disabled=false;
	
				// 登録ボタンを戻す
				myEditForm.regist.disabled=false;

				scanWaitAnimation.style.display="none";
				return ;
			}
			// 無効化
			myEditForm.scan.disabled=true;
			// 登録ボタンを戻す
			myEditForm.regist.disabled=true;

			// 待ち時間中のイメージ表示 //
			scanWaitAnimation.style.display="";

		}
		</script>
		<script language="JavaScript">
			function refreshImage(url){
				// 現在の表示をクリア
				var imageForm = document.getElementById("imageForm");
				// 内容をクリアする
				imageForm.innerHTML = "";
				var img = document.createElement("img");
				img.src = url;
				imageForm.appendChild(img);
			}
			
		</script>
	</head>
	<body >
	<h1>書庫管理システム ＜蒼のインプルス＞</h1>
所有書籍情報 : <s:property value="user.firstName" /><Br>
<s:form theme="simple">
<s:submit method="onClickAddOwnBook" value="+ 新規追加"  disabled="disabled"/>
<s:submit method="onClickChangeImageList" value="□ 画像一覧" disabled="%{showType.toString()=='IMAGE'}"/>
<s:submit method="onClickChangeList" value="□ 表一覧" />
</s:form>
<s:form theme="simple">
		<table border="1" class="indexCard">
			<thead>
				<tr>
					<th>バーコード</th>
						<s:url var="urlBarcodeJson" action="scanBarcode" />
					<td>
					<span>
						<s:textfield name="ownBook.barcode" onkeydown="return onkeyDownBarcode(this.form,event);" size="13" maxlength="13" />
						<input name="scan" type="button" value="スキャン"  onclick="onClickScanBarcodeButton(this.form,'<s:property value="%{urlBarcodeJson}" />')"/>
						<img id="scanWaitingImg" src="img/wait.gif" style="display:none;"/>
						</span><span>
						</span>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>タイトル</th>
					<td><input name="title" disabled="disabled" size=64/></td>
				</tr>
				<tr>
					<th>タイトル(Kana)</th>
					<td><input name="titleKana" disabled="disabled" size=64/></td>
				</tr>
				<tr>
					<th>シリーズ通巻</th>
					<td><input name="seriesNumber" disabled="disabled" size=64/></td>
				</tr>				<tr>
					<th>著者</th>
					<td><input name="author" disabled="disabled" size="64"/></td>
				</tr>
				<tr>
					<th>出版社</th>
					<td><input name="publisher" disabled="disabled" size="64"/></td>
				</tr>
				<tr>
					<th>出版管理番号</th>
					<td><input name="publisherNo" disabled="disabled" size=64/></td>
				</tr>
				<tr>
					<th>イメージ</th>	
					<td><input name="imageUrl" disabled="disabled"  size="64"/><br/><span id="imageForm"></span></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:submit value="新規登録" method="onClickRegist" disabled="true" id="regist" />
					</td>
				</tr>
			</tfoot>
		</table>
</s:form>
</body>
</html>