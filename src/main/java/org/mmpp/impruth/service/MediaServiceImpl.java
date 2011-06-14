package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.Media;
import org.mmpp.impruth.model.ShelfObject;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class MediaServiceImpl implements MediaService,HibernateTemplateWare{
	 private HibernateTemplate _hibernateTemplate;
	@Override
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
    	this._hibernateTemplate = hibernateTemplate;
    }
    public HibernateTemplate getHibernateTemplate(){
    	return _hibernateTemplate;
    }
	    
	@Override
	public List<ShelfObject> findAll() {
		List<Media> results = getHibernateTemplate().find("select m from Media m ");
		List<ShelfObject>  findAlls = new java.util.LinkedList<ShelfObject> ();
		for(Media media : results){
			ShelfObject shelfObject = castShelfObject(media);
			findAlls.add(shelfObject);
		}
		return findAlls;
	}

	private ShelfObject castShelfObject(Media media) {
		ShelfObject shelfObject = new ShelfObject();
		shelfObject.setId(media.getId());
		shelfObject.setTitle(media.getTitle());
		shelfObject.setNumber(media.getVolume());
		shelfObject.setNumberValue(media.getVolumeValue());
		
		return shelfObject;
	}
	@Override
	public ShelfObject find(Integer id) {
		List<Media> results = getHibernateTemplate().find("select m from Media m where id = " + id);
		return castShelfObject(results.get(0));
	}

	@Override
	public ShelfObject createNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShelfObject insert(ShelfObject shelfObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShelfObject delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

   

}
