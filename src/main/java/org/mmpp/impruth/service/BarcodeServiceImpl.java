package org.mmpp.impruth.service;

import javassist.NotFoundException;

import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.model.Release;

import com.ECS.client.jax.ext.AwsHandlerResolver;

/**
 * バーコード検索サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BarcodeServiceImpl implements BarcodeService {
	/**
	 * リリース情報サービス
	 */
	private ReleaseService _releaseService;
	/**
	 * リリース情報サービスを格納します
	 * @param releaseService リリース情報サービス
	 */
	public void setReleaseService(ReleaseService releaseService){
		_releaseService =releaseService ;
	}
	/**
	 * リリース情報サービスを取得します
	 * @return リリース情報サービス
	 */
	private ReleaseService getReleaseService( ){
		return _releaseService;
	}
	@Override
	public Release scan(String barcode) throws NotFoundException {
		// サービスが存在するかの判断
		if(getReleaseService( )!=null){
			// DBから情報を取得する
			ReleaseInformation releaseInformation =  getReleaseService( ).find(barcode);
			if(releaseInformation!=null){
				Release release = Release.valueOf(releaseInformation);
				if(release!=null)
					return release;
			}
		}
		// キャッシュが存在しない場合
		// Amazonから情報を取得する
		Release release = lookupAmazon(barcode);
		if(release!=null && getReleaseService( )!=null){
				// DBに結果を保存します
				saveRelease(release);
		}
		return release;
	}
	/**
	 * Amazonからバーコードの情報を取得します
	 * @param barcorde
	 * @return
	 * @throws NotFoundException
	 */
	private Release lookupAmazon(String barcorde) throws NotFoundException {
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
				return Release.valueOf(item);
	        }
		}
	   System.out.println("  当該情報はありません！ ( barcode : " +  barcorde +" )");
	   throw new NotFoundException("当該情報はありません！ ( barcode : " +  barcorde +" )");
	}

	/**
	 * 検索結果をDBに保存します
	 * @param jsonBook
	 */
	private void saveRelease(Release release) {
		ReleaseInformation releaseInformation = castReleaseInformation(release); 
		getReleaseService().save(releaseInformation);
	}
	/**
	 * JSON(Amazon検索結果)からDB格納変数に変換します
	 * @param jsonBook JSON(Amazon検索結果)
	 * @return 内部格納変数
	 */
	private ReleaseInformation castReleaseInformation(Release release) {
		ReleaseInformation releaseInformation = new ReleaseInformation();
		releaseInformation.setBarcode(release.getBarcode());
		releaseInformation.setTitle(release.getTitle());
		releaseInformation.setAuthor(release.getAuthorName());
		releaseInformation.setPublisher(release.getPublishCompanyName());

		releaseInformation.setAmazonId(release.getASIN());
		releaseInformation.setAmazonImage(release.getImageUrl());

		return releaseInformation;
	}
}
