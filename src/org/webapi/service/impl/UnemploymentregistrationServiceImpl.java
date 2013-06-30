package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.UnemploymentregistrationDao;
import org.webapi.entry.Unemploymentregistration;
import org.webapi.service.UnemploymentregistrationService;

@Service
public class UnemploymentregistrationServiceImpl extends BaseService<Unemploymentregistration> implements UnemploymentregistrationService{

	public UnemploymentregistrationDao unemploymentregistrationDao = null;
	
	public UnemploymentregistrationDao getUnemploymentregistrationDao() {
		return unemploymentregistrationDao;
	}

	@Resource
	public void setUnemploymentregistrationDao(
			UnemploymentregistrationDao unemploymentregistrationDao) {
		this.unemploymentregistrationDao = unemploymentregistrationDao;
	}


	@PostConstruct
	public void initObject() {
		initBaseDao(unemploymentregistrationDao);
	}

	/**
	 * 失业登记
	 */
	public Boolean addunemploymentregistration(Unemploymentregistration unemploymentregistration) throws Exception {
		try {
			this.save(unemploymentregistration);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询失业登记信息
	 */
	public Page<Unemploymentregistration> findunempregreplist(int userid,int pageNo,int pageSize)throws Exception {
		Page<Unemploymentregistration> page = new Page<Unemploymentregistration>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("useridEQ", userid);
		this.findPage(page, values);
		return page;
	}
}
