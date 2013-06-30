package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.GroupcareDao;
import org.webapi.entry.Groupcare;

@Repository
public class GroupcareDaoImpl extends HibernateDao<Groupcare, Integer> implements GroupcareDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
