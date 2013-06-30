package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.GroupDao;
import org.webapi.entry.Group;
import org.webapi.service.GroupService;

@Service
public class GroupServiceImpl extends BaseService<Group> implements GroupService{

	public GroupDao groupDao = null;
	
	public GroupDao getGroupDao() {
		return groupDao;
	}

	@Resource
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(groupDao);
	}

	/**
	 * 申请创建群
	 */
	public Boolean addgroup(Group group) throws Exception {
		try {
			this.save(group);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询群列表
	 */
	public Page<Group> findgrouplist(Integer userid,int pageNo, int pageSize) throws Exception {
		Page<Group> page = new Page<Group>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String, Object> values = new HashMap<String, Object>();
		if(userid != null && userid > 0)
		{
			values.put("applyUseridEQ", userid);
		}
		values.put("groupStateEQ", 2);
		this.findPage(page, values);
		return page;
	}

	
	 /**
	  * 查询群消息
	  */
	public Group getgroup(int groupid) throws Exception {
		Page<Group> page = new Page<Group>();
		page.setPageNo(1);
		page.setPageSize(1);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("groupidEQ", groupid);
		if(page.getResult().size()>0)
			return page.getResult().get(0);
		else
			return null;
	}

}

