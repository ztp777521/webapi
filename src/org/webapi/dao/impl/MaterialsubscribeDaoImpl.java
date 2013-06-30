package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.MaterialsubscribeDao;
import org.webapi.entry.Materialsubscribe;

@Repository
public class MaterialsubscribeDaoImpl extends HibernateDao<Materialsubscribe, Integer> implements MaterialsubscribeDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
