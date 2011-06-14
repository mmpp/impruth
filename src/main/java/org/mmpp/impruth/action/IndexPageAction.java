package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.IndexTableListElement;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.ReleaseService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 書籍情報ページアクション
 * @author kou
 *
 */
public class IndexPageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String DETAIL = "detail";

	private ReleaseService _releaseService;
	
	public String execute() {
		if(_isbn!=null)
			return DETAIL;
		return SUCCESS;
	}

	/**
	 * 詳細情報表示ISBNコード
	 */
	private String _isbn=null;
	public void setIsbn(String isbn) {
		_isbn = isbn;
	}
	public String getIsbn() {
		return _isbn;
	}
	public void setReleaseService(ReleaseService releaseService) {
		_releaseService = releaseService;		
	}
	public ReleaseService getReleaseService() {
		return _releaseService;		
	}

	/**
	 * 書籍一覧テーブル情報を取得します
	 * @return 書籍一覧テーブル内容
	 */
	public java.util.List<IndexTableListElement> getList() {
		java.util.List<IndexTableListElement> results = new java.util.LinkedList<IndexTableListElement>();
		if(getReleaseService()==null)
			return null;
		
		for(ReleaseInformation releaseInformation : getReleaseService().findAll()){
			IndexTableListElement indexTableListElement = IndexTableListElement.valueOf(releaseInformation);
			results.add(indexTableListElement);
		}
		
		return results;
	}

	public org.mmpp.impruth.action.models.IndexDetailElement getDetail() {
		if(getReleaseService()==null)
			return null;
		String isbn = getIsbn();
		if(isbn==null)
			return null;
		ReleaseInformation releaseInformation = getReleaseService().find(isbn);
		org.mmpp.impruth.action.models.IndexDetailElement result = org.mmpp.impruth.action.models.IndexDetailElement.valueOf(releaseInformation);
		return result;
	}

}
