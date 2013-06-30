package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.ShopDao;
import org.webapi.entry.Shop;

@Repository
public class ShopDaoImpl extends HibernateDao<Shop, Integer> implements ShopDao{

	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
