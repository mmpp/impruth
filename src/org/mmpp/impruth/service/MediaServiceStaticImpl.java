package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.service.MediaService;

import java.text.ParseException;

/**
 * メディア情報統合管理サービス実装
 * @author kou
 *
 */
public class MediaServiceStaticImpl implements MediaService {
	private List<ShelfObject> _shelfObjects=null;
		
	public MediaServiceStaticImpl(){
		super();
	}
	public ShelfObject find(Integer id) {
		for(ShelfObject shelfObject : findAll()){
			if(shelfObject.getId().equals(id))
				return shelfObject;
		}
		return null;
	}

	public List<ShelfObject> findAll() {

		if(_shelfObjects==null){
			_shelfObjects = new java.util.LinkedList<ShelfObject>();
			{
				ShelfObject shelfObject = new ShelfObject();
				shelfObject.setTitle("ONE PIECE");
				shelfObject.setNumber(1);
				shelfObject.setNumberValue("1");
				shelfObject.setAuthorName("尾田 栄一郎");
				shelfObject.setPublishCompanyName("集英社");
				shelfObject.setId(1);
//					shelfObject.setPictureFilename("img_949235_13311089_0.jpeg");
				_shelfObjects.add(shelfObject);
			}
			{
				ShelfObject shelfObject = new ShelfObject();
				shelfObject.setTitle("無限のリヴァイアス コンプリートアートワークス");
				shelfObject.setNumberValue("");
				shelfObject.setAuthorName("VA");
				shelfObject.setPublishCompanyName("新紀元社");
				shelfObject.setId(2);
				_shelfObjects.add(shelfObject);
			}
			{
				ShelfObject shelfObject = new ShelfObject();
				shelfObject.setTitle("狼と香辛料");
				shelfObject.setSubtitle("太陽の金貨＜下＞");
				shelfObject.setNumberValue("16");
				shelfObject.setNumber(16);
				shelfObject.setAuthorName("支倉 凍砂");
				shelfObject.setPublishCompanyName("アスキーメディアワークス");
				shelfObject.setPublishSeriesName("電撃文庫");
				shelfObject.setObjectKind("文庫");
				try {
					shelfObject.setReleaseDate((new java.text.SimpleDateFormat("yyyy/MM/dd")).parse("2011/2/10"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				shelfObject.setId(3);
				_shelfObjects.add(shelfObject);
			}
			{
				ShelfObject shelfObject = new ShelfObject();
				shelfObject.setTitle("ブギーポップ・アンノウン");
				shelfObject.setSubtitle("壊れかけのムーンライト");
				shelfObject.setNumberValue("17");
				shelfObject.setNumber(17);
				shelfObject.setAuthorName("上遠野 浩平,イラスト:緒方 剛志");
				shelfObject.setPublishCompanyName("アスキーメディアワークス");
				shelfObject.setPublishSeriesName("電撃文庫");
				shelfObject.setObjectKind("文庫");
				try {
					shelfObject.setReleaseDate((new java.text.SimpleDateFormat("yyyy/MM/dd")).parse("2011/1/10"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				shelfObject.setId(4);
				_shelfObjects.add(shelfObject);
			}
			{	ShelfObject shelfObject = valueOfShelfObject(5,"今日からマ王","故郷へ㋮のつく舵をとれ!","19",19,"喬林 知","角川文庫","角川ビーンズ文庫","文庫","9784044452209","2008/6/1");
				_shelfObjects.add(shelfObject);		}
			{	ShelfObject shelfObject = valueOfShelfObject(6,"今日からマ王","前は㋮のつく鉄格子!","20",20,"喬林 知","角川文庫","角川ビーンズ文庫","文庫","9784044452216","2009/1/1");
			_shelfObjects.add(shelfObject);		}
			{	ShelfObject shelfObject = valueOfShelfObject(7,"今日からマ王","後は㋮のつく石の壁!","21",21,"喬林 知","角川文庫","角川ビーンズ文庫","文庫","9784044452223","2010/1/1");
			_shelfObjects.add(shelfObject);		}

		}
		return _shelfObjects;
	}
	private ShelfObject valueOfShelfObject(int id, String title,String subtitle, String numberValue, int number, String authorName,
			String publishCompanyName, String publishSeriesName, String objectKind, String barcode,	String releaseDate) {
		ShelfObject shelfObject = new ShelfObject();
		shelfObject.setTitle(title);
		shelfObject.setSubtitle(subtitle);
		shelfObject.setNumberValue(numberValue);
		shelfObject.setNumber(number);
		shelfObject.setAuthorName(authorName);
		shelfObject.setPublishCompanyName(publishCompanyName);
		shelfObject.setPublishSeriesName(publishSeriesName);
		shelfObject.setObjectKind(objectKind);
		shelfObject.setBarcode(barcode);
		try {
			shelfObject.setReleaseDate((new java.text.SimpleDateFormat("yyyy/MM/dd")).parse(releaseDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		shelfObject.setId(id);
		return shelfObject;
	}
	public ShelfObject createNew() {
		ShelfObject shelfObject = new ShelfObject();
		shelfObject.setId(_shelfObjects.size()+1);

		return shelfObject;
	}
	public ShelfObject insert(ShelfObject shelfObject) {
		shelfObject.setId(_shelfObjects.size()+1);
		_shelfObjects.add(shelfObject);
		return shelfObject;
	}
	public ShelfObject delete(Integer id) {
		ShelfObject shelfObject = find(id);
		_shelfObjects.remove(shelfObject);
		return shelfObject;
	}

}
