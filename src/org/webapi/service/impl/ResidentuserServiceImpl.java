package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.ResidentuserDao;
import org.webapi.entry.Residentuser;
import org.webapi.service.ResidentuserService;

@Service
public class ResidentuserServiceImpl extends BaseService<Residentuser> implements ResidentuserService{

	public ResidentuserDao residentuserDao = null;
	
	public ResidentuserDao getResidentuserDao() {
		return residentuserDao;
	}
	@Resource
	public void setResidentuserDao(ResidentuserDao residentuserDao) {
		this.residentuserDao = residentuserDao;
	}
	
	@PostConstruct
	public void initObject() {
		initBaseDao(residentuserDao);
	}
	
	/**
	 * 根据用户id查询个人信息
	 */
	public Residentuser getresidentuser(Integer userid) throws Exception {
		Page<Residentuser> page = new Page<Residentuser>();
		page.setPageNo(1);
		page.setPageSize(1);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("useridEQ", userid);
		this.findPage(page, values);
		if(page.getResult().size() > 0)
			return page.getResult().get(0);
		else
			return null;
	}
	
	/**
	 * 用户登录
	 */
	public Residentuser login(String username, String password)
			throws Exception {
		Page<Residentuser> page = new Page<Residentuser>();
		page.setPageNo(1);
		page.setPageSize(1);
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("loginnameEQ", username);
		values.put("passwordEQ", password);
		this.findPage(page, values);
		if(page.getResult().size() > 0)
			return page.getResult().get(0);
		else
			return null;
	}
	
	/**
	 * 用户注册
	 */
	public Boolean register(Residentuser residentuser) throws Exception {
		try {
			this.save(residentuser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 修改用户
	 */
	public Boolean upuser(Residentuser residentuser) throws Exception {
		try {
			this.save(residentuser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
