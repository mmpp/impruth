package org.mmpp.impruth.action;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mmpp.impruth.service.BookService;
import org.mmpp.impruth.service.model.Book;

/**
 * 書籍情報をJSON形式で取得するページアクション試験
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookJsonActionTest {

	@Test
	public void testGetPageNo() {
		BookJsonAction action = new BookJsonAction();
		assertEquals(1, action.getPageNo());
	}

	@Test
	public void testGetPageView() {
		BookJsonAction action = new BookJsonAction();
		assertEquals(28, action.getPageView());
	}
	
	@Test
	public void testSetPageView() throws Exception {
		BookJsonAction action = new BookJsonAction();
		action.setBookService(new BookServiceStub());
		action.setPageView(8);
		action.execute();
		assertEquals(8, action.getPageView());
	}


	@Test
	public void testSetPageNo()  throws Exception {
		BookJsonAction action = new BookJsonAction();
		action.setBookService(new BookServiceStub());
		action.setPageNo(2);
		action.execute();
		assertEquals(2, action.getPageNo());
	}

	@Test
	public void testGetTotalCount() throws Exception {
		BookJsonAction action = new BookJsonAction();
		action.setBookService(new BookServiceStub());
		action.execute();
		assertEquals(28, action.getTotalCount());

	}

	@Test
	public void testGetResults() throws Exception {
		BookJsonAction action = new BookJsonAction();
		action.setBookService(new BookServiceStub());
		action.execute();
		assertEquals(28, action.getResults().size());
	}

	class BookServiceStub implements BookService{

		@Override
		public List<Book> select(int pageNo, int pageView) {
			List<Book> results =  new java.util.LinkedList<Book>();
			results.add(createBook("GOSICKVIII下‐ゴシック・神々の黄昏‐","桜庭一樹","540"));
			results.add(createBook("急行アルプス殺人事件","西村京太郎","620"));
			results.add(createBook("相田みつを ザ・ベスト 一生感動一生青春","相田みつを","540"));
			results.add(createBook("初恋ソムリエ","初野晴","540"));
			results.add(createBook("「おじさん」的思考","内田樹","580"));
			results.add(createBook("文庫版 妖怪の理 妖怪の檻","京極夏彦","860"));
			results.add(createBook("玉ねぎフライパン作戦","椎名誠","620"));
			results.add(createBook("暗殺者メギド","渡辺裕之","620"));
			results.add(createBook("早春物語 赤川次郎ベストセレクション(17)","赤川次郎","500"));
			results.add(createBook("怖い絵 泣く女篇","中野京子","700"));
			results.add(createBook("スタンレー・ホークの事件簿I 仮面‐‐ペルソナ","山藍紫姫子　イ：本仁戻","580"));
			results.add(createBook("スノーフレーク","大崎梢　イ：中島梨絵","540"));
			results.add(createBook("ボクら星屑のダンス","佐倉淳一","780"));
			results.add(createBook("左近の桜","長野まゆみ　デ：角川書店装丁室西村弘美","580"));
			results.add(createBook("瑠璃の雫","伊岡瞬","820"));
			results.add(createBook("なんでもありか 静と理恵子の血みどろ絵日誌","伊集院静　著：西原理恵子　イ：西原理恵子","780"));
			results.add(createBook("はなたちばな亭恋空事","澤見彰","580"));
			results.add(createBook("美しき武士と騎士の寝室","桐生操","580"));
			results.add(createBook("魔界転生 下 山田風太郎ベストコレクション","山田風太郎","780"));
			results.add(createBook("魔界転生 上 山田風太郎ベストコレクション","山田風太郎","780"));
			results.add(createBook("荒俣宏の裏・世界遺産(3) 衛生博覧会を求めて","荒俣宏","860"));
			results.add(createBook("風のささやき 介護する人への13の話","姫野カオルコ","580"));
			results.add(createBook("ウェルカム トゥ パールハーバー(上)","西木正明","1100"));
			results.add(createBook("ウェルカム トゥ パールハーバー(下)","西木正明","1100"));
			results.add(createBook("別冊図書館戦争I 図書館戦争シリーズ(5)","有川浩　イ：徒花スクモ","660"));
			results.add(createBook("図書館革命 図書館戦争シリーズ4","有川浩　イ：徒花スクモ","700"));
			results.add(createBook("図書館危機 図書館戦争シリーズ3","有川浩　イ：徒花スクモ","700"));
			results.add(createBook("源氏物語 千年の謎","高山由紀子","660"));

			return results;
		}
		private Book createBook(String title ,String author , String price){
			Book result = new Book();
			result.setTitle(title);
			result.setAuthor(author);

			return result;
		}
		@Override
		public int getTotalCount() {
			return 28;
		}
		
	}
}
