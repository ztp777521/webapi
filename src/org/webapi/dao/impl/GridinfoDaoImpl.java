package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.GridinfoDao;
import org.webapi.entry.Gridinfo;

@Repository
public class GridinfoDaoImpl extends HibernateDao<Gridinfo, Integer> implements GridinfoDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
