package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.IntegratematerialDao;
import org.webapi.entry.Integratematerial;
import org.webapi.service.IntegratematerialService;

@Service
public class IntegratematerialServiceImpl extends BaseService<Integratematerial> implements IntegratematerialService{

	public IntegratematerialDao integratematerialDao = null;
	
	public IntegratematerialDao getIntegratematerialDao() {
		return integratematerialDao;
	}

	@Resource
	public void setIntegratematerialDao(IntegratematerialDao integratematerialDao) {
		this.integratematerialDao = integratematerialDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(integratematerialDao);
	}

	
	/**
	 * 查询资料信息
	 */
	public Page<Integratematerial> findlist(int materialtypeid,int materialstate,int showTypeid,int pageNo, int pageSize)
			throws Exception {
		Page<Integratematerial> page = new Page<Integratematerial>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String ,Object> values = new HashMap<String, Object>();
		if(materialtypeid != -1)
		{
			values.put("moduleTypeidEQ", materialtypeid);
		}
		if(materialstate != -1)
		{
			values.put("materialStateEQ", materialstate);
		}
		if(showTypeid != -1)
		{
			values.put("showTypeidEQ",showTypeid);
		}
		this.findPage(page, values);
		return page;
	}
}
