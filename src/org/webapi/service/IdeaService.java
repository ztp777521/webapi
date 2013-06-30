package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Idea;

public interface IdeaService extends ServiceSupport<Idea> {

	/**
	 * 查询意见列表
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Page<Idea> findidealist(int userid, int ispublic ,int pageNo, int pageSize)throws Exception;

	/**
	 * 提交意见
	 * @param idea
	 * @return
	 * @throws Exception
	 */
	public Boolean addremark(Idea idea)throws Exception;

}
