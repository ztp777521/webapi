package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.VotevolunteerDao;
import org.webapi.entry.Votevolunteer;

@Repository
public class VotevolunteerDaoImpl extends HibernateDao<Votevolunteer, Integer> implements VotevolunteerDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
