package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.ScanBarcodeJsonBook;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 指定バーコードの検索を行い、JSON形式で返します.
 * @author mmpp kou
 *
 */
public class ScanBarcodeJsonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		if(_barcode==null)
			return ERROR;
		_jsonBook = scanWebBook();
		return SUCCESS;
	}
	private ScanBarcodeJsonBook scanWebBook() {
		ScanBarcodeJsonBook jsonBook = new ScanBarcodeJsonBook();

		// TODO Web amazon?からデータを抽出します
		jsonBook.setTitle("乙嫁語り 2巻 (ビームコミックス) (BEAM COMIX) [コミック]");
		jsonBook.setAuthorName("森 薫");
		jsonBook.setBarcode("978-4047265868");
		jsonBook.setPublishCompanyName("エンターブレイン");
		jsonBook.setId("4047265861");
		return jsonBook;
	}
	private String _barcode = null;
	/**
	 * バーコードを格納します
	 * @param barcode
	 */
	public void setBarcode(String barcode){
		_barcode = barcode;
	}
	/**
	 * 結果を格納します
	 */
	private ScanBarcodeJsonBook _jsonBook = null;
	/**
	 * 検索結果を取得します
	 * @return 検索結果
	 */
	public ScanBarcodeJsonBook getJsonBook(){
		return _jsonBook;
	}
}
