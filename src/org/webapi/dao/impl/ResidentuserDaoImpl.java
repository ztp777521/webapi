package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.ResidentuserDao;
import org.webapi.entry.Residentuser;

@Repository
public class ResidentuserDaoImpl extends HibernateDao<Residentuser, Integer> implements ResidentuserDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
