package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Unemploymentreply;

public interface UnemploymentreplyService extends ServiceSupport<Unemploymentreply>{

	/**
	 * 查询回复信息
	 * @param unempRegid
	 * @return
	 * @throws Exception
	 */
	public Page<Unemploymentreply> findunemploymentreply(int unempRegid)throws Exception;

	/**
	 * 根据失业登记id查询失业登记回复信息
	 * @param unempRegid
	 * @return
	 */
	public Page<Unemploymentreply> getreplylist(int userid,int pageNo,int pageSize) throws Exception;

}
