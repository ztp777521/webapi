package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.GridinfoDao;
import org.webapi.entry.Gridinfo;
import org.webapi.service.GridinfoService;

@Service
public class GridinfoServiceImpl extends BaseService<Gridinfo> implements GridinfoService{

	public GridinfoDao gridinfoDao = null;
	
	public GridinfoDao getGridinfoDao() {
		return gridinfoDao;
	}

	@Resource
	public void setGridinfoDao(GridinfoDao gridinfoDao) {
		this.gridinfoDao = gridinfoDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(gridinfoDao);
	}

	/**
	 * 查询网格编号
	 */
	public Page<Gridinfo> findgridinfolist(int pageno, int pagesize)
			throws Exception 
	{
		Page<Gridinfo> page = new Page<Gridinfo>();
		page.setPageNo(pageno);
		page.setPageSize(pagesize);
		Map<String, Object> values = new HashMap<String, Object>();
		this.findPage(page, values);
		return page;
	}

}
