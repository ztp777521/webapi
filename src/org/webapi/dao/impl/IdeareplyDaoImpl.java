package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.IdeareplyDao;
import org.webapi.entry.Ideareply;

@Repository
public class IdeareplyDaoImpl extends HibernateDao<Ideareply, Integer> implements IdeareplyDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
