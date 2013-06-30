package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.GroupDao;
import org.webapi.entry.Group;

@Repository
public class GroupDaoImpl extends HibernateDao<Group, Integer> implements GroupDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
