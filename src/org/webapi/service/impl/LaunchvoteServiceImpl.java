package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.LaunchvoteDao;
import org.webapi.entry.Launchvote;
import org.webapi.service.LaunchvoteService;

@Service
public class LaunchvoteServiceImpl extends BaseService<Launchvote> implements LaunchvoteService{

	public LaunchvoteDao launchvoteDao = null;
	
	public LaunchvoteDao getLaunchvoteDao() {
		return launchvoteDao;
	}

	@Resource
	public void setLaunchvoteDao(LaunchvoteDao launchvoteDao) {
		this.launchvoteDao = launchvoteDao;
	}
	
	@PostConstruct
	public void initObject() {
		initBaseDao(launchvoteDao);
	}

	/**
	 * 查询未结束的发起投票列表
	 */
	public Page<Launchvote> findlaunchvotelist(int pageNo,int pageSize) throws Exception {
		Page<Launchvote> page = new Page<Launchvote>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("voteTimeStartGE", new java.util.Date());
		values.put("voteTimeStartLE", new java.util.Date());
		this.findPage(page, values);
		return page;
	}

}
