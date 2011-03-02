package test.org.mmpp.impruth.action;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mmpp.impruth.action.IndexPageAction;
import org.mmpp.impruth.action.models.IndexDetailElement;
import org.mmpp.impruth.action.models.IndexTableListElement;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.service.MediaService;
import org.mmpp.impruth.service.ReleaseService;

import static org.junit.Assert.*;

public class IndexPageActionTest {

	
	@Test
	public void testExecute(){
	
		IndexPageAction action = new IndexPageAction();
		String result = action.execute();
		assertEquals(action.SUCCESS,result);
	}
	@Test
	public void testExecuteDetail(){
	
		IndexPageAction action = new IndexPageAction();
		action.setIsbn("9784840224888");
		String result = action.execute();
		assertEquals(action.DETAIL,result);
	}
	@Test
	public void testGetList(){
	
		IndexPageAction action = new IndexPageAction();
		action.setReleaseService(new ReleaseService() {
			@Override
			public void save(ReleaseInformation releaseInformation) {}
			@Override
			public ReleaseInformation findReleaseInformationById(int releaseId) {return null;}
			@Override
			public ReleaseInformation find(String barcode) {	return null;}
			@Override
			public java.util.List<ReleaseInformation> findAll() {
				java.util.List<ReleaseInformation>  results = new LinkedList<ReleaseInformation>();
				results.add(new ReleaseInformation("半分の月がのぼる空―looking up at the half‐moon (電撃文庫)", "橋本紡", "9784840224888"));
				return results;
			}
			});
		String result = action.execute();
		assertEquals(action.SUCCESS,result);
		assertNotNull(action.getList());
		assertEquals(1,action.getList().size());
		IndexTableListElement indexTableListElement = action.getList().get(0);
		assertNotNull(indexTableListElement);
		assertEquals("半分の月がのぼる空―looking up at the half‐moon (電撃文庫)",indexTableListElement.getTitle());
		assertEquals("橋本紡",indexTableListElement.getAuthor());
		assertEquals("9784840224888",indexTableListElement.getBarcode());
	}
	@Test
	public void testGetDetail(){
	
		IndexPageAction action = new IndexPageAction();
		String result = action.execute();
		assertEquals(action.SUCCESS,result);
		{
			// 詳細画面表示エレメント //
			IndexDetailElement indexDetailElement = action.getDetail();
			assertNull("アクションなしの場合",indexDetailElement);
		}
		action.setReleaseService(new ReleaseService() {
			private final ReleaseInformation RESULT = new ReleaseInformation("半分の月がのぼる空―looking up at the half‐moon (電撃文庫)", "橋本紡", "9784840224888");
			@Override
			public void save(ReleaseInformation releaseInformation) {}
			@Override
			public ReleaseInformation findReleaseInformationById(int releaseId) {return null;}
			@Override
			public ReleaseInformation find(String barcode) {
				return RESULT;
			}
			@Override
			public java.util.List<ReleaseInformation> findAll() {
				java.util.List<ReleaseInformation>  results = new LinkedList<ReleaseInformation>();
				results.add(RESULT);
				return results;
			}
			});
		{
			// 詳細画面表示エレメント //
			IndexDetailElement indexDetailElement = action.getDetail();
			assertNull("アクションなしの場合",indexDetailElement);
		}
		action.setIsbn("9784840224888");
		{
			// 詳細画面表示エレメント //
			IndexDetailElement indexDetailElement = action.getDetail();
			assertNotNull(indexDetailElement);
			assertEquals("半分の月がのぼる空―looking up at the half‐moon (電撃文庫)",indexDetailElement.getTitle());
			assertEquals("橋本紡",indexDetailElement.getAuthor());
			assertEquals("9784840224888",indexDetailElement.getBarcode());
		}
	}
}
