package test.org.mmpp.impruth.action;

import org.junit.Test;
import org.mmpp.impruth.action.ScanBarcodeJsonAction;
import org.mmpp.impruth.action.models.ScanBarcodeJsonBook;

import static org.junit.Assert.*;

/**
 * バーコードスキャンアクションテスト
 * @author mmpp kou
 *
 */
public class ScanBarcodeJsonActionTest {

	@Test
	public void testGetJsonBook(){
		ScanBarcodeJsonAction pageAction = new ScanBarcodeJsonAction();
		pageAction.setBarcode("9784047265868");
		assertEquals(pageAction.SUCCESS,pageAction.execute());
		ScanBarcodeJsonBook jsonBook = pageAction.getJsonBook();
		assertEquals("乙嫁語り 2巻 (ビームコミックス) (BEAM COMIX)", jsonBook.getTitle());
		assertEquals("森 薫", jsonBook.getAuthorName());
		assertEquals("9784047265868",jsonBook.getBarcode());
		assertEquals("エンターブレイン",jsonBook.getPublishCompanyName());
		assertEquals("4047265861",jsonBook.getId());
	}
	@Test
	public void testGetJsonBookEnglish(){
		ScanBarcodeJsonAction pageAction = new ScanBarcodeJsonAction();
		pageAction.setBarcode("9784840231428");
		assertEquals(pageAction.SUCCESS,pageAction.execute());
		ScanBarcodeJsonBook jsonBook = pageAction.getJsonBook();
		assertEquals("Head First Design Patterns", jsonBook.getTitle());
		assertEquals("[Elisabeth Freeman, Eric Freeman, Bert Bates, Kathy Sierra]", jsonBook.getAuthorName());
		assertEquals("978-0596007126",jsonBook.getBarcode());
		assertEquals("O'Reilly Media",jsonBook.getPublishCompanyName());
		assertEquals("0596007124",jsonBook.getId());
		assertEquals("2004-10-25",jsonBook.getReleaseDate());
		
	}
}
