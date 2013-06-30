package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.VolunteerDao;
import org.webapi.entry.Volunteer;

@Repository
public class VolunteerDaoImpl extends HibernateDao<Volunteer, Integer> implements VolunteerDao{
	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
