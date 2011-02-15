package org.mmpp.impruth.service;

import org.mmpp.impruth.model.ReleaseInformation;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ReleaseServiceImpl implements ReleaseService,HibernateTemplateWare {

	private HibernateTemplate _hibernateTemplate;
	@Override
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this._hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate(){
		return _hibernateTemplate;
	}

	@Override
	public ReleaseInformation find(String barcode) {
		return findSql("select r from ReleaseInformation r where barcode = '"+barcode+"'");
	}
	@Override
	public void save(ReleaseInformation releaseInformation) {
		getHibernateTemplate().save(releaseInformation);
	}
	@Override
	public ReleaseInformation findReleaseInformationById(int releaseId) {
		return findSql("select r from ReleaseInformation r where id = "+releaseId);
	}
	private ReleaseInformation findSql(String sql){
		java.util.List<ReleaseInformation> results = getHibernateTemplate().find(sql);
		if(results.size()!=1)
			return null;
		return results.get(0);

	}

}
