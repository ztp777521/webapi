package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Unemploymentregistration;

public interface UnemploymentregistrationService extends ServiceSupport<Unemploymentregistration>{

	/**
	 * 失业登记
	 * @param unemploymentregistration
	 * @return
	 * @throws Exception
	 */
	public Boolean addunemploymentregistration(Unemploymentregistration unemploymentregistration)throws Exception;

	/**
	 * 查询失业登记信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Page<Unemploymentregistration> findunempregreplist(int userid,int pageNo,int pageSize)throws Exception;

}
