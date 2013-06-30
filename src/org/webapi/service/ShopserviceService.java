package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Shopservice;

public interface ShopserviceService extends ServiceSupport<Shopservice>{

	/**
	 * 发布服务
	 * @param shopservicetow
	 * @return
	 * @throws Exception
	 */
	public Boolean addshopservice(Shopservice shopservicetow)throws Exception;

	/**
	 * 查看服务信息
	 * @return
	 * @throws Exception
	 */
	public Page<Shopservice> findshopservice(int pageNo,int pageSize)throws Exception;

}
