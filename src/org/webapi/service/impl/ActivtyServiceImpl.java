package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.ActivityDao;
import org.webapi.entry.Activity;
import org.webapi.service.ActivityService;

@Service
public class ActivtyServiceImpl extends BaseService<Activity> implements ActivityService{

	public ActivityDao activityDao = null;
	
	public ActivityDao getActivityDao() {
		return activityDao;
	}

	@Resource
	public void setActivityDao(ActivityDao ActivityDao) {
		this.activityDao = ActivityDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(activityDao);
	}

	
	/**
	 * 发起活动
	 */
	public Boolean addactivty(Activity activity) throws Exception {
		try {
			this.save(activity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * 查看活动
	 */
	public Activity getActivty(int groupid) throws Exception {
		Page<Activity> page = new Page<Activity>();
		page.setPageNo(1);
		page.setPageSize(1);
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("groupidEQ", groupid);
		this.findPage(page, values);
		if(page.getResult().size() > 0)
			return page.getResult().get(0);
		else
			return new Activity();
	}

	
	/**
	 * 根据用户的id查询未过期的活动列表
	 * userId 用户名
	 * pageNo 当前页数
	 * pageSize 一页显示的行数
	 */
	public Page<Activity> findactivitylist(int userid,int pageNo,int pageSize) throws Exception {
		Page<Activity> page = new Page<Activity>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String , Object> values = new HashMap<String, Object>();
		values.put("useridEQ", userid);
		this.findPage(page,values);
		return page;
	}

}
