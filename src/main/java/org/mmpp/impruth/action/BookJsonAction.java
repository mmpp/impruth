package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.BookJson;

import com.opensymphony.xwork2.ActionSupport;

public class BookJsonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 表示ページ番号
	 */
	private int _pageNo = 1;
	/**
	 * ページ表示件数
	 */
	private int _pageView;
	/**
	 * 表示ページ番号を取得します
	 * @return 表示ページ番号
	 */
	public int getPageNo(){
		return _pageNo;
	}
	/**
	 * ページ表示件数を格納します
	 * @param pageView ページ表示件数
	 */
	public void setPageView(int pageView){
		_pageView = pageView;
	}
	/**
	 * ページ表示件数を取得します
	 * @return ページ表示件数
	 */
	public int getPageView(){
		return _pageView;
	}
	/**
	 * 表示ページ番号を格納します
	 * @param pageNo 表示ページ番号
	 */
	public void setPageNo(int pageNo){
		_pageNo = pageNo;
	}
	/**
	 * 蓄積書籍数を取得します
	 * @return 蓄積書籍数 
	 */
	public int getTotalCount(){
		return 100;
	}
	public java.util.List<BookJson> getResults(){
		java.util.List<BookJson> results = new java.util.LinkedList<BookJson>();
		
		results.add(new BookJson("GOSICKVIII下‐ゴシック・神々の黄昏‐","桜庭一樹","540"));
		results.add(new BookJson("急行アルプス殺人事件","西村京太郎","620"));
		results.add(new BookJson("相田みつを ザ・ベスト 一生感動一生青春","相田みつを","540"));
		results.add(new BookJson("初恋ソムリエ","初野晴","540"));
		results.add(new BookJson("「おじさん」的思考","内田樹","580"));
		results.add(new BookJson("文庫版 妖怪の理 妖怪の檻","京極夏彦","860"));
		results.add(new BookJson("玉ねぎフライパン作戦","椎名誠","620"));
		results.add(new BookJson("暗殺者メギド","渡辺裕之","620"));
		results.add(new BookJson("早春物語 赤川次郎ベストセレクション(17)","赤川次郎","500"));
		results.add(new BookJson("怖い絵 泣く女篇","中野京子","700"));
		results.add(new BookJson("スタンレー・ホークの事件簿I 仮面‐‐ペルソナ","山藍紫姫子　イ：本仁戻","580"));
		results.add(new BookJson("スノーフレーク","大崎梢　イ：中島梨絵","540"));
		results.add(new BookJson("ボクら星屑のダンス","佐倉淳一","780"));
		results.add(new BookJson("左近の桜","長野まゆみ　デ：角川書店装丁室西村弘美","580"));
		results.add(new BookJson("瑠璃の雫","伊岡瞬","820"));
		results.add(new BookJson("なんでもありか 静と理恵子の血みどろ絵日誌","伊集院静　著：西原理恵子　イ：西原理恵子","780"));
		results.add(new BookJson("はなたちばな亭恋空事","澤見彰","580"));
		results.add(new BookJson("美しき武士と騎士の寝室","桐生操","580"));
		results.add(new BookJson("魔界転生 下 山田風太郎ベストコレクション","山田風太郎","780"));
		results.add(new BookJson("魔界転生 上 山田風太郎ベストコレクション","山田風太郎","780"));
		results.add(new BookJson("荒俣宏の裏・世界遺産(3) 衛生博覧会を求めて","荒俣宏","860"));
		results.add(new BookJson("風のささやき 介護する人への13の話","姫野カオルコ","580"));
		results.add(new BookJson("ウェルカム トゥ パールハーバー(上)","西木正明","1100"));
		results.add(new BookJson("ウェルカム トゥ パールハーバー(下)","西木正明","1100"));
		results.add(new BookJson("別冊図書館戦争I 図書館戦争シリーズ(5)","有川浩　イ：徒花スクモ","660"));
		results.add(new BookJson("図書館革命 図書館戦争シリーズ4","有川浩　イ：徒花スクモ","700"));
		results.add(new BookJson("図書館危機 図書館戦争シリーズ3","有川浩　イ：徒花スクモ","700"));
		results.add(new BookJson("源氏物語 千年の謎","高山由紀子","660"));


		return results;
	}

}
