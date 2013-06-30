package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.ShopserviceDao;
import org.webapi.entry.Shopservice;

@Repository
public class ShopserviceDaoImpl extends HibernateDao<Shopservice,  Integer> implements ShopserviceDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
