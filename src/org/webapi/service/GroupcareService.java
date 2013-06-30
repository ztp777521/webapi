package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Groupcare;

public interface GroupcareService extends ServiceSupport<Groupcare>{

	/**
	 * 关注群
	 * @param groupcare
	 * @return
	 * @throws Exception
	 */
	public Boolean addgroupcare(Groupcare groupcare)throws Exception;

	/**
	 * 取消关注群
	 * @param groupcare
	 * @return
	 * @throws Exception
	 */
	public Boolean delgroupcare(Groupcare groupcare)throws Exception;

	/**
	 * 根据用户id查询群关注表信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Page<Groupcare> findgroupcarelist(int userid)throws Exception;

}
