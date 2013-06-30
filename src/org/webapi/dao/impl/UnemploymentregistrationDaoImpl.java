package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.UnemploymentregistrationDao;
import org.webapi.entry.Unemploymentregistration;

@Repository
public class UnemploymentregistrationDaoImpl extends HibernateDao<Unemploymentregistration, Integer> implements UnemploymentregistrationDao{

	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
