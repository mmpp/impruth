package org.mmpp.impruth.model;

public class HopeBookUserInformation {

	/**
	 * 登録日
	 */
	private String _updateDate;
	
	/**
	 * 希望レベル(S,A,B,C,D,E)
	 */
	private HopeLevel _level;

	public String getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this._updateDate = updateDate;
	}

	public HopeLevel getLevel() {
		return _level;
	}

	public void setLevel(HopeLevel level) {
		this._level = level;
	}

	
	
}
