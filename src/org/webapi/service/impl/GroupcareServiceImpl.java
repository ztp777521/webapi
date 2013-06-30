package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.GroupcareDao;
import org.webapi.entry.Groupcare;
import org.webapi.service.GroupcareService;

@Service
public class GroupcareServiceImpl extends BaseService<Groupcare> implements GroupcareService{

	public GroupcareDao groupcareDao = null;

	public GroupcareDao getGroupcareDao() {
		return groupcareDao;
	}

	@Resource
	public void setGroupcareDao(GroupcareDao groupcareDao) {
		this.groupcareDao = groupcareDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(groupcareDao);
	}

	/**
	 * 关注群
	 */
	public Boolean addgroupcare(Groupcare groupcare) throws Exception {
		try {
			this.save(groupcare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 取消关注群
	 */
	public Boolean delgroupcare(Groupcare groupcare) throws Exception {
		try {
			this.delete(groupcare.getGroupCareid());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据用户id查询群关注表
	 */
	public Page<Groupcare> findgroupcarelist(int userid) throws Exception {
		Page<Groupcare> page = new Page<Groupcare>();
		page.setPageNo(1);
		page.setPageSize(20);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("useridEQ", userid);
		this.findPage(page, values);
		return page;
	}

}
