package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.VolunteergridDao;
import org.webapi.entry.Volunteergrid;

@Repository
public class VolunteergridDaoImpl extends HibernateDao<Volunteergrid, Integer> implements VolunteergridDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
