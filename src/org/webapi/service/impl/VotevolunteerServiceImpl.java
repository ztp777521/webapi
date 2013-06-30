package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.VotevolunteerDao;
import org.webapi.entry.Votevolunteer;
import org.webapi.service.VotevolunteerService;

@Service
public class VotevolunteerServiceImpl extends BaseService<Votevolunteer> implements VotevolunteerService{

	public VotevolunteerDao votevolunteerDao = null;
	
	public VotevolunteerDao getVotevolunteerDao() {
		return votevolunteerDao;
	}
	
	@Resource
	public void setVotevolunteerDao(VotevolunteerDao votevolunteerDao) {
		this.votevolunteerDao = votevolunteerDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(votevolunteerDao);
	}

	/**
	 * 根据发起投票的id查询投票格长对应关系信息
	 */
	public Page<Votevolunteer> findvotevolunteer(int voteid,int pageNo,int pageSize)
			throws Exception {
		Page<Votevolunteer> page = new Page<Votevolunteer>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("voteidEQ", voteid);
		return page;
	}

}
