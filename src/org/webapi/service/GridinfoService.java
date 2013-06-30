package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Gridinfo;

public interface GridinfoService extends ServiceSupport<Gridinfo>{

	/**
	 * 查询网格编号
	 * @param pageno
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public Page<Gridinfo> findgridinfolist(int pageno, int pagesize)throws Exception;

}
