package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.IdeaDao;
import org.webapi.entry.Idea;
import org.webapi.service.IdeaService;

@Service
public class IdeaServiceImpl extends BaseService<Idea> implements IdeaService{

	public IdeaDao ideaDao = null;
	
	
	public IdeaDao getIdeaDao() {
		return ideaDao;
	}

	@Resource
	public void setIdeaDao(IdeaDao ideaDao) {
		this.ideaDao = ideaDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(ideaDao);
	}

	/**
	 * 查看意见列表
	 */
	public Page<Idea> findidealist(int userid, int ispublic ,int pageNo, int pageSize) throws Exception {
		Page<Idea> page = new Page<Idea>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String ,Object> values = new HashMap<String, Object>();
		if(userid != -1)
		{
			values.put("userIdEQ", userid);
		}
		if(ispublic != -1)
		{
			values.put("ispublicEQ", ispublic);
		}
		this.findPage(page, values);
		return page;
	}

	/**
	 * 提交意见
	 */
	public Boolean addremark(Idea idea) throws Exception {
		try {
			this.save(idea);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
