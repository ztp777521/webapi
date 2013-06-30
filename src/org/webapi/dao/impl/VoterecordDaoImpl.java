package org.webapi.dao.impl;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;
import org.webapi.dao.VoterecordDao;
import org.webapi.entry.Voterecord;

@Repository
public class VoterecordDaoImpl extends HibernateDao<Voterecord, Integer> implements VoterecordDao{

	public long countHqlResult(String hql, Object... values)
	{
		return super.countHqlResult(hql, values);
	}
}
