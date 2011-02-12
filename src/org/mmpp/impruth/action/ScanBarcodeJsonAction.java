package org.mmpp.impruth.action;

import javassist.NotFoundException;

import javax.xml.ws.Holder;

import org.mmpp.impruth.action.models.ScanBarcodeJsonBook;

import com.ECS.client.jax.ext.AwsHandlerResolver;
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
		try {
			_jsonBook = scanWebBook();
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	private ScanBarcodeJsonBook scanWebBook() throws NotFoundException {

		// TODO Web amazon?からデータを抽出します
		ScanBarcodeJsonBook jsonBook = lookupAmazon(getBarcorde());
		return jsonBook;
	}
	
	private ScanBarcodeJsonBook lookupAmazon(String barcorde) throws NotFoundException {
		// AmazonAssociateID.
		// TODO Amazon AssociateIDは環境変数で定義すること
		String amazonAssociateID = "AKIAJREFU54PMFQ5DVCQ";
		String amazonSecretAccessKey = "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";
		
			System.out.println("create service... ");
		com.ECS.client.jax.AWSECommerceService service = new com.ECS.client.jax.AWSECommerceService();
		service.setHandlerResolver(new AwsHandlerResolver(amazonSecretAccessKey));
		System.out.println("created service! WSDLDocumentLocation : " + service.getWSDLDocumentLocation());

			System.out.println("create service port ... ");
		com.ECS.client.jax.AWSECommerceServicePortType port = service.getAWSECommerceServicePort();
		// SOAP End point 変更... //
//	    ((javax.xml.ws.BindingProvider)port).getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://ecs.amazonaws.jp/onca/soap?Service=AWSECommerceService");
			System.out.println("created service port!");

		
//			System.out.println("create ItemSearchRequest... ");
//		com.ECS.client.jax.ItemSearchRequest itemRequest = new com.ECS.client.jax.ItemSearchRequest();
//		itemRequest.setSearchIndex("Books");
//		itemRequest.setKeywords("dog");
////		itemRequest.setVersion("2010-10-01");
//			System.out.println("created ItemSearchRequest ! ");

//			System.out.println("create ItemSearch ... ");
//			com.ECS.client.jax.ItemSearch itemSearch = new com.ECS.client.jax.ItemSearch();
//			
//			itemSearch.setAWSAccessKeyId(amazonAssociateID);
//			itemSearch.getRequest().add(itemRequest);
//				System.out.println("created ItemSearch! ");


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
			ScanBarcodeJsonBook jsonBook = new ScanBarcodeJsonBook();
	        for (com.ECS.client.jax.Items itemList : response.getItems()) {
	            for (com.ECS.client.jax.Item item : itemList.getItem()){
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
	        		
	                System.out.println("Book Name: " + 
	                item.getItemAttributes().getTitle()+ " " +  
	                item.getItemAttributes().getAuthor() + " " + 
	                item.getItemAttributes().getPublicationDate() + " " +
	                item.getItemAttributes().getPublisher() + " " + 
	                item.getItemAttributes().getISBN() + " " + 
	                item.getItemAttributes().getEAN() + " " + 
	                item.getItemAttributes().getEdition()
	                );
	                return jsonBook;
	            }        
	        }

	   throw new NotFoundException("当該情報はありません！ ( barcode : " +  barcorde +" )");
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
}
