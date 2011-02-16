package org.mmpp.impruth.action;

import javassist.NotFoundException;


import org.mmpp.impruth.action.models.ScanBarcodeJsonBook;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.ReleaseService;

import com.ECS.client.jax.Item;
import com.ECS.client.jax.ext.AwsHandlerResolver;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 指定バーコードの検索を行い、JSON形式で返します.
 * @author mmpp kou
 *
 */
public class ScanBarcodeJsonAction extends ActionSupport{

	private ReleaseService _releaseService;
	public void setReleaseService(ReleaseService releaseService){
		_releaseService =releaseService ;
	}
	private ReleaseService getReleaseService( ){
		return _releaseService;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		if(_barcode==null)
			return ERROR;
		try {
			_jsonBook = scanWebBook();
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	private ScanBarcodeJsonBook scanWebBook() throws NotFoundException {
		String barcode = getBarcorde( );
		ScanBarcodeJsonBook jsonBook=null;
		// サービスが存在するかの判断
		if(getReleaseService( )!=null){
			// DBから情報を取得する
			ReleaseInformation releaseInformation =  getReleaseService( ).find(barcode);
			if(releaseInformation!=null)
				jsonBook = castScanBarcodeJsonBook(releaseInformation);
		}
		if(jsonBook==null){
			// Amazonから情報を取得する
			jsonBook = lookupAmazon(barcode);
			if(jsonBook!=null && getReleaseService( )!=null){
					// DBに結果を保存します
					saveLoadJsonBook(jsonBook);
			}
		}
		return jsonBook;
	}
	/**
	 * Amazonからバーコードの情報を取得します
	 * @param barcorde
	 * @return
	 * @throws NotFoundException
	 */
	private ScanBarcodeJsonBook lookupAmazon(String barcorde) throws NotFoundException {
		// AmazonAssociateID.
		// TODO Amazon AssociateIDは環境変数で定義すること
		String amazonAssociateID = "AKIAJREFU54PMFQ5DVCQ";
		String amazonSecretAccessKey = "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";
		System.out.println("ScanBarcodeJson request : " + barcorde);

			System.out.println("create service... ");
		com.ECS.client.jax.AWSECommerceService service = new com.ECS.client.jax.AWSECommerceService();
		service.setHandlerResolver(new AwsHandlerResolver(amazonSecretAccessKey));
		System.out.println("created service! WSDLDocumentLocation : " + service.getWSDLDocumentLocation());

			System.out.println("create service port ... ");
		com.ECS.client.jax.AWSECommerceServicePortType port = service.getAWSECommerceServicePort();
		// SOAP End point 変更... //
//	    ((javax.xml.ws.BindingProvider)port).getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://ecs.amazonaws.jp/onca/soap?Service=AWSECommerceService");
			System.out.println("created service port!");

		com.ECS.client.jax.ItemLookupRequest request = new com.ECS.client.jax.ItemLookupRequest();
		request.getItemId().add(barcorde);
		request.setIdType("ISBN");
		request.setSearchIndex("Books");
		request.getResponseGroup().add("Large");
		com.ECS.client.jax.ItemLookup body = new com.ECS.client.jax.ItemLookup();  
		body.setAWSAccessKeyId(amazonAssociateID);
		body.setShared(request);  
		  
			System.out.println("itemSearch ... ");
		com.ECS.client.jax.ItemLookupResponse response = port.itemLookup(body);
			System.out.println("itemSearched ! ");
	
			System.out.println("response : "+response);
		for (com.ECS.client.jax.Items itemList : response.getItems()) {
			for (com.ECS.client.jax.Item item : itemList.getItem()){
				return castScanBarcodeJsonBook(item);
	        }
		}
	   System.out.println("  当該情報はありません！ ( barcode : " +  barcorde +" )");
	   throw new NotFoundException("当該情報はありません！ ( barcode : " +  barcorde +" )");
	}

	private ScanBarcodeJsonBook castScanBarcodeJsonBook(Item item) {
		ScanBarcodeJsonBook jsonBook = new ScanBarcodeJsonBook();
		jsonBook.setTitle(item.getItemAttributes().getTitle());
		StringBuffer autorNameResult = new StringBuffer();;
		for(String authorName : item.getItemAttributes().getAuthor()){
			if(autorNameResult.length()>0)
    			autorNameResult.append(",");
			autorNameResult.append(authorName);
		}
		jsonBook.setAuthorName(autorNameResult.toString());
		jsonBook.setBarcode(item.getItemAttributes().getEAN());
		jsonBook.setPublishCompanyName(item.getItemAttributes().getPublisher());
		jsonBook.setId(item.getASIN());
		jsonBook.setReleaseDate(item.getItemAttributes().getPublicationDate());
	    	
		jsonBook.setASIN(item.getASIN());
		try{
			jsonBook.setImageUrl(item.getImageSets().get(0).getImageSet().get(0).getMediumImage().getURL());
		}catch(java.lang.IndexOutOfBoundsException e){}

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
	private String getBarcorde(){
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
	
	/**
	 * 内部データベース形式からJSON形式に変換します
	 * @param releaseInformation 内部リリース情報
	 * @return JSON形式
	 */
	private ScanBarcodeJsonBook castScanBarcodeJsonBook(ReleaseInformation releaseInformation) {
		ScanBarcodeJsonBook jsonBook = new ScanBarcodeJsonBook();
		jsonBook.setBarcode(releaseInformation.getBarcode());
		jsonBook.setAuthorName(releaseInformation.getAuthor());
		jsonBook.setTitle(releaseInformation.getTitle());
		jsonBook.setPublishCompanyName(releaseInformation.getPublisher());
		jsonBook.setId(String.valueOf(releaseInformation.getId()));
		jsonBook.setReleaseDate("");
		jsonBook.setASIN(releaseInformation.getAmazonId());
		jsonBook.setImageUrl(releaseInformation.getAmazonImage());
		System.out.println("DB cast : barcode : " + releaseInformation.getBarcode()+" title : " + releaseInformation.getTitle());
		return jsonBook;
	}
	/**
	 * 検索結果をDBに保存します
	 * @param jsonBook
	 */
	private void saveLoadJsonBook(ScanBarcodeJsonBook jsonBook) {
		ReleaseInformation releaseInformation = castReleaseInformation(jsonBook); 
		getReleaseService().save(releaseInformation);
	}
	/**
	 * JSON(Amazon検索結果)からDB格納変数に変換します
	 * @param jsonBook JSON(Amazon検索結果)
	 * @return 内部格納変数
	 */
	private ReleaseInformation castReleaseInformation(ScanBarcodeJsonBook jsonBook) {
		ReleaseInformation releaseInformation = new ReleaseInformation();
		releaseInformation.setBarcode(jsonBook.getBarcode());
		releaseInformation.setTitle(jsonBook.getTitle());
		releaseInformation.setAuthor(jsonBook.getAuthorName());
		releaseInformation.setPublisher(jsonBook.getPublishCompanyName());

		releaseInformation.setAmazonId(jsonBook.getASIN());
		releaseInformation.setAmazonImage(jsonBook.getImageUrl());

		return releaseInformation;
	}

}
