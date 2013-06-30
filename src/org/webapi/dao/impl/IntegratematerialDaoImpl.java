package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.IntegratematerialDao;
import org.webapi.entry.Integratematerial;

@Repository
public class IntegratematerialDaoImpl extends HibernateDao<Integratematerial, Integer> implements IntegratematerialDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}

