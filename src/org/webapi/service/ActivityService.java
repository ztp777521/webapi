package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Activity;

public interface ActivityService extends ServiceSupport<Activity>{

	/**
	 * 发起活动
	 * @param activty
	 * @return
	 * @throws Exception
	 */
	public Boolean addactivty(Activity activty)throws Exception;

	/**
	 * 查看活动信息
	 * @param groupid
	 * @return
	 */
	public Activity getActivty(int groupid)throws Exception;

	/**
	 * 根据用户的id查询未过期的活动列表
	 * @param userid
	 * @return
	 */
	public Page<Activity> findactivitylist(int userid,int pageNo,int pageSize)throws Exception;


}
