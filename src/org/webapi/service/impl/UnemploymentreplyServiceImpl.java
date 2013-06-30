package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.UnemploymentreplyDao;
import org.webapi.entry.Unemploymentreply;
import org.webapi.service.UnemploymentreplyService;

@Service
public class UnemploymentreplyServiceImpl extends BaseService<Unemploymentreply> implements UnemploymentreplyService{

	public UnemploymentreplyDao unemploymentreplyDao = null;
	
	public UnemploymentreplyDao getUnemploymentreplyDao() {
		return unemploymentreplyDao;
	}

	@Resource
	public void setUnemploymentreplyDao(UnemploymentreplyDao unemploymentreplyDao) {
		this.unemploymentreplyDao = unemploymentreplyDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(unemploymentreplyDao);
	}

	/**
	 * 查询回复信息
	 */
	public Page<Unemploymentreply> findunemploymentreply(int unempRegid)throws Exception {
		Page<Unemploymentreply> page = new Page<Unemploymentreply>();
		page.setPageNo(1);
		page.setPageSize(15);
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("unempRegidEQ", unempRegid);
		this.findPage(page, values);
		return page;
	}

	/**
	 * 根据失业登记id查询失业登记回复信息
	 */
	public Page<Unemploymentreply> getreplylist(int userid,int pageNo,int pageSize)throws Exception {
		Page<Unemploymentreply> page = new Page<Unemploymentreply>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String, Object> values = new HashMap<String, Object>();
		if(userid > 0)
			values.put("replyUseridEQ", userid);
		else 
			return null;
		this.findPage(page, values);
		return page;
	}
}
