package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.IdeaDao;
import org.webapi.entry.Idea;

@Repository
public class IdeaDaoImpl extends HibernateDao<Idea, Integer> implements IdeaDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
