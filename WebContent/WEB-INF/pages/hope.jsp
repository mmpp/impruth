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
<s:submit method="onClickMeneShelfList" value="所有書籍情報" /> :
<input type="button" method="onClickMeneHope" value="欲しい本リスト(仮)" /> <br />
<s:submit method="onClickMeneHopeAdd" value="欲しい本追加" /><br />
</s:form>
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
				<th>希望レベル(S,A,B,C,D,E)</th>

				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="hopeBooks" status="stat">
			<tr>
				<th><s:property value="%{#stat.index+1}" /></th>
				<td><s:property value="title"/></td>
				<td><s:property value="authorName"/></td>
				<td><s:property value="publisherName"/></td>
				<td><s:property value="bookKind"/></td>
				<td><s:property value="releaseDate"/></td>
				
				<td><s:property value="updateDate"/></td>
				<td><s:property value="level"/></td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			</s:iterator>
			<tr>
				<th>3</th>
				<td>護くんに女神の祝福を！ (13-) </td>
				<td>岩田 洋季</td>
				<td>アスキーメディアワークス 電撃文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>D</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>4</th>
				<td>灼眼のシャナ (6-9,11,13,15,17-) </td>
				<td>高橋 弥七郎</td>
				<td>アスキーメディアワークス 電撃文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>D</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>5</th>
				<td>彩雲国物語 (12-) </td>
				<td>雪乃 紗衣</td>
				<td>角川文庫 ビーンズ文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>C</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>7</th>
				<td>R.O.D (12-) </td>
				<td>倉田 英之</td>
				<td>角川文庫 スーパーダッシュ文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>C</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>8</th>
				<td>キノの旅 (4,5,9-) </td>
				<td>時雨沢 恵一</td>
				<td>アスキーメディアワークス 電撃文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>D</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>9</th>
				<td>しにがみのバラッド。 (3-) </td>
				<td>ハセガワ ケイスケ</td>
				<td>アスキーメディアワークス 電撃文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>D</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>10</th>
				<td>涼宮ハルヒの憂鬱 (3-) </td>
				<td>谷川 流</td>
				<td>角川書店 角川スニーカー文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>D</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			<tr>
				<th>11</th>
				<td>半分の月がのぼる空 (3-) </td>
				<td>橋本 紡</td>
				<td>アスキーメディアワークス 電撃文庫</td>
				<td>文庫</td>
				<td>---</td>
				<td>2010/12/09</td>
				<td>D</td>
				<td nowrap >
					<input type=button value="購入" />
					<input type=button value="発見" />
					<input type=button value="連絡" />
					<input type=button value="取下" />
				</td>
			</tr>
			
		</tbody>
	</table>
</body>
</html>