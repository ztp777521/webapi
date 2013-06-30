package org.webapi.service;

import org.springside.modules.orm.Page;
import org.webapi.entry.Shop;

public interface ShopService extends ServiceSupport<Shop>{

	/**
	 * 申请服务商户
	 * @param shop
	 * @return
	 * @throws Exception
	 */
	public Boolean addshop(Shop shop)throws Exception;

	/**
	 * 根据用户id查询商户信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Page<Shop> getshopall(int userid,int pageNo,int pageSize)throws Exception;

}
