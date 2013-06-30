package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Launchvote;


public interface LaunchvoteService extends ServiceSupport<Launchvote>{

	/**
	 * 查询未结束的发起投票列表
	 * @return
	 * @throws Exception
	 */
	public Page<Launchvote> findlaunchvotelist(int pageNo,int pageSize)throws Exception;

}
