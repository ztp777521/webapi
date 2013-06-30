package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Integratematerial;

public interface IntegratematerialService extends ServiceSupport<Integratematerial>{

	/**
	 * 查询资料列表
	 * @param materialtypeid
	 * @throws Exception
	 */
	public Page<Integratematerial> findlist(int materialtypeid,int strmaterialstate,int showTypeid,int pageNo, int pageSize)throws Exception;
	
}
