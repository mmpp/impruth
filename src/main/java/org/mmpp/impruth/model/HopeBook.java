package org.mmpp.impruth.model;


/**
 * ユーザ希望書籍情報
 * @author mmpp kou
 *
 */
public class HopeBook {

	/**
	 * ユーザ情報
	 */
	private User _user;
	
	/**
	 * 書籍情報
	 */
	private ShelfObject _shelfObject;
	
	/**
	 * 希望情報
	 */
	private HopeBookUserInformation _hopeInformation;

	public User getUser() {
		return _user;
	}

	public void setUser(User user) {
		this._user = user;
	}

	public ShelfObject getShelfObject() {
		return _shelfObject;
	}

	public void setShelfObject(ShelfObject shelfObject) {
		this._shelfObject = shelfObject;
	}

	public HopeBookUserInformation getHopeInformation() {
		return _hopeInformation;
	}

	public void setHopeInformation(HopeBookUserInformation userInformation) {
		this._hopeInformation = userInformation;
	}

	public static HopeBook valueOf(ShelfObject shelfObject,HopeBookUserInformation userInformation) {

		HopeBook hopeBook = new HopeBook();

		hopeBook.setShelfObject(shelfObject);
		hopeBook.setHopeInformation(userInformation);

		return hopeBook;
	}
	
	
}
