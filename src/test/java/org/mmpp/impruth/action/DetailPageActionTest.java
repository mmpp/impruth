package org.mmpp.impruth.action;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mmpp.impruth.service.BookService;
import org.mmpp.impruth.service.model.Book;

/**
 * 
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class DetailPageActionTest {

	@Test
	public void testDetailTitle() throws Exception {
		DetailPageAction action = new DetailPageAction();
		action.setIsbn("97844584");
		action.setBookService(new BookService() {
			@Override public List<Book> select(int pageNo, int pageView) {	return null; }
			@Override	public int getTotalCount() { return 0; }
			@Override
			public Book find(String isbn) {
				Book book = new Book();
				book.setTitle("結果");
				return book;
			}
			@Override
			public List<Book> select(int pageNo, int pageView, String title) {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public int getTotalCount(String title) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		action.execute();
		assertEquals("結果", action.getDetail().getTitle());
	}

}
