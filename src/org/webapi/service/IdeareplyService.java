package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Ideareply;

public interface IdeareplyService extends ServiceSupport<Ideareply> {

	/**
	 * 查询意见回复信息
	 * @param ideaid
	 * @return
	 * @throws Exception
	 */
	public Page<Ideareply> findideareplylist(int ideaid ,int pageNo,int pageSize)throws Exception;

	/**
	 * 想意见表中插入数据
	 * @param ideareply
	 * @return
	 * @throws Exception
	 */
	public Boolean addideareply(Ideareply ideareply)throws Exception;

}
