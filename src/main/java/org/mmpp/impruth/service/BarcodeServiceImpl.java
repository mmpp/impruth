package org.mmpp.impruth.service;

import java.io.IOException;
import java.util.Properties;

import javassist.NotFoundException;

import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.model.Release;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ECS.client.jax.ext.AwsHandlerResolver;

/**
 * バーコード検索サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BarcodeServiceImpl implements BarcodeService {
	
	/**
	 * ログ
	 */
	protected static Logger log = LoggerFactory.getLogger( BarcodeServiceImpl.class ); 
	   
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

		// AmazonAssociateIDを読み込みます
		java.util.Properties amazonProperties = getAmazonPropetries();
		
		log.info("ScanBarcodeJson request : " + barcorde);

		log.debug("create service... ");
		com.ECS.client.jax.AWSECommerceService service = new com.ECS.client.jax.AWSECommerceService();
		service.setHandlerResolver(new AwsHandlerResolver((String)amazonProperties.get("secretAccessKey")));
		log.debug("created service! WSDLDocumentLocation : " + service.getWSDLDocumentLocation());

		log.debug("create service port ... ");
		com.ECS.client.jax.AWSECommerceServicePortType port = service.getAWSECommerceServicePort();
		// SOAP End point 変更... //
//	    ((javax.xml.ws.BindingProvider)port).getRequestContext().put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://ecs.amazonaws.jp/onca/soap?Service=AWSECommerceService");
		log.debug("created service port!");

		com.ECS.client.jax.ItemLookupRequest request = new com.ECS.client.jax.ItemLookupRequest();
		request.getItemId().add(barcorde);
		request.setIdType("ISBN");
		request.setSearchIndex("Books");
		request.getResponseGroup().add("Large");
		com.ECS.client.jax.ItemLookup body = new com.ECS.client.jax.ItemLookup();  
		body.setAWSAccessKeyId((String)amazonProperties.get("associateID"));
		body.setShared(request);  
		  
		log.debug("itemSearch ... ");
		com.ECS.client.jax.ItemLookupResponse response = port.itemLookup(body);
		log.debug("itemSearched ! ");
	
		log.info("response : "+response);
		for (com.ECS.client.jax.Items itemList : response.getItems()) {
			for (com.ECS.client.jax.Item item : itemList.getItem()){
				return Release.valueOf(item);
	        }
		}
		log.info("  当該情報はありません！ ( barcode : " +  barcorde +" )");
	   throw new NotFoundException("当該情報はありません！ ( barcode : " +  barcorde +" )");
	}

	private Properties _amazonProperties = null;
	private Properties getAmazonPropetries() {
		_amazonProperties = new java.util.Properties();
		final String filename = "amazon.properties";
		try {
			_amazonProperties.load(getClass().getClassLoader().getResourceAsStream(filename));
		} catch (IOException e) {
			log.warn(filename+"読み込み中に例外が発生しました",e);
		}
		return _amazonProperties;
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
