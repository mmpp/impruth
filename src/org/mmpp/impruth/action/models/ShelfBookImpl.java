package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.ShelfObject;

/**
 * 書籍情報画面管理クラス
 * @author mmpp kou
 *
 */
public class ShelfBookImpl extends ShelfObject implements ShelfBook{

	public ShelfBookImpl(){
		super();
		_updateDate =  new java.util.Date();
	}
	
	public java.util.Date _updateDate;

	public java.util.Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this._updateDate = updateDate;
	}

}
