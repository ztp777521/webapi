package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.UnemploymentreplyDao;
import org.webapi.entry.Unemploymentreply;

@Repository
public class UnemploymentreplyDaoImpl extends HibernateDao<Unemploymentreply, Integer> implements UnemploymentreplyDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
