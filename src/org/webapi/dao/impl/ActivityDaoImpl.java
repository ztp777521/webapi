package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.ActivityDao;
import org.webapi.entry.Activity;

@Repository
public class ActivityDaoImpl extends HibernateDao<Activity, Integer> implements ActivityDao{

	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
