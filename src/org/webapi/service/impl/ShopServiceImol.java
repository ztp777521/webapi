package org.webapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springside.modules.orm.Page;
import org.webapi.dao.ShopDao;
import org.webapi.entry.Shop;
import org.webapi.service.ShopService;

@Service
public class ShopServiceImol extends BaseService<Shop> implements ShopService{

	public ShopDao shopDao = null;
	
	public ShopDao getShopDao() {
		return shopDao;
	}

	@Resource
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	@PostConstruct
	public void initObject() {
		initBaseDao(shopDao);
	}

	
	/**
	 * 申请服务商户
	 */
	public Boolean addshop(Shop shop) throws Exception {
		try {
			this.save(shop);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据id查询商户服务信息
	 */
	public Page<Shop> getshopall(int userid,int pageNo,int pageSize) throws Exception {
		Page<Shop> page = new Page<Shop>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("useridEQ", userid);
		this.findPage(page, values);
		return page;
	}
	

}
