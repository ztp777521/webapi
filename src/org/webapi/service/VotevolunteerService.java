package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Votevolunteer;

public interface VotevolunteerService extends ServiceSupport<Votevolunteer>{

	/**
	 * 根据发起投票的id查询投票对应关系信息
	 * @param volunteerid
	 * @return
	 * @throws Exception
	 */
	public Page<Votevolunteer> findvotevolunteer(int voteid,int pageNo,int pageSize)throws Exception;

}
