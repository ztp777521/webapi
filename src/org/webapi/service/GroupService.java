package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Group;

public interface GroupService extends ServiceSupport<Group>{

	/**
	 * 申请创建群
	 * @param group
	 * @return
	 * @throws Exception
	 */
	public Boolean addgroup(Group group)throws Exception;

	/**
	 * 查询群列表
	 * @param pageNo
	 * @param pageSize
	 * @param  
	 * @return
	 * @throws Exception
	 */
	public Page<Group> findgrouplist(Integer userid ,int pageNo, int pageSize)throws Exception;

	/**
	 *  查询群消息
	 * @param groupid
	 * @return
	 * @throws Exception
	 */
	public Group getgroup(int groupid)throws Exception;

}
