package org.mmpp.impruth.action;


/**
 * 書籍情報の削除を行うページアクション
 * @author mmpp kou
 *
 */
public class DeletePageAction extends AbstractMediaServicePageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer _id = null;
	public void setId(Integer id){
		_id = id;
	}
	public String execute(){

		
		getMediaService().delete(_id);
		
		return SUCCESS;
	}
}
