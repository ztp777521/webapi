package org.webapi.service;

import org.webapi.entry.Volunteergrid;

public interface VolunteergridService extends ServiceSupport<Volunteergrid>{

	/**
	 * 插入申请网格编号序列
	 * @param volunteergrid
	 * @return
	 * @throws Exception
	 */
	public Boolean addvolunteergrid(Volunteergrid volunteergrid)throws Exception;
}
