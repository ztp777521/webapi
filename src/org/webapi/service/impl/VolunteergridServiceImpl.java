package org.webapi.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.webapi.dao.VolunteergridDao;
import org.webapi.entry.Volunteergrid;
import org.webapi.service.VolunteergridService;

@Service
public class VolunteergridServiceImpl extends BaseService<Volunteergrid> implements VolunteergridService{

	public VolunteergridDao volunteergridDao = null;
	
	public VolunteergridDao getVolunteergridDao() {
		return volunteergridDao;
	}

	@Resource
	public void setVolunteergridDao(VolunteergridDao volunteergridDao) {
		this.volunteergridDao = volunteergridDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(volunteergridDao);
	}

	/**
	 * 插入申请网格编号序列
	 */
	public Boolean addvolunteergrid(Volunteergrid volunteergrid)
			throws Exception {
		try {
			this.save(volunteergrid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
