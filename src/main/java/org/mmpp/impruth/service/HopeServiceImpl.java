package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.HopeBook;
import org.mmpp.impruth.model.HopeBookUserInformation;
import org.mmpp.impruth.model.HopeLevel;

public class HopeServiceImpl implements HopeService {

	/**
	 * 書庫管理サービス
	 */
	private MediaService _mediaService;
	
	public void setMediaService(MediaService mediaService){
		this._mediaService = mediaService;
	}
	/**
	 * 書庫管理サービスを取得する
	 * @return 書庫管理サービス
	 */
	private MediaService getMediaService(){
		return _mediaService;
	}
	public List<HopeBook> findAll(String userName) {
		List<HopeBook> results = new java.util.LinkedList<HopeBook>();
		{	HopeBook hopeBook = valueOfHopeBook("wataru775",3,"S","2010/12/09");
			results.add(hopeBook);	}
		{	HopeBook hopeBook = valueOfHopeBook("wataru775",4,"S","2010/12/09");
		results.add(hopeBook);	}
		{	HopeBook hopeBook = valueOfHopeBook("wataru775",5,"C","2010/12/09");
		results.add(hopeBook);	}
		{	HopeBook hopeBook = valueOfHopeBook("wataru775",6,"C","2010/12/09");
		results.add(hopeBook);	}
		{	HopeBook hopeBook = valueOfHopeBook("wataru775",7,"C","2010/12/09");
		results.add(hopeBook);	}
//		{	HopeBook hopeBook = valueOfHopeBook("wataru775",8,"C","2010/12/09");
//		results.add(hopeBook);	}

		return results;
	}
	private HopeBook valueOfHopeBook(String userName,int id, String level, String updateDate) {
//		User user = new User();
//		user.setAccount("wataru775");
//		user.setUserName("WATARU");
//		hopeBook.setUser(user);
		HopeBookUserInformation	userInformation = new HopeBookUserInformation();
		userInformation.setUpdateDate(updateDate);
		userInformation.setLevel(HopeLevel.valueOf(HopeLevel.class, level));
		
		HopeBook hopeBook = HopeBook.valueOf( this.getMediaService().find(id),userInformation);
		return hopeBook;
	}

}
