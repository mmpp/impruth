package org.mmpp.impruth.action;

import javassist.NotFoundException;


import org.mmpp.impruth.action.models.ScanBarcodeJsonBook;
import org.mmpp.impruth.service.BarcodeService;
import org.mmpp.impruth.service.model.Release;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 指定バーコードの検索を行い、JSON形式で返します.
 * @author mmpp kou
 *
 */
public class ScanBarcodeJsonAction extends ActionSupport{

	/**
	 * バーコードサービス
	 */
	private BarcodeService _barcodeService;
	
	/**
	 * バーコードサービスを格納します
	 * @param barcodeService バーコードサービス
	 */
	public void setBarcodeService(BarcodeService barcodeService){
		_barcodeService = barcodeService;
	}
	/**
	 * バーコードサービスを取得します
	 * @return バーコードサービス
	 */
	private BarcodeService getBarcodeService(){
		return _barcodeService;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception{
		if(_barcode==null)
			return ERROR;
		try {
			// バーコードをスキャンします
			Release release = getBarcodeService().scan(getBarcode());
			if(release!=null)
				_jsonBook =  ScanBarcodeJsonBook.valueOf(release);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	private String _barcode = null;
	/**
	 * バーコードを格納します
	 * @param barcode
	 */
	public void setBarcode(String barcode){
		_barcode = barcode;
	}
	private String getBarcode(){
		return _barcode;
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
