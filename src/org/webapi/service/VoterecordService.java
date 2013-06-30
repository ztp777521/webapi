package org.webapi.service;

import org.webapi.entry.Voterecord;

public interface VoterecordService extends ServiceSupport<Voterecord>{

	/**
	 * 发起投票
	 * @param voterecord
	 * @return
	 * @throws Exception
	 */
	public Boolean addvotecode(Voterecord voterecord)throws Exception;

}
