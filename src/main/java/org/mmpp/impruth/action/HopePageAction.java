package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.HopeTableBook;
import org.mmpp.impruth.action.service.HopePageActionService;
import org.mmpp.impruth.action.service.HopePageActionServiceImpl;
import org.mmpp.impruth.service.HopeService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 欲しい本一覧ページアクション
 * @author mmpp kou
 *
 */
public class HopePageAction extends ActionSupport implements HopeServiceAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public java.util.List<HopeTableBook> getHopeBooks(){
		return this.getService().list();
	}

	private HopePageActionService getService() {
		return new HopePageActionServiceImpl(this.getHopeService());
	}
	
	private HopeService _hopeService;
	public HopeService getHopeService() {
		return _hopeService;
	}

	public void setHopeService(HopeService hopeService) {
		_hopeService = hopeService;
	}


	public String onClickMeneHopeAdd(){
		return "hope_add";		
	}
	public String onClickMeneHope(){
		return "hope";
	}
	public String onClickMeneShelfList(){
		return "shelf_list";
	}

}
