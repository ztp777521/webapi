package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.IdeareplyDao;
import org.webapi.entry.Ideareply;
import org.webapi.service.IdeareplyService;

@Service
public class IdeareplyServiceImpl extends BaseService<Ideareply> implements IdeareplyService{

	public IdeareplyDao ideareplyDao = null;
	
	public IdeareplyDao getIdeareplyDao() {
		return ideareplyDao;
	}

	@Resource
	public void setIdeareplyDao(IdeareplyDao ideareplyDao) {
		this.ideareplyDao = ideareplyDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(ideareplyDao);
	}

	/**
	 * 查询意见回复信息
	 */
	public Page<Ideareply> findideareplylist(int ideaid,int pageNo ,int pageSize) throws Exception 
	{
		Page<Ideareply> page = new Page<Ideareply>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("ideaIdEQ", ideaid);
		return page;
	}

	/**
	 * 想意见表中插入数据
	 */
	public Boolean addideareply(Ideareply ideareply) throws Exception {
		try {
			this.save(ideareply);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
