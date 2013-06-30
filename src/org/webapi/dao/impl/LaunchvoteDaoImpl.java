package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.LaunchvoteDao;
import org.webapi.entry.Launchvote;

@Repository
public class LaunchvoteDaoImpl extends HibernateDao<Launchvote, Integer> implements LaunchvoteDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
